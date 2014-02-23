-- -----------------------------------------------------------------------
-- mysql SQL script for schema napp
-- -----------------------------------------------------------------------


ALTER TABLE student
    DROP FOREIGN KEY student_FK_1;


ALTER TABLE user
    DROP FOREIGN KEY user_FK_1;


ALTER TABLE note
    DROP FOREIGN KEY note_FK_1;


ALTER TABLE abscence
    DROP FOREIGN KEY abscence_FK_1;


drop table if exists student;
drop table if exists user;
drop table if exists usergroup;
drop table if exists note;
drop table if exists abscence;



# -----------------------------------------------------------------------
# student
# -----------------------------------------------------------------------
CREATE TABLE student
(
    student_id INTEGER NOT NULL AUTO_INCREMENT,
    absences INTEGER NOT NULL,
    firstname VARCHAR(128) NOT NULL,
    name VARCHAR(128) NOT NULL,
    group_id INTEGER NOT NULL,
    PRIMARY KEY(student_id)
);


# -----------------------------------------------------------------------
# user
# -----------------------------------------------------------------------
CREATE TABLE user
(
    user_name VARCHAR(128) NOT NULL,
    password VARCHAR(128) NOT NULL,
    isAdmin INTEGER NOT NULL,
    student_id INTEGER,
    PRIMARY KEY(user_name)
);


# -----------------------------------------------------------------------
# usergroup
# -----------------------------------------------------------------------
CREATE TABLE usergroup
(
    group_id INTEGER NOT NULL AUTO_INCREMENT,
    group_name VARCHAR(128) NOT NULL,
    PRIMARY KEY(group_id)
);


# -----------------------------------------------------------------------
# note
# -----------------------------------------------------------------------
CREATE TABLE note
(
    note_id INTEGER NOT NULL AUTO_INCREMENT,
    controle_id INTEGER NOT NULL,
    points INTEGER NOT NULL,
    student_id INTEGER NOT NULL,
    PRIMARY KEY(note_id)
);


# -----------------------------------------------------------------------
# abscence
# -----------------------------------------------------------------------
CREATE TABLE abscence
(
    abscence_id INTEGER NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    motif VARCHAR(128) NOT NULL,
    student_id INTEGER NOT NULL,
    PRIMARY KEY(abscence_id)
);


ALTER TABLE student
    ADD CONSTRAINT student_FK_1
    FOREIGN KEY (group_id)
    REFERENCES usergroup (group_id);

ALTER TABLE user
    ADD CONSTRAINT user_FK_1
    FOREIGN KEY (student_id)
    REFERENCES student (student_id);

ALTER TABLE note
    ADD CONSTRAINT note_FK_1
    FOREIGN KEY (student_id)
    REFERENCES student (student_id);

ALTER TABLE abscence
    ADD CONSTRAINT abscence_FK_1
    FOREIGN KEY (student_id)
    REFERENCES student (student_id);




