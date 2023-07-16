package com.luxmed.reservationsystem.visitnoteadder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitNoteRepository extends JpaRepository<VisitNoteEntity, Integer> {

    Optional<VisitNoteEntity> findByVisitNoteCode(Integer visitNoteCode);

}
