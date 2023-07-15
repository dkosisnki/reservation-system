package com.luxmed.reservationsystem.doctoravialibilityspecifier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface DoctorAvailabilityRepository extends JpaRepository<VisitEntity,Integer> {


    Optional<VisitEntity> findByVisitDate(LocalDate visitDate);

    Optional<VisitEntity> findByBeginningOfVisit(LocalTime beginningOfVisit);

    Optional<VisitEntity> findByEndOfVisit(LocalTime endOfVisit);
}
