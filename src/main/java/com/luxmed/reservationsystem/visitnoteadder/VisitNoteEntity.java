package com.luxmed.reservationsystem.visitnoteadder;

import com.luxmed.reservationsystem.doctoravialibilityspecifier.VisitEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VisitNoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_note_id")
    private Integer visitNoteId;

    @Column(name ="visit_note_code")
    private Integer visitNoteCode;

    @Column(name = "doctor_note")
    private String doctorNote;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "visitNote")
    private VisitEntity visit;


}
