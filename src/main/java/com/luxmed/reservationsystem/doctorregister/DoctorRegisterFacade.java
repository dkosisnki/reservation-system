package com.luxmed.reservationsystem.doctorregister;

import com.luxmed.reservationsystem.doctorregister.dto.DoctorRegisterRequestDto;
import com.luxmed.reservationsystem.doctorregister.dto.DoctorRegisterResponseDto;
import lombok.AllArgsConstructor;

import static com.luxmed.reservationsystem.doctorregister.DoctorRegisterValidator.ValidationResult.INPUT_DATA_SUCCESS;

@AllArgsConstructor
public class DoctorRegisterFacade {

    private final DoctorRepository doctorRepository;
    private final DoctorRegisterValidator doctorRegisterValidator;
    private final DoctorMapper doctorMapper;

    public DoctorRegisterResponseDto register(DoctorRegisterRequestDto request){
        if (!doctorRegisterValidator.validate(request).isEmpty()) {
            return DoctorRegisterResponseDto.builder()
                    .responseMessage(doctorRegisterValidator.createErrorMessage())
                    .build();
        } else {

            Doctor doctor = Doctor.builder()
                    .name(request.name())
                    .surname(request.surname())
                    .pesel(request.pesel())
                    .medicalLicense(request.medicalLicense())
                    .email(request.email())
                    .build();

            DoctorEntity doctorEntity = doctorMapper.mapToEntity(doctor);

            doctorRepository.save(doctorEntity);
            return DoctorRegisterResponseDto.builder()
                    .responseMessage(INPUT_DATA_SUCCESS.message)
                    .build();
        }
    }

    public boolean isDoctorRegistered(String license){
        return doctorRepository.findByMedicalLicense(license).isPresent();
    }
}
