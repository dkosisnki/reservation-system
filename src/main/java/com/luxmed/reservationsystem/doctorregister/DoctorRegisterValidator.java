package com.luxmed.reservationsystem.doctorregister;

import com.luxmed.reservationsystem.doctorregister.dto.DoctorRegisterRequestDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


class DoctorRegisterValidator {

    private List<ValidationResult> errors;

    //TODO Z CZASEM DO USUNIECA
    List<ValidationResult> validate(DoctorRegisterRequestDto request){
        errors = new ArrayList<>();
        if (Objects.isNull(request.login()) || request.login().isEmpty()){
            errors.add(ValidationResult.INPUT_DATA_MISSING_LOGIN);
        } if (Objects.isNull(request.password()) || request.password().isEmpty()){
            errors.add(ValidationResult.INPUT_DATA_MISSING_PASSWORD);
        } if (Objects.isNull(request.email()) || request.email().isEmpty()) {
            errors.add(ValidationResult.INPUT_DATA_MISSING_EMAIL);
        } if (Objects.isNull(request.name()) || request.name().isEmpty()) {
            errors.add(ValidationResult.INPUT_DATA_MISSING_NAME);
        } if (Objects.isNull(request.surname()) || request.surname().isEmpty()) {
            errors.add(ValidationResult.INPUT_DATA_MISSING_SURNAME);
        }  if (Objects.isNull(request.pesel()) || request.pesel().isEmpty()) {
            errors.add(ValidationResult.INPUT_DATA_MISSING_PESEL);
        }  if (Objects.isNull(request.medicalLicense()) || request.medicalLicense().isEmpty()) {
            errors.add(ValidationResult.INPUT_DATA_MISSING_MEDICAL_LICENSE);
        }
        return errors;
    }

    String createErrorMessage(){
        return errors.stream()
                .map(validationResult -> validationResult.message)
                .reduce((previous, next) -> previous + ", "+ next)
                .orElse("");
    }

    enum ValidationResult{
        INPUT_DATA_SUCCESS("Patient registered correctly"),
        INPUT_DATA_MISSING_LOGIN("Login is required, please pass your login"),
        INPUT_DATA_MISSING_PASSWORD("Password is required, please pass your password"),
        INPUT_DATA_MISSING_NAME("Name is required, please pass your name"),
        INPUT_DATA_MISSING_SURNAME("Surname is required, please pass your surname"),
        INPUT_DATA_MISSING_PESEL("Pesel is required, please pass your pesel"),
        INPUT_DATA_MISSING_MEDICAL_LICENSE("Medical license is required, please pass your medical license"),
        INPUT_DATA_MISSING_EMAIL("Email is required, please pass your email");

        ValidationResult(String message) {
            this.message = message;
        }
        final String message;
    }
}
