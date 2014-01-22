-- -----------------------------------------------------------------------
-- mysql SQL script for schema napp
-- -----------------------------------------------------------------------


drop table if exists student;
drop table if exists user;



# -----------------------------------------------------------------------
# student
# -----------------------------------------------------------------------
CREATE TABLE student
(
    student_id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY(student_id)
);


# -----------------------------------------------------------------------
# user
# -----------------------------------------------------------------------
CREATE TABLE user
(
    user_name VARCHAR(128) NOT NULL,
    password VARCHAR(128) NOT NULL,
    PRIMARY KEY(user_name)
);





