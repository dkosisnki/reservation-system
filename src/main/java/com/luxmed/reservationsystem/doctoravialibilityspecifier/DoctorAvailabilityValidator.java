package com.luxmed.reservationsystem.doctoravialibilityspecifier;

import com.luxmed.reservationsystem.doctoravialibilityspecifier.dto.DoctorAvailabilityRequestDto;
import com.luxmed.reservationsystem.doctoravialibilityspecifier.dto.SingleDoctorAvailabilityDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class DoctorAvailabilityValidator {

    private final DoctorAvailabilityRepository repository;
    private ValidationResult error;


    ValidationResult validate(DoctorAvailabilityRequestDto request) {
        List<SingleDoctorAvailabilityDto> visitsWhichAlreadyExists = request.availabilities().stream()
                .filter(availability -> repository.findByVisitDate(availability.date()).isPresent())
                .filter(availability -> repository.findByBeginningOfVisit(availability.beginningOfVisits()).isPresent())
                .filter(availability -> repository.findByEndOfVisit(availability.beginningOfVisits()).isPresent())
                .toList();

        if (!visitsWhichAlreadyExists.isEmpty()){
            error = ValidationResult.INPUT_DATA_VISITS_ALREADY_EXIST;
        }
        return error;
    }

    String createErrorMessage() {
        return error.message;
    }

    enum ValidationResult {
        INPUT_DATA_SUCCESS("Availability set correctly!"),
        INPUT_DATA_VISITS_ALREADY_EXIST("You have already defined availabilities on this date."),

        INPUT_DATA_DOCTOR_NO_REGISTERED("You are not found in our doctor register");

        ValidationResult(String message) {
            this.message = message;
        }

        final String message;
    }
}
