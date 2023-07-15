package com.luxmed.reservationsystem.doctoravialibilityspecifier;

import com.luxmed.reservationsystem.doctorregister.DoctorEntity;
import com.luxmed.reservationsystem.patientregister.PatientEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"visitDate"})
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_id")
    private Integer visitId;

    @Column(name = "visitDate")
    private LocalDate visitDate;

    @Column(name = "beginningOfVisits")
    private LocalTime beginningOfVisit;

    @Column(name = "endOfVisits")
    private LocalTime endOfVisit;

    @Column(name = "doctor")
    private DoctorEntity doctor;

    @Column(name = "patient")
    private PatientEntity patient;
}
