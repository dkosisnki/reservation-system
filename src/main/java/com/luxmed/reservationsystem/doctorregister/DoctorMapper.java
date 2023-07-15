package com.luxmed.reservationsystem.doctorregister;

class DoctorMapper {

    public DoctorEntity mapToEntity(Doctor doctor) {
        return DoctorEntity.builder()
                .name(doctor.getName())
                .surname(doctor.getSurname())
                .pesel(doctor.getPesel())
                .email(doctor.getEmail())
                .medicalLicense(doctor.getMedicalLicense())
                .build();
    }
}
