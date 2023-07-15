package com.luxmed.reservationsystem.doctorregister;

public class DoctorRegisterConfigurator {

   DoctorRegisterFacade createForTest(DoctorRepository repository){
        DoctorRegisterValidator validator = new DoctorRegisterValidator();
        DoctorMapper mapper = new DoctorMapper();
        return new DoctorRegisterFacade(repository,validator,mapper);
    }

}
