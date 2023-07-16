package com.luxmed.reservationsystem.visitnoteadder.dto;

import lombok.Builder;

@Builder
public record VisitNoteDto(
        Integer visitCode,
        String doctorNote
) {

}
