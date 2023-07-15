package com.luxmed.reservationsystem.doctoravialibilityspecifier.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record DoctorAvailabilityRequestDto(

        List<SingleDoctorAvailabilityDto> availabilities,

        String medicalLicense
) {

}
