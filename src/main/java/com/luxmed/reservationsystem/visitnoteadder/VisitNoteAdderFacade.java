package com.luxmed.reservationsystem.visitnoteadder;

import com.luxmed.reservationsystem.visithistorychecker.VisitHistoryCheckerFacade;
import com.luxmed.reservationsystem.visitnoteadder.dto.VisitNoteAdderResponseDto;
import com.luxmed.reservationsystem.visitnoteadder.dto.VisitNoteAdderRequestDto;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class VisitNoteAdderFacade {

    private final VisitNoteRepository visitNoteRepository;
    private final VisitHistoryCheckerFacade visitHistoryCheckerFacade;
    private final VisitNoteMapper mapper;

    public VisitNoteAdderResponseDto addNote(VisitNoteAdderRequestDto request){
        if (!visitHistoryCheckerFacade.visitExists(request.visitId())){
            return VisitNoteAdderResponseDto.builder()
                    .responseMessage(VisitNoteAdderResponse.FAIL.message)
                    .build();
        }

        VisitNote visitNote = VisitNote.builder()
                .visitNoteCode(generateVisitNodeCode())
                .doctorNote(request.doctorNote())
                .build();

        VisitNoteEntity visitNoteEntity = mapper.mapToEntity(visitNote);

        visitNoteRepository.save(visitNoteEntity);


        return VisitNoteAdderResponseDto.builder()
                .responseMessage(VisitNoteAdderResponse.SUCCESS.message)
                .build();
    }

    private String generateVisitNodeCode() {
        return UUID.randomUUID().toString();
    }


}
