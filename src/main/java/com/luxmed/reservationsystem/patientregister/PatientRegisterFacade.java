package com.luxmed.reservationsystem.patientregister;

import com.luxmed.reservationsystem.patientregister.PatientRegisterValidator.ValidationResult;
import com.luxmed.reservationsystem.patientregister.dto.PatientRegisterRequestDto;
import com.luxmed.reservationsystem.patientregister.dto.PatientRegisterResponseDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PatientRegisterFacade {

    private final PatientRepository patientRepository;
    private final PatientRegisterValidator validator;
    private final PatientMapper patientMapper;

    public PatientRegisterResponseDto register(PatientRegisterRequestDto request) {
        if (!validator.validate(request).isEmpty()) {
            return PatientRegisterResponseDto.builder()
                    .responseMessage(validator.createErrorMessage())
                    .build();
        } else {

            Patient patient = Patient.builder()
                    .name(request.name())
                    .surname(request.surname())
                    .pesel(request.pesel())
                    .email(request.email())
                    .build();

            PatientEntity patientEntity = patientMapper.mapToEntity(patient);

            patientRepository.save(patientEntity);
            return PatientRegisterResponseDto.builder()
                    .responseMessage(ValidationResult.INPUT_DATA_SUCCESS.message)
                    .build();
        }
    }
}
