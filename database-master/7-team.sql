SET NAMES 'utf8';

CREATE TABLE IF NOT EXISTS team
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    shift_id INT NOT NULL,
    FOREIGN KEY (shift_id) REFERENCES shift(id),
    type ENUM('nurse', 'medical', 'care') NOT NULL
);
