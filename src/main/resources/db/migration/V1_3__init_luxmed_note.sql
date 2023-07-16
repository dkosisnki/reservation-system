CREATE TABLE visit_note
(
    visit_id            SERIAL          NOT NULL PRIMARY KEY,
    visit_note_code     VARCHAR(32)     NOT NULL UNIQUE,
    doctor_node         TEXT            NOT NULL

);