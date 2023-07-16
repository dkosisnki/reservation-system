package com.luxmed.reservationsystem.visitnoteadder;

class VisitNoteMapper {

    VisitNoteEntity mapToEntity(VisitNote visitNote){
        return VisitNoteEntity.builder()
                .visitNoteCode(visitNote.getVisitNoteCode())
                .doctorNote(visitNote.getDoctorNote())
                .build();
    }

    VisitNote mapFromEntity(VisitNoteEntity entity){
        return VisitNote.builder()
                .visitNoteCode(entity.getVisitNoteCode())
                .doctorNote(entity.getDoctorNote())
                .build();
    }

}
