package com.luxmed.reservationsystem.visitnoteadder.dto;

import lombok.Builder;

@Builder
public record VisitNoteAdderRequestDto(

    Integer visitCode,
    String doctorNote

) {
}
