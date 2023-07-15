package com.luxmed.reservationsystem.doctoravialibilityspecifier.dto;

import lombok.Builder;

@Builder
public record AvailabilityResponseDto(
        String responseMessage
) {
}
