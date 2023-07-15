package com.luxmed.reservationsystem.patientregister.dto;

import lombok.Builder;

@Builder
public record PatientRegisterRequestDto(
        String login,
        String password,
        String name,
        String surname,
        String pesel,
        String email
) {
}

