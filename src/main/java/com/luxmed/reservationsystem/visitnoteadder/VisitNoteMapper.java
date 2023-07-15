package com.luxmed.reservationsystem.visitnoteadder;

class VisitNoteMapper {

    VisitNoteEntity mapToEntity(VisitNote visitNote){
        return VisitNoteEntity.builder()

                .doctorNote(visitNote.getDoctorNote())
                .build();
    }

}
