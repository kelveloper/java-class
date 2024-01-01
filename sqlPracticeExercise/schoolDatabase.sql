DROP DATABASE IF EXISTS studentTable;
CREATE DATABASE studentTable;
USE studentTable;

-- Create the student table
CREATE TABLE student (
    sid INT PRIMARY KEY,
    fName VARCHAR(50),
    lName VARCHAR(50)
);

-- Create the teacher table
CREATE TABLE teacher (
    tid INT PRIMARY KEY,
    tFName VARCHAR(50),
    tLName VARCHAR(50),
    dept VARCHAR(50)
);

-- Create the course table
CREATE TABLE course (
    cid INT PRIMARY KEY,
    courseCode VARCHAR(50),
    courseDesc VARCHAR(50),
    teacherId INT,
    FOREIGN KEY (teacherId) REFERENCES teacher(tid)
);

-- Create the course_student table
CREATE TABLE course_student (
    student_id INT,
    course_id INT,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES student(sid),
    FOREIGN KEY (course_id) REFERENCES course(cid)
);
-- Insert data into the teacher table
INSERT INTO teacher (tid, tFName, tLName, dept)
VALUES
    (1, 'Hedy', 'Lamarr', 'Computer Science'),
    (2, 'Radia', 'Perlman', 'Computer Science'),
    (3, 'Annie', 'Easley', 'Computer Science'),
    (4, 'Peter', 'Denning', 'Computer Science'),
    (5, 'Ravi', 'Sethi', 'Computer Science'),
    (7, 'Hilary', 'Mantel', 'English'),
    (8, 'Margaret', 'Atwood', 'English'),
    (9, 'David', 'Mitchell', 'English'),
    (10, 'Michael', 'Chabon', 'English'),
    (11, 'Neil', 'Gaiman', 'English');

-- Insert data into the student table
INSERT INTO student (sid, fName, lName)
VALUES
    (1, 'Jolene', 'Westcott'),
    (2, 'Tabby', 'Daniell'),
    (3, 'Hans', 'Wozniak'),
    (4, 'Ifeanyi', 'Derichs'),
    (5, 'Guafrid', 'Lopez'),
    (6, 'Helena', 'Abbandonato'),
    (7, 'Aime', 'Larsen'),
    (9, 'Milada', 'Dreher');

-- Insert data into the course table
INSERT INTO course (cid, courseCode, courseDesc, teacherId)
VALUES
    (1, 'CS148', 'Intro to Data Structures', 1),
    (2, 'CS100', 'Intro to Java', 2),
    (3, 'CS202', 'Intermediate Java', 1),
    (4, 'CS305', 'Advanced Python', 5),
    (5, 'CS407', 'Information Systems Management', 4),
    (6, 'CS206', 'Network Design', 4),
    (7, 'CS503', 'Advanced Cyber Security', 3),
    (8, 'CS326', 'Advanced Fortran', 5),
    (10, 'CS324', 'Advanced Web Services with Java API', 3),
    (11, 'EN220', 'Fictional Writing', 10),
    (12, 'EN250', 'Fantasy Fictional Writing', 11),
    (14, 'EN100', 'Writing Basics', NULL),
    (15, 'EN200', 'English Composition', NULL),
    (16, 'EN300', 'Poetry Writing', NULL);

-- Insert data into the course_student table
INSERT INTO course_student (student_id, course_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 1),
    (2, 2),
    (2, 3),
    (1, 3),
    (1, 5),
    (2, 4),
    (2, 6),
    (3, 2),
    (3, 3),
    (3, 4),
    (3, 5),
    (4, 1),
    (4, 4),
    (4, 5),
    (4, 6),
    (4, 7),
    (5, 1),
    (5, 2),
    (5, 4),
    (5, 6),
    (6, 1),
    (6, 3),
    (6, 5),
    (6, 6),
    (6, 7),
    (7, 1),
    (7, 2),
    (7, 3),
    (7, 5),
    (7, 6),
    (7, 7),
    (9, 3),
    (9, 5),
    (9, 6),
    (9, 7);
    
