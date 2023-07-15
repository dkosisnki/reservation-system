package com.luxmed.reservationsystem.doctorregister;

import com.luxmed.reservationsystem.doctorregister.dto.DoctorRegisterRequestDto;
import com.luxmed.reservationsystem.doctorregister.dto.DoctorRegisterResponseDto;
import org.junit.jupiter.api.Test;

import static com.luxmed.reservationsystem.doctorregister.DoctorRegisterValidator.ValidationResult.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DoctorRegisterFacadeTest {

    DoctorRegisterRepositoryTestImpl testRepository = new DoctorRegisterRepositoryTestImpl();
    DoctorRegisterFacade doctorRegisterFacade = new DoctorRegisterConfigurator().createForTest(testRepository);

    @Test
    void shouldRegisterDoctorWhenRequestWasValid() {
        //given
        DoctorRegisterRequestDto registerRequest = DoctorRegisterRequestDto.builder()
                .login("boogie")
                .password("email")
                .name("Bogdan")
                .surname("Proktolog")
                .pesel("83120310848")
                .medicalLicense("007")
                .email("email@gmail.com")
                .build();
        //when
        DoctorRegisterResponseDto result = doctorRegisterFacade.register(registerRequest);

        //then
        assertEquals(INPUT_DATA_SUCCESS.message, result.responseMessage());
    }

    @Test
    void shouldFailedToRegisterDoctorWhenLoginWasEmptyOrNull() {
        //given
        DoctorRegisterRequestDto registerRequest = DoctorRegisterRequestDto.builder()
                .login("")
                .password("email")
                .name("Bogdan")
                .surname("Proktolog")
                .pesel("83120310848")
                .medicalLicense("007")
                .email("email@gmail.com")
                .build();
        //when
        DoctorRegisterResponseDto result = doctorRegisterFacade.register(registerRequest);

        //then
        assertEquals(INPUT_DATA_MISSING_LOGIN.message, result.responseMessage());
    }

    @Test
    void shouldFailedToRegisterDoctorWhenEmailWasEmptyOrNull() {
        //given
        DoctorRegisterRequestDto registerRequest = DoctorRegisterRequestDto.builder()
                .login("boogie")
                .password("email")
                .name("Bogdan")
                .surname("Proktolog")
                .pesel("83120310848")
                .medicalLicense("007")
                .build();
        //when
        DoctorRegisterResponseDto result = doctorRegisterFacade.register(registerRequest);

        //then
        assertEquals(INPUT_DATA_MISSING_EMAIL.message, result.responseMessage());
    }

    @Test
    void shouldFailedToRegisterDoctorWhenLicenseWasEmptyOrNull() {
        //given
        DoctorRegisterRequestDto registerRequest = DoctorRegisterRequestDto.builder()
                .login("boogie")
                .password("email")
                .name("Bogdan")
                .surname("Proktolog")
                .pesel("83120310848")
                .email("email@gmail.com")
                .build();
        //when
        DoctorRegisterResponseDto result = doctorRegisterFacade.register(registerRequest);

        //then
        assertEquals(INPUT_DATA_MISSING_MEDICAL_LICENSE.message, result.responseMessage());
    }

    @Test
    void shouldAddToPatientRepositoryCorrectly(){
        //given
        DoctorRegisterRequestDto registerRequest = DoctorRegisterRequestDto.builder()
                .login("boogie")
                .password("email")
                .name("Bogdan")
                .surname("Proktolog")
                .pesel("83120310848")
                .medicalLicense("007")
                .email("email@gmail.com")
                .build();
        //when
        doctorRegisterFacade.register(registerRequest);
        //then
        assertEquals(1, testRepository.repository.size());
    }
    @Test
    void shouldFailedToRegisterDoctorWhenLicenseWasNotFoundInRegistryLedger() {
    }


}