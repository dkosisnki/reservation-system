package com.luxmed.reservationsystem.patientregister;

import lombok.Builder;

@Builder
record Patient(
        String login,
        String password,
        String name,
        String surname,
        String pesel,
        String email
) {
}
