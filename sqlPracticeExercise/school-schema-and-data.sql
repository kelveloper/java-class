DROP DATABASE IF EXISTS school;

create database school;
use school;

-- Table structure for student

CREATE TABLE student (
  sid int NOT NULL AUTO_INCREMENT,
  fName varchar(255) DEFAULT NULL,
  lName varchar(255) DEFAULT NULL,
  PRIMARY KEY (sid)
);

-- Table structure for teacher

CREATE TABLE teacher (
  tid int NOT NULL AUTO_INCREMENT,
  tFName varchar(255) DEFAULT NULL,
  tLName varchar(255) DEFAULT NULL,
  dept varchar(255) DEFAULT NULL,
  PRIMARY KEY (tid)
);


-- Table structure for course

CREATE TABLE course (
  cid int NOT NULL AUTO_INCREMENT,
  courseName varchar(255) DEFAULT NULL,
  courseDesc varchar(255) DEFAULT NULL,
  teacherId int DEFAULT NULL,
  PRIMARY KEY (cid),
  KEY teacherId (teacherId),
  CONSTRAINT course_ibfk_1
    FOREIGN KEY (teacherId) REFERENCES teacher (tid)
);

-- Table structure for course_student

CREATE TABLE course_student (
  student_id int,
  course_id int,
  PRIMARY KEY (student_id, course_id),
  CONSTRAINT course_student_ibfk_1
    FOREIGN KEY (student_id) REFERENCES student (sid),
  CONSTRAINT course_student_ibfk_2
    FOREIGN KEY (course_id) REFERENCES course (cid)
);


INSERT INTO teacher VALUES (1,'Ada','Lovelace','Computer Science'),
(2,'Charles','Babbage','Computer Science'),
(3,'Alan','Turing','Computer Science'),
(4,'Linus','Torvalds','Computer Science'),
(5,'John','Backus','Computer Science'),
(7,'Lewis','Carroll','English'),
(8,'Jane','Austen','English'),
(9,'Mark','Twain','English'),
(10,'Harper','Lee','English'),
(11,'Joanne','Rowling','English');

INSERT INTO course VALUES (1,'CS148','Intro to Data Structures',1),
(2,'CS100','Intro to Java',2),
(3,'CS202','Intermediate Java',1),
(4,'CS305','Advanced Python',5),
(5,'CS407','Information Systems Management',4),
(6,'CS206 ','Network Design',4),
(7,'CS503','Advanced Cyber Security',3),
(8,'CS326','Advanced Fortran',5),
(10,'CS324','Advanced Web Services with Java API',3),
(11,'EN220','Fictional Writing',10),
(12,'EN250','Fantasy Fictional Writing',11),
(14,'EN100','Writing Basics',NULL),
(15,'EN200','English Composition',NULL),
(16,'EN300','Poetry Writing',NULL);

INSERT INTO student VALUES (1,'Bill','Gates'),
(2,'Steve','Martin'),
(3,'Donald','Henley'),
(4,'Robert','Mitchum'),
(5,'Michelle','Pfeiffer'),
(6,'Elenor','Shellstrop'),
(7,'Jenny','Capriati'),
(9,'James','Brown');

INSERT INTO course_student VALUES
(1,1), (1,2), (2,1), (2,2), (2,3), (1,3), (1,5),
(2,4), (2,6), (3,2), (3,3), (3,4), (3,5), (4,1),
(4,4), (4,5), (4,6), (4,7), (5,1), (5,2), (5,4),
(5,6), (6,1), (6,3), (6,5), (6,6), (6,7), (7,2),
(7,3), (7,5), (7,6), (7,7);