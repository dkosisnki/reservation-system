CREATE TABLE visit
(
    visit_id            SERIAL        NOT NULL PRIMARY KEY,
    visit_code          VARCHAR(32)   NOT NULL UNIQUE,
    visit_date          DATE          NOT NULL,
    visit_beginning     TIME          NOT NULL,
    visit_ending        TIME          NOT NULL,
    note_id             INT,
    doctor_id           INT           NOT NULL,
    patient_id          INT           NOT NULL,
    CONSTRAINT fk_visit_note
        FOREIGN KEY (note_id)
            REFERENCES visit_note (visit_id),
    CONSTRAINT fk_visit_doctor
        FOREIGN KEY (doctor_id)
            REFERENCES doctor (doctor_id),
    CONSTRAINT fk_visit_patient
        FOREIGN KEY (patient_id)
            REFERENCES patient (patient_id)
);