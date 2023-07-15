package com.luxmed.reservationsystem.doctoravialibilityspecifier;

import com.luxmed.reservationsystem.doctorregister.DoctorRegisterFacade;

public class DoctorAvailabilitySpecifierConfiguration {

    DoctorAvailabilitySpecifierFacade createForTest(
            DoctorAvailabilityRepository repository, DoctorRegisterFacade doctorRegisterFacade
    ){
        DoctorAvailabilityMapper mapper = new DoctorAvailabilityMapper();
        DoctorAvailabilityPreparerator doctorAvailabilityPreparerator = new DoctorAvailabilityPreparerator(mapper);
        DoctorAvailabilityValidator doctorAvailabilityValidator = new DoctorAvailabilityValidator(repository);
        return new DoctorAvailabilitySpecifierFacade(
                repository,
                doctorRegisterFacade,
                doctorAvailabilityValidator,
                doctorAvailabilityPreparerator,
                mapper
        );
    }
}
