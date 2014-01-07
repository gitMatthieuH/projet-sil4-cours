-- -----------------------------------------------------------------------
-- mysql SQL script for schema nappstore
-- -----------------------------------------------------------------------


drop table if exists student;



# -----------------------------------------------------------------------
# student
# -----------------------------------------------------------------------
CREATE TABLE student
(
    student_id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY(student_id)
);





