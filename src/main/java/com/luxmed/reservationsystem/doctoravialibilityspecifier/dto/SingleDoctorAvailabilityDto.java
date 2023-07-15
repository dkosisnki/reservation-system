package com.luxmed.reservationsystem.doctoravialibilityspecifier.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public record SingleDoctorAvailabilityDto(
        LocalDate date,
        LocalTime beginningOfVisits,
        LocalTime endOfVisits
) {
}
