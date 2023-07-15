package com.luxmed.reservationsystem.patientregister;

import com.luxmed.reservationsystem.patientregister.dto.PatientRegisterRequestDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class PatientRegisterValidator {

    private List<ValidationResult> errors;

    //TODO z czasem do usuniecia
    List<ValidationResult> validate(PatientRegisterRequestDto request){
        errors = new ArrayList<>();
        if (Objects.isNull(request.login()) || request.login().isEmpty()){
             errors.add(ValidationResult.INPUT_DATA_MISSING_LOGIN);
        } if (Objects.isNull(request.password()) || request.password().isEmpty()){
            errors.add(ValidationResult.INPUT_DATA_MISSING_PASSWORD);
        } if (Objects.isNull(request.email()) || request.email().isEmpty()) {
            errors.add(ValidationResult.INPUT_DATA_MISSING_EMAIL);
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
        INPUT_DATA_MISSING_LOGIN("Login is required, please pass login"),
        INPUT_DATA_MISSING_PASSWORD("Password is required, please pass password"),

        INPUT_DATA_MISSING_EMAIL("Email is required, please pass email");

        ValidationResult(String message) {
            this.message = message;
        }
        final String message;
    }

}


