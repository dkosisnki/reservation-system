package com.luxmed.reservationsystem.visitnotechecker;

import com.luxmed.reservationsystem.visitnoteadder.VisitNoteAdderFacade;
import com.luxmed.reservationsystem.visitnoteadder.dto.VisitNoteDto;
import com.luxmed.reservationsystem.visitnotechecker.dto.VisitNoteCheckerRequestDto;
import com.luxmed.reservationsystem.visitnotechecker.dto.VisitNoteCheckerResponseDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class VisitNoteCheckerFacadeTest {

    VisitNoteAdderFacade visitNoteAdderFacade = mock(VisitNoteAdderFacade.class);
    VisitNoteCheckerFacade visitNoteCheckerFacade = new VisitNoteCheckerConfiguration().createForTest(visitNoteAdderFacade);

    @Test
    void shouldCheckVisitNoteCorrectly() {
        //given
        Integer visitCode = 1;
        VisitNoteCheckerRequestDto request = VisitNoteCheckerRequestDto.builder()
                .visitCode(visitCode)
                .build();

        VisitNoteDto noteAdderFacadeResponse = VisitNoteDto.builder()
                .visitCode(visitCode)
                .doctorNote("Some doctor note")
                .build();

        Mockito.when(visitNoteAdderFacade.findVisitNote(visitCode)).thenReturn(noteAdderFacadeResponse);

        //when
        VisitNoteCheckerResponseDto result = visitNoteCheckerFacade.checkVisitNote(request);
        //then
        assertEquals(VisitNoteCheckerResponse.SUCCESS.message, result.responseMessage());
    }

    @Test
    void shouldReturnEmptyMessageWhenThereIsAnyNoteToVisit() {
        //given
        Integer visitCode = 1;
        VisitNoteCheckerRequestDto request = VisitNoteCheckerRequestDto.builder()
                .visitCode(visitCode)
                .build();

        VisitNoteDto responseWithoutNote = VisitNoteDto.builder()
                .visitCode(1)
                .build();

        Mockito.when(visitNoteAdderFacade.findVisitNote(visitCode)).thenReturn(responseWithoutNote);

        //when
        VisitNoteCheckerResponseDto result = visitNoteCheckerFacade.checkVisitNote(request);
        //then
        assertEquals(VisitNoteCheckerResponse.FAIL_VISIT_DOES_NOT_HAVE_NOTE.message, result.responseMessage());
    }


    @Test
    void shouldFailedWhenPatientTryingCheckNoteToNoExistingVisit() {
        //given
        Integer visitCode = 1;
        VisitNoteCheckerRequestDto request = VisitNoteCheckerRequestDto.builder()
                .visitCode(visitCode)
                .build();

        VisitNoteDto emptyResponse = VisitNoteDto.builder()
                .build();

        Mockito.when(visitNoteAdderFacade.findVisitNote(visitCode)).thenReturn(emptyResponse);

        //when
        VisitNoteCheckerResponseDto result = visitNoteCheckerFacade.checkVisitNote(request);
        //then
        assertEquals(VisitNoteCheckerResponse.FAIL_VISIT_DOES_NOT_EXIST.message, result.responseMessage());
    }


}