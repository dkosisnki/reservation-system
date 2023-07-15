package com.luxmed.reservationsystem.doctorregister.dto;

import lombok.Builder;

@Builder
public record DoctorRegisterRequestDto(
        String login,
        String password,
        String name,
        String surname,
        String pesel,
        String medicalLicense,
        String email
) {
}
