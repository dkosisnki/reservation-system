package com.luxmed.reservationsystem.doctoravialibilityspecifier;

import com.luxmed.reservationsystem.doctoravialibilityspecifier.dto.SingleDoctorAvailabilityDto;
import com.luxmed.reservationsystem.doctorregister.DoctorEntity;

public class DoctorAvailabilityMapper {
    public Visit mapToVisit(SingleDoctorAvailabilityDto availability) {
        return Visit.builder()
                .date(availability.date())
                .beginningOfVisit(availability.beginningOfVisits())
                .endOfVisit(availability.endOfVisits())
                .build();
    }

    VisitEntity mapToVisitEntity(Visit visit){
        return VisitEntity.builder()
                .doctor(DoctorEntity.builder()
                        .medicalLicense(visit.getDoctor().getMedicalLicense())
                        .build())
                .visitDate(visit.getDate())
                .beginningOfVisit(visit.getBeginningOfVisit())
                .endOfVisit(visit.getEndOfVisit())
                .build();
    }
}
