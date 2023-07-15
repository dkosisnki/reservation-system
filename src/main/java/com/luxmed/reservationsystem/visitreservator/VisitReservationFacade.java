package com.luxmed.reservationsystem.visitreservator;

import com.luxmed.reservationsystem.visitreservator.dto.ReservationRequestDto;
import com.luxmed.reservationsystem.visitreservator.dto.VisitReservationResponseDto.ReservationResult;
import com.luxmed.reservationsystem.visitreservator.dto.VisitReservationResponseDto;

public class VisitReservationFacade {

    public VisitReservationResponseDto makeReservation(ReservationRequestDto request){

        return new VisitReservationResponseDto(ReservationResult.SUCCESS);
    }

}
