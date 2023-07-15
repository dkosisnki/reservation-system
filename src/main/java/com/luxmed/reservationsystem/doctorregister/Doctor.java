package com.luxmed.reservationsystem.doctorregister;

import lombok.Builder;
import lombok.Setter;
import lombok.Value;

@Value
@Builder
public class Doctor{
        String name;
        String surname;
        String pesel;
        String medicalLicense;
        String email;

}
