package com.luxmed.reservationsystem.visitnotechecker;

import com.luxmed.reservationsystem.visitnoteadder.VisitNoteAdderFacade;
import com.luxmed.reservationsystem.visitnoteadder.dto.VisitNoteDto;
import com.luxmed.reservationsystem.visitnotechecker.dto.VisitNoteCheckerRequestDto;
import com.luxmed.reservationsystem.visitnotechecker.dto.VisitNoteCheckerResponseDto;
import lombok.AllArgsConstructor;

import java.util.Objects;

import static com.luxmed.reservationsystem.visitnotechecker.VisitNoteCheckerResponse.*;

@AllArgsConstructor
public class VisitNoteCheckerFacade {

    private final VisitNoteAdderFacade visitNoteAdderFacade;

    public VisitNoteCheckerResponseDto checkVisitNote(VisitNoteCheckerRequestDto request) {
        VisitNoteDto visitNoteDto = visitNoteAdderFacade.findVisitNote(request.visitCode());

        if (Objects.isNull(visitNoteDto.visitCode())) {
            return VisitNoteCheckerResponseDto.builder()
                    .responseMessage(FAIL_VISIT_DOES_NOT_EXIST.message)
                    .build();
        }
        if (Objects.isNull(visitNoteDto.doctorNote())) {
            return VisitNoteCheckerResponseDto.builder()
                    .responseMessage(FAIL_VISIT_DOES_NOT_HAVE_NOTE.message)
                    .visitCode(visitNoteDto.visitCode())
                    .build();
        }

        return VisitNoteCheckerResponseDto.builder()
                .responseMessage(SUCCESS.message)
                .visitCode(visitNoteDto.visitCode())
                .doctorNote(visitNoteDto.doctorNote())
                .build();

    }

}
