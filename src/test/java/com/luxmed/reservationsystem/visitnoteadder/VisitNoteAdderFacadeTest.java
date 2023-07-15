package com.luxmed.reservationsystem.visitnoteadder;

import com.luxmed.reservationsystem.visithistorychecker.VisitHistoryCheckerFacade;
import com.luxmed.reservationsystem.visitnoteadder.dto.VisitNoteAdderRequestDto;
import com.luxmed.reservationsystem.visitnoteadder.dto.VisitNoteAdderResponseDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class VisitNoteAdderFacadeTest {

    VisitNoteRepository repository = new VisitNoteRepositoryTestImpl();
    VisitHistoryCheckerFacade visitHistoryCheckerFacade = mock(VisitHistoryCheckerFacade.class);
    VisitNoteAdderFacade visitNoteAdderFacade = new VisitNoteAdderConfiguration().createForTest(repository, visitHistoryCheckerFacade);

    @Test
    void shouldAddVisitNoteCorrectly() {
        //given
        VisitNoteAdderRequestDto request = VisitNoteAdderRequestDto.builder()
                .visitId(1)
                .doctorNote("Some note")
                .build();
        when(visitHistoryCheckerFacade.visitExists(request.visitId())).thenReturn(true);
        //when
        VisitNoteAdderResponseDto result = visitNoteAdderFacade.addNote(request);
        //then
        assertEquals(VisitNoteAdderResponse.SUCCESS.message,result.responseMessage());

    }

    @Test
    void shouldFailWhenDoctorTryToAddNoteToNoExistingVisit() {
        //given
        VisitNoteAdderRequestDto request = VisitNoteAdderRequestDto.builder()
                .visitId(1337)
                .doctorNote("Some note")
                .build();
        when(visitHistoryCheckerFacade.visitExists(request.visitId())).thenReturn(false);
        //when
        VisitNoteAdderResponseDto result = visitNoteAdderFacade.addNote(request);
        //then
        assertEquals(VisitNoteAdderResponse.FAIL.message,result.responseMessage());
    }

}