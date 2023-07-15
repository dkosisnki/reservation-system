package com.luxmed.reservationsystem.doctoravialibilityspecifier;

import com.luxmed.reservationsystem.doctoravialibilityspecifier.dto.DoctorAvailabilityRequestDto;
import com.luxmed.reservationsystem.doctoravialibilityspecifier.dto.SingleDoctorAvailabilityDto;
import com.luxmed.reservationsystem.doctorregister.Doctor;
import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

@AllArgsConstructor
public class DoctorAvailabilityPreparerator {

    private final DoctorAvailabilityMapper doctorAvailabilityMapper;

    List<Visit> prepareVisits(DoctorAvailabilityRequestDto request) {
        List<Visit> visits = request.availabilities().stream()
                .map(doctorAvailabilityMapper::mapToVisit)
                .toList();

        visits.forEach(visit -> visit.withDoctor(
                Doctor.builder()
                        .medicalLicense(request.medicalLicense())
                        .build()
        ));
        return visits;
    }

    Visit someMethod(SingleDoctorAvailabilityDto availability) {
        LocalTime startOfWork = availability.beginningOfVisits();
        LocalTime endOfWork = availability.endOfVisits();
        Duration durationOfVisit = Duration.ofMinutes(30);

        long numberOfVisit = Duration.between(startOfWork, endOfWork).dividedBy(durationOfVisit);

        List<Visit> visits = new ArrayList<>();

        LongStream.iterate(0, previous -> previous + durationOfVisit.toMinutes())
                .limit(numberOfVisit)
                .forEach(el -> {
                    visits.add(
                            Visit.builder()
                                    .beginningOfVisit(startOfWork.plusMinutes(el))
                                    .build());
                }
                );
        return null;
    }

//         public Visit mapToVisit(SingleDoctorAvailabilityDto availability) {
//             return Visit.builder()
//                     .date(availability.date())
//                     .beginningOfVisits(availability.beginningOfVisits())
//                     .endOfVisits(availability.endOfVisits())
//                     .build();
//        LocalTime startOfWork = request.beginningOfVisits();
//        LocalTime endOfWork = request.endOfVisits();
//
//        long numberOfVisits = Duration.between(startOfWork, endOfWork).dividedBy(Duration.ofMinutes(15));
//
//
//        List<VisitEntity> availabilities = new ArrayList<>();
//
//        for (int i = 0, counter = 0; i < numberOfVisits; i++, counter += 15) {
//            VisitEntity visit = VisitEntity.builder()
//                    .doctor(DoctorEntity.builder()
//                            .medicalLicense(request.medicalLicense())
//                            .build())
//                    .visitDate(OffsetDateTime.of(
//                            request.date(),
//                            startOfWork.plusMinutes(counter),
//                            ZoneOffset.UTC
//                    ))
//                    .build();
//            availabilities.add(visit);
//        }
//        return availabilities;
}


