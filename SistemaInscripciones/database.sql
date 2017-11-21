CREATE TABLE user (
    id SERIAL,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    username VARCHAR(20) NOT NULL,
    pass CHAR(71) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE teacher (
    id SERIAL,
    nomina CHAR(9) NOT NULL, /* L0XXXXXXX */
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    email VARCHAR(40) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (nomina),
    UNIQUE (email)
);

CREATE TABLE course (
    id SERIAL,
    code CHAR(6) NOT NULL, /* TC1001 */
    title VARCHAR(100) NOT NULL,
    dependency_id BIGINT UNSIGNED,
    honors BOOLEAN NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (dependency_id) REFERENCES course(id),
    UNIQUE (code)
);

CREATE TABLE classroom (
    id SERIAL,
    code VARCHAR(10) NOT NULL, /* A3-210 */
    building VARCHAR(40) NOT NULL, /* Aulas-3 */
    room INT NOT NULL, /* 210 */
    PRIMARY KEY(id),
    UNIQUE (code)
);

CREATE TABLE class (
    id SERIAL,
    course_id BIGINT UNSIGNED NOT NULL,
    teacher_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (course_id) REFERENCES course(id),
    FOREIGN KEY (teacher_id) REFERENCES teacher(id)
);

CREATE TABLE schedule (
    id SERIAL,
    class_id BIGINT UNSIGNED NOT NULL,
    classroom_id BIGINT UNSIGNED NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    day CHAR(2) NOT NULL, /* Lu, Ma, Mi, Ju, Vi, Sa */
    PRIMARY KEY (id),
    FOREIGN KEY (class_id) REFERENCES class(id),
    FOREIGN KEY (classroom_id) REFERENCES classroom(id)
);

DELIMITER $$
CREATE TRIGGER check_overlap BEFORE INSERT ON schedule
    FOR EACH ROW BEGIN
        DECLARE overlap BOOLEAN;
        SELECT EXISTS (
            SELECT * FROM schedule
                WHERE classroom_id = NEW.classroom_id
                AND day = NEW.day
                AND (
                    start_time <= NEW.start_time
                    AND end_time >= NEW.start_time
                ) OR (
                    start_time <= NEW.end_time
                    AND end_time >= NEW.end_time
                )
        ) INTO overlap;
        IF overlap THEN
            SET NEW.start_time = NULL; /* Stops query by violating not null constraint */
        END IF;
    END;
$$
DELIMITER ;
