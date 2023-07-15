package com.luxmed.reservationsystem.doctorregister;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
    Optional<DoctorEntity> findByMedicalLicense(String license);

}
