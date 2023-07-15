package com.luxmed.reservationsystem.doctoravialibilityspecifier;

import com.luxmed.reservationsystem.doctorregister.Doctor;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.time.LocalDate;
import java.time.LocalTime;

@With
@Value
@Builder
public class Visit{
        LocalDate date;
        LocalTime beginningOfVisit;
        LocalTime endOfVisit;
        Doctor doctor;
}
