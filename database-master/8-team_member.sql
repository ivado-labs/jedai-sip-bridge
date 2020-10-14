SET NAMES 'utf8';

CREATE TABLE IF NOT EXISTS team_member
(
    team_id INT NOT NULL,
    staff_id INT  NOT NULL,
    FOREIGN KEY (team_id) REFERENCES team(id),
    FOREIGN KEY (staff_id) REFERENCES staff(id)
);
