package com.luxmed.reservationsystem.visitnotechecker.dto;

import com.luxmed.reservationsystem.visitnoteadder.dto.VisitNoteDto;
import lombok.Builder;

@Builder
public record VisitNoteCheckerResponseDto(
        String responseMessage,
        Integer visitCode,
        String doctorNote
) {
}
