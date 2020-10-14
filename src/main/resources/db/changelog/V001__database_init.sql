--liquibase formatted sql

--changeset tiaede00:1
create table bed (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    label varchar(255)
);

create table room (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    display_number INT,
    label varchar(255),
    unique (display_number,label)
);

create table organization (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    label varchar(255)
);

create table codeable_concept (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    code varchar(50),
    display varchar(255)
);

create table human_name (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    family varchar(50),
    given varchar(50),
    prefix varchar(50),
    suffix varchar(50)
);

create table practitioner (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name INT,
    FOREIGN KEY (name) REFERENCES human_name(id)
);

create table location (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    room INT,
    bed INT,
    organization INT,
    UNIQUE (room, organization),
    FOREIGN KEY (room) REFERENCES room(id),
    FOREIGN KEY (bed) REFERENCES bed(id),
    FOREIGN KEY (organization) REFERENCES organization(id)
);

create table patient (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    patient_identifier INT,
    gender INT,
    name INT,
    birth_date DATE,
    general_practitioner INT,
    UNIQUE (patient_identifier),
    FOREIGN KEY (name) REFERENCES human_name(id),
    FOREIGN KEY (general_practitioner) REFERENCES practitioner(id)
);

create table encounter (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    encounter_identifier INT,
    subject INT,
    location INT,
    UNIQUE (encounter_identifier),
    FOREIGN KEY (subject) REFERENCES patient(id),
    FOREIGN KEY (location) REFERENCES location(id)
);

create table `procedure`(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   coding INT,
   encounter INT,
   issued timestamp,
   value varchar(255),
   unit varchar(50),
   FOREIGN KEY (coding) REFERENCES codeable_concept(id),
   FOREIGN KEY (encounter) REFERENCES encounter(id)
);

create table quantis(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   patient_identifier INT,
   entered_date date,
   reel_horraire varchar(2),
   cote_reel int,
   niveau_reel int,
   lit varchar(50),
   plan_horraire varchar(2),
   cote_planifie int,
   niveau_planifie int,
   FOREIGN KEY (patient_identifier) REFERENCES patient(patient_identifier)
);


