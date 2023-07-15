package com.luxmed.reservationsystem.visitreservator.dto;

import java.time.LocalDateTime;

public record ReservationRequestDto(
        String patientLogin,
        LocalDateTime visitDate
) {
}
