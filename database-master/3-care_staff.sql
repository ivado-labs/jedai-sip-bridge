SET NAMES 'utf8';

CREATE TABLE IF NOT EXISTS care_staff
(
    staff_id INT PRIMARY KEY,
    FOREIGN KEY (staff_id) REFERENCES staff(id)
);