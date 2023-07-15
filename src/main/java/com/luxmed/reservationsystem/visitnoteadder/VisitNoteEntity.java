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
    @Column(name = "visitNote_id")
    private Integer visitNoteId;


    @Column(name = "doctorNote")
    private String doctorNote;


}
