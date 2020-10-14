SET NAMES 'utf8';

CREATE TABLE IF NOT EXISTS nursing_staff
(
    staff_id INT PRIMARY KEY,
    certifications VARCHAR(255),
    FOREIGN KEY (staff_id) REFERENCES staff(id)
);