package com.luxmed.reservationsystem.patientregister;

import com.luxmed.reservationsystem.patientregister.dto.PatientRegisterRequestDto;
import com.luxmed.reservationsystem.patientregister.dto.PatientRegisterResponseDto;
import org.junit.jupiter.api.Test;

import static com.luxmed.reservationsystem.patientregister.PatientRegisterValidator.ValidationResult.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PatientRegisterFacadeTest {

    PatientRegisterRepositoryTestImpl testRepository = new PatientRegisterRepositoryTestImpl();
    PatientRegisterFacade patientRegisterFacade = new PatientRegisterConfiguration().createForTest(testRepository);

    @Test
    void shouldRegisterPatientWhenRequestWasValid() {
        //given
        PatientRegisterRequestDto registerRequest = PatientRegisterRequestDto.builder()
                .login("drzewo")
                .password("lisciaste")
                .email("email@gmail.com")
                .build();
        //when
        PatientRegisterResponseDto result = patientRegisterFacade.register(registerRequest);

        //then
        assertEquals(INPUT_DATA_SUCCESS.message, result.responseMessage());
    }


    @Test
    void shouldFailedToRegisterPatientWhenLoginWasEmptyOrNull() {
        //given
        PatientRegisterRequestDto registerRequest = PatientRegisterRequestDto.builder()
                .login("")
                .password("email")
                .email("email@gmail.com")
                .build();
        //when
        PatientRegisterResponseDto result = patientRegisterFacade.register(registerRequest);

        //then
        assertEquals(INPUT_DATA_MISSING_LOGIN.message, result.responseMessage());
    }


    @Test
    void shouldFailedToRegisterPatientWhenPasswordWasEmptyOrNull() {
        //given
        PatientRegisterRequestDto registerRequest = PatientRegisterRequestDto.builder()
                .login("drzewo")
                .password("")
                .email("email@gmail.com")
                .build();
        //when
        PatientRegisterResponseDto result = patientRegisterFacade.register(registerRequest);

        //then
        assertEquals(INPUT_DATA_MISSING_PASSWORD.message, result.responseMessage());
    }

    @Test
    void shouldFailedToRegisterPatientWhenEmailWasEmptyOrNull() {
        //given
        PatientRegisterRequestDto registerRequest = PatientRegisterRequestDto.builder()
                .login("drzewo")
                .password("lisciaste")
                .build();
        //when
        PatientRegisterResponseDto result = patientRegisterFacade.register(registerRequest);

        //then
        assertEquals(INPUT_DATA_MISSING_EMAIL.message, result.responseMessage());
    }

    @Test
    void shouldAddToPatientRepositoryCorrectly(){
        //given
        PatientRegisterRequestDto registerRequest = PatientRegisterRequestDto.builder()
                .login("drzewo")
                .password("lisciaste")
                .email("email@gmail.com")
                .build();
        //when
        patientRegisterFacade.register(registerRequest);
        //then
        assertEquals(1, testRepository.repository.size());
    }

}