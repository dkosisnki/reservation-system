package com.luxmed.reservationsystem.visitnotechecker;

import com.luxmed.reservationsystem.visitnoteadder.VisitNoteAdderFacade;

public class VisitNoteCheckerConfiguration {

    VisitNoteCheckerFacade createForTest(VisitNoteAdderFacade visitNoteAdderFacade){
        return new VisitNoteCheckerFacade(visitNoteAdderFacade);
    }
}

