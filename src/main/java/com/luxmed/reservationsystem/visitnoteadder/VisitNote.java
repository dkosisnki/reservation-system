package com.luxmed.reservationsystem.visitnoteadder;

import com.luxmed.reservationsystem.doctoravialibilityspecifier.Visit;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class VisitNote {

    private final Integer visitNoteId;
    private final Integer visitNoteCode;
    private final String doctorNote;
    private final Visit visit;

}
