package com.luxmed.reservationsystem.doctoravialibilityspecifier;

import com.luxmed.reservationsystem.doctoravialibilityspecifier.dto.AvailabilityResponseDto;
import com.luxmed.reservationsystem.doctoravialibilityspecifier.dto.DoctorAvailabilityRequestDto;
import com.luxmed.reservationsystem.doctoravialibilityspecifier.dto.SingleDoctorAvailabilityDto;
import com.luxmed.reservationsystem.doctorregister.DoctorRegisterFacade;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.luxmed.reservationsystem.doctoravialibilityspecifier.DoctorAvailabilityValidator.ValidationResult.INPUT_DATA_SUCCESS;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DoctorAvailabilitySpecifierFacadeTest {

    DoctorRegisterFacade doctorRegisterFacade = mock(DoctorRegisterFacade.class);
    DoctorAvailabilityRepositoryTestImpl testRepository = new DoctorAvailabilityRepositoryTestImpl();
    DoctorAvailabilitySpecifierFacade doctorAvailabilitySpecifierFacade =
            new DoctorAvailabilitySpecifierConfiguration().createForTest(testRepository,doctorRegisterFacade);


    @Test
    void shouldReturnSuccessWhenSpecifiedAvailabilityCorrectly() {
        //given
        SingleDoctorAvailabilityDto availability1 = SingleDoctorAvailabilityDto.builder()
                .date(LocalDate.now())
                .beginningOfVisits(LocalTime.of(8, 0, 0))
                .endOfVisits(LocalTime.of(11, 0, 0))
                .build();

        SingleDoctorAvailabilityDto availability2 = SingleDoctorAvailabilityDto.builder()
                .date(LocalDate.now())
                .beginningOfVisits(LocalTime.of(13, 0, 0))
                .endOfVisits(LocalTime.of(15, 0, 0))
                .build();

        String doctorMedicalLicense = "007";
        DoctorAvailabilityRequestDto availability = DoctorAvailabilityRequestDto.builder()
                .medicalLicense(doctorMedicalLicense)
                .availabilities(List.of(availability1, availability2))
                .build();
        when(doctorRegisterFacade.isDoctorRegistered(doctorMedicalLicense)).thenReturn(true);

        //when
        AvailabilityResponseDto response = doctorAvailabilitySpecifierFacade.determineAvailability(availability);

        //then
        assertEquals(response.responseMessage(), INPUT_DATA_SUCCESS.message);
    }
//
//    @Test
//    void shouldReturnFailedWhenDoctorIsNoRegisteredInOurSystem() {
//        //given
//        String doctorMedicalLicense = "007";
//        DoctorAvailabilityRequestDto availability = DoctorAvailabilityRequestDto.builder()
//                .medicalLicense(doctorMedicalLicense)
//                .date(LocalDate.now())
//                .beginningOfVisits(LocalTime.of(8, 0, 0))
//                .endOfVisits(LocalTime.of(14, 0, 0))
//                .build();
//
//        when(doctorRegisterFacade.isDoctorRegistered(doctorMedicalLicense)).thenReturn(false);
//        //when
//        AvailabilityResponseDto response = doctorAvailabilitySpecifierFacade.determineAvailability(availability);
//        //then
//        assertEquals(response.responseMessage(), INPUT_DATA_DOCTOR_NO_REGISTERED.message);
//    }
//
//    @Test
//    void shouldPrepareVisitsCorrectly(){
//        //given
//        long timeOfVisit = 15;
//        String doctorMedicalLicense = "007";
//        DoctorAvailabilityRequestDto availability = DoctorAvailabilityRequestDto.builder()
//                .medicalLicense(doctorMedicalLicense)
//                .date(LocalDate.now())
//                .beginningOfVisits(LocalTime.of(8, 45, 0))
//                .endOfVisits(LocalTime.of(9, 30, 0))
//                .build();
//        when(doctorRegisterFacade.isDoctorRegistered(doctorMedicalLicense)).thenReturn(true);
//
//        //when
//        doctorAvailabilitySpecifierFacade.determineAvailability(availability);
//
//        //then
//        List<VisitEntity> availabilities = testRepository.findAll();
//        VisitEntity firstVisit = availabilities.get(0);
//        VisitEntity secondVisit = availabilities.get(1);
//        VisitEntity thirdVisit = availabilities.get(2);
//
//        assertAll(
//                () -> assertEquals(firstVisit.getVisitDate(),secondVisit.getVisitDate().minusMinutes(timeOfVisit)),
//                () -> assertEquals(firstVisit.getVisitDate(),thirdVisit.getVisitDate().minusMinutes(timeOfVisit*2)
//        ));
//
//
//    }
//
//    @Test
//    void shouldAddVisitsToRepositoryCorrectly(){
//        //given
//        String doctorMedicalLicense = "007";
//        DoctorAvailabilityRequestDto availability = DoctorAvailabilityRequestDto.builder()
//                .medicalLicense(doctorMedicalLicense)
//                .date(LocalDate.now())
//                .beginningOfVisits(LocalTime.of(8, 0, 0))
//                .endOfVisits(LocalTime.of(14, 0, 0))
//                .build();
//        when(doctorRegisterFacade.isDoctorRegistered(doctorMedicalLicense)).thenReturn(true);
//
//        //when
//        AvailabilityResponseDto result = doctorAvailabilitySpecifierFacade.determineAvailability(availability);
//
//        //then
//        assertEquals(24,  result.definedVisits().size());
//    }
//
//    @Test
//    void shouldFailWhenDoctorTryToAddAlreadyExistingAvailability(){
//        //given
//        String doctorMedicalLicense = "007";
//        DoctorAvailabilityRequestDto availability1 = DoctorAvailabilityRequestDto.builder()
//                .medicalLicense(doctorMedicalLicense)
//                .date(LocalDate.now())
//                .beginningOfVisits(LocalTime.of(8, 0, 0))
//                .endOfVisits(LocalTime.of(9, 0, 0))
//                .build();
//
//        DoctorAvailabilityRequestDto availability2 = DoctorAvailabilityRequestDto.builder()
//                .medicalLicense(doctorMedicalLicense)
//                .date(LocalDate.now())
//                .beginningOfVisits(LocalTime.of(8, 0, 0))
//                .endOfVisits(LocalTime.of(9, 0, 0))
//                .build();
//        when(doctorRegisterFacade.isDoctorRegistered(doctorMedicalLicense)).thenReturn(true);
//
//        //when
//        doctorAvailabilitySpecifierFacade.determineAvailability(availability1);
//        AvailabilityResponseDto result = doctorAvailabilitySpecifierFacade.determineAvailability(availability2);
//
//        //then
//        assertEquals(INPUT_DATA_VISITS_ALREADY_EXIST.message,result.responseMessage());
//    }
}