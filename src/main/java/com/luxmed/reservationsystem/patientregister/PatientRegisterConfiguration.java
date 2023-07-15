package com.luxmed.reservationsystem.patientregister;

public class PatientRegisterConfiguration {

    PatientRegisterFacade createForTest(PatientRepository repository){
        PatientRegisterValidator validator = new PatientRegisterValidator();
        PatientMapper mapper = new PatientMapper();
        return new PatientRegisterFacade(repository,validator,mapper);
    }

}
