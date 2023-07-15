package com.luxmed.reservationsystem.visitnoteadder.dto;

import lombok.Builder;

@Builder
public record VisitNoteAdderResponseDto(
        String responseMessage
) {

}
