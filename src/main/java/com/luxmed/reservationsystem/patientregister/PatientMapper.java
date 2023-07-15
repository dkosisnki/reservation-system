package com.luxmed.reservationsystem.patientregister;

class PatientMapper {
    public PatientEntity mapToEntity(Patient patient) {
        return PatientEntity.builder()
                .name(patient.name())
                .surname(patient.surname())
                .pesel(patient.pesel())
                .email(patient.email())
                .build();
    }
}
