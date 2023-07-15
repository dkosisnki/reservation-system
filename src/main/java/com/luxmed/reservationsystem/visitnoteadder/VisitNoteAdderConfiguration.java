package com.luxmed.reservationsystem.visitnoteadder;

import com.luxmed.reservationsystem.visithistorychecker.VisitHistoryCheckerFacade;

public class VisitNoteAdderConfiguration {

    VisitNoteAdderFacade createForTest(VisitNoteRepository repository, VisitHistoryCheckerFacade visitHistoryCheckerFacade){
        VisitNoteMapper mapper = new VisitNoteMapper();
        return new VisitNoteAdderFacade(repository,visitHistoryCheckerFacade,mapper);
    }
}
