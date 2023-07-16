CREATE TABLE doctor
(
    doctor_id        SERIAL          NOT NULL PRIMARY KEY,
    name             VARCHAR(32)     NOT NULL,
    surname          VARCHAR(32)     NOT NULL,
    pesel            VARCHAR(32)     NOT NULL UNIQUE,
    medical_license  VARCHAR(32)     NOT NULL UNIQUE,
    email            VARCHAR(32)     NOT NULL UNIQUE
);