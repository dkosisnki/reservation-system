package com.luxmed.reservationsystem.doctoravialibilityspecifier;

import com.luxmed.reservationsystem.doctoravialibilityspecifier.dto.AvailabilityResponseDto;
import com.luxmed.reservationsystem.doctoravialibilityspecifier.dto.DoctorAvailabilityRequestDto;
import com.luxmed.reservationsystem.doctorregister.DoctorRegisterFacade;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;

import static com.luxmed.reservationsystem.doctoravialibilityspecifier.DoctorAvailabilityValidator.ValidationResult.INPUT_DATA_DOCTOR_NO_REGISTERED;
import static com.luxmed.reservationsystem.doctoravialibilityspecifier.DoctorAvailabilityValidator.ValidationResult.INPUT_DATA_SUCCESS;

@AllArgsConstructor
public class DoctorAvailabilitySpecifierFacade {

    private final DoctorAvailabilityRepository doctorAvailabilityRepository;
    private final DoctorRegisterFacade doctorRegisterFacade;
    private final DoctorAvailabilityValidator availabilityValidator;
    private final DoctorAvailabilityPreparerator availabilityPreparerator;
    private final DoctorAvailabilityMapper doctorAvailabilityMapper;

    public AvailabilityResponseDto determineAvailability(DoctorAvailabilityRequestDto request) {
        if (!isDoctorRegistered(request)) {
            return AvailabilityResponseDto.builder()
                    .responseMessage(INPUT_DATA_DOCTOR_NO_REGISTERED.message)
                    .build();
        }

        if (Objects.nonNull(availabilityValidator.validate(request))){
            return AvailabilityResponseDto.builder()
                    .responseMessage(availabilityValidator.createErrorMessage())
                    .build();
        }

        List<Visit> visits = availabilityPreparerator.prepareVisits(request);
        List<VisitEntity> visitsEntity = visits.stream()
                .map(doctorAvailabilityMapper::mapToVisitEntity)
                .toList();

        doctorAvailabilityRepository.saveAll(visitsEntity);

        return AvailabilityResponseDto.builder()
                .responseMessage(INPUT_DATA_SUCCESS.message)
                .build();
    }

    private boolean isDoctorRegistered(DoctorAvailabilityRequestDto request) {
        return doctorRegisterFacade.isDoctorRegistered(request.medicalLicense());
    }




}
