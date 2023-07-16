package com.luxmed.reservationsystem.visitnotechecker;

enum VisitNoteCheckerResponse {

    SUCCESS("Visit note found successfully"),
    FAIL_VISIT_DOES_NOT_EXIST("Visit with passed visit code does not exist!"),
    FAIL_VISIT_DOES_NOT_HAVE_NOTE("Visit with passed visit code does not have doctor note.");

    final String message;

    VisitNoteCheckerResponse(String message) {
        this.message = message;
    }
}
