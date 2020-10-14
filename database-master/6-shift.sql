SET NAMES 'utf8';

CREATE TABLE IF NOT EXISTS shift
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    date_start DATETIME NOT NULL,
    date_end DATETIME NOT NULL
    /* TODO: Make constraints/pk with date_start, date_end */
);
