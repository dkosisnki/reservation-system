package com.luxmed.reservationsystem.doctorregister.dto;

import lombok.Builder;

@Builder
public record DoctorRegisterResponseDto(
        String responseMessage
) {
}
