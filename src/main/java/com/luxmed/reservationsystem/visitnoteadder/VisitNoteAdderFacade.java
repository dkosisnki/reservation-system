package com.luxmed.reservationsystem.visitnoteadder;

import com.luxmed.reservationsystem.visithistorychecker.VisitHistoryCheckerFacade;
import com.luxmed.reservationsystem.visitnoteadder.dto.VisitNoteAdderResponseDto;
import com.luxmed.reservationsystem.visitnoteadder.dto.VisitNoteAdderRequestDto;
import com.luxmed.reservationsystem.visitnoteadder.dto.VisitNoteDto;
import lombok.AllArgsConstructor;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class VisitNoteAdderFacade {

    private final VisitNoteRepository visitNoteRepository;
    private final VisitHistoryCheckerFacade visitHistoryCheckerFacade;
    private final VisitNoteMapper mapper;

    public VisitNoteAdderResponseDto addNote(VisitNoteAdderRequestDto request){
        if (!visitExists(request)){
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

    public VisitNoteDto findVisitNote(Integer visitCode){
        Optional<VisitNoteEntity> visitNoteByVisitCode = visitNoteRepository.findByVisitNoteCode(visitCode);

        if (visitNoteByVisitCode.isEmpty()){
            return VisitNoteDto.builder()
                    .build();
        }

        VisitNote visitNote = mapper.mapFromEntity(visitNoteByVisitCode.get());

        if (Objects.isNull(visitNote.getDoctorNote())){
            return VisitNoteDto.builder()
                    .visitCode(visitNote.getVisitNoteCode())
                    .build();
        }

        return VisitNoteDto.builder()
                .visitCode(visitNote.getVisitNoteCode())
                .doctorNote(visitNote.getDoctorNote())
                .build();
    }

    private boolean visitExists(VisitNoteAdderRequestDto request) {
        return visitHistoryCheckerFacade.visitExists(request.visitCode());
    }

    private Integer generateVisitNodeCode() {
        return UUID.randomUUID().hashCode();
    }


}
