package com.luxmed.reservationsystem.patientregister.dto;

import lombok.Builder;

@Builder
public record PatientRegisterResponseDto(
        String responseMessage
) {
}
