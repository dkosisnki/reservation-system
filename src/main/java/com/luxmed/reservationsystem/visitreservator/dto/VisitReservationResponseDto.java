package com.luxmed.reservationsystem.visitreservator.dto;

public record VisitReservationResponseDto(
        ReservationResult result
) {
    public enum ReservationResult{
        SUCCESS,
        FAILED
    }
}

