SET NAMES 'utf8';

CREATE TABLE IF NOT EXISTS bed
(
    bed_number INT PRIMARY KEY,
    room_number INT NOT NULL,
    FOREIGN KEY (room_number) REFERENCES room(room_number) 
);
