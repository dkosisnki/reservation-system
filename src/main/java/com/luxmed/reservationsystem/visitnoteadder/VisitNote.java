package com.luxmed.reservationsystem.visitnoteadder;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class VisitNote {

    private final Integer visitNoteId;
    private final String visitNoteCode;
    private final String doctorNote;
}
