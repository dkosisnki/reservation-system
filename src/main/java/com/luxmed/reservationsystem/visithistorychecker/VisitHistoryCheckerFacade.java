package com.luxmed.reservationsystem.visithistorychecker;

import com.luxmed.reservationsystem.visithistorychecker.dto.VisitHistoryRequestDto;
import com.luxmed.reservationsystem.visithistorychecker.dto.VisitHistoryResponseDto;

public class VisitHistoryCheckerFacade {

    public VisitHistoryResponseDto checkVisitHistory(VisitHistoryRequestDto request){
        return new VisitHistoryResponseDto();
    }

    public boolean visitExists(Integer visitId) {
        return true;
    }
}
