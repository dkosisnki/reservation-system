package com.luxmed.reservationsystem.visitnotechecker.dto;

import lombok.Builder;

@Builder
public record VisitNoteCheckerRequestDto(
        Integer visitCode
) {
}
