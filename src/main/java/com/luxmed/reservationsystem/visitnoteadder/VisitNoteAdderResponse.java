package com.luxmed.reservationsystem.visitnoteadder;

enum VisitNoteAdderResponse {

    SUCCESS("Visit note added successfully"),
    FAIL("Visit with passed visit code does not exist!");

    final String message;

    VisitNoteAdderResponse(String message) {
        this.message = message;
    }
}
