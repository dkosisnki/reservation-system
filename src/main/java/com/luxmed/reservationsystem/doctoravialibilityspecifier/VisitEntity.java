package com.luxmed.reservationsystem.doctoravialibilityspecifier;

import com.luxmed.reservationsystem.doctorregister.DoctorEntity;
import com.luxmed.reservationsystem.patientregister.PatientEntity;
import com.luxmed.reservationsystem.visitnoteadder.VisitNoteEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visit")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_id")
    private Integer visitId;

    @Column(name = "visit_code")
    private Integer visitCode;

    @Column(name = "visit_date")
    private LocalDate visitDate;

    @Column(name = "visit_beginning")
    private LocalTime beginningOfVisit;

    @Column(name = "visit_ending")
    private LocalTime endOfVisit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visits")
    private DoctorEntity doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visits")
    private PatientEntity patient;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "visit")
    @JoinColumn(name = "visit")
    private VisitNoteEntity visitNote;
}
