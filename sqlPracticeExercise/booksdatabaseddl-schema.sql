-- Kelvin Saldana 
-- 12/21/2023

DROP DATABASE IF EXISTS booksdatabase;
CREATE DATABASE booksdatabase;
USE booksdatabase;

DROP TABLE IF EXISTS author;
CREATE TABLE author (
	authorID INT AUTO_INCREMENT,
		CONSTRAINT pk_author
			PRIMARY KEY (authorId),
	firstName VARCHAR(25) NOT NULL,
    middleName VARCHAR(25),
    lastName VARCHAR(50) NOT NULL,
    gender VARCHAR(1),
    dateOfBirth DATETIME NOT NULL,
    dateOfDeath DATETIME
);
DESCRIBE author;

DROP TABLE IF EXISTS book;
CREATE TABLE book (
	bookId INT AUTO_INCREMENT,
		CONSTRAINT pk_book
			PRIMARY KEY (bookId),
	title VARCHAR(100) NOT NULL,
    publicationDate DATETIME
);
DESCRIBE book;

DROP TABLE IF EXISTS format;
CREATE TABLE format (
	formatId INT AUTO_INCREMENT,
		CONSTRAINT pk_format
			PRIMARY KEY (formatId),
	formatName VARCHAR(12) NOT NULL
);
DESCRIBE format;

DROP TABLE IF EXISTS genre;
CREATE TABLE genre ( 
	genreId INT AUTO_INCREMENT,
		CONSTRAINT pk_genre
			PRIMARY KEY (genreId),
	genreName VARCHAR(25) NOT NULL
);
DESCRIBE genre;

DROP TABLE IF EXISTS authorBook;
CREATE TABLE authorBook ( 
	authorId INT,
    bookId INT,
    CONSTRAINT pk_authorBook
		PRIMARY KEY (authorId, bookId),
	CONSTRAINT pk_authorBook_author
		FOREIGN KEY (authorId)
        REFERENCES author(authorId),
	CONSTRAINT pk_authorBook_book
		FOREIGN KEY (bookId)
        REFERENCES book(bookId)
);
DESCRIBE authorBook;

DROP TABLE IF EXISTS bookFormat;
CREATE TABLE bookFormat(
	bookId INT,
    formatId INT,
    CONSTRAINT pk_bookFormat
		PRIMARY KEY (bookId, formatId),
	CONSTRAINT pk_bookFormat_book
		FOREIGN KEY (bookId)
        REFERENCES book(bookId),
	CONSTRAINT pk_bookFormat_format
		FOREIGN KEY (formatId)
        REFERENCES format(formatId),
	price DOUBLE,
    quantityOnHand INT
);
DESCRIBE bookFormat;

DROP TABLE IF EXISTS bookGenre;
CREATE TABLE bookGenre (
	bookId INT,
    genreId INT, 
    CONSTRAINT pk_bookGenre
		PRIMARY KEY (bookId, genreId),
	CONSTRAINT pk_bookGenre_book
		FOREIGN KEY (bookId)
        REFERENCES book(bookId),
	CONSTRAINT pk_bookGenre_genreId
		FOREIGN KEY (genreId)
        REFERENCES genre(genreId)
);
DESCRIBE bookGenre;

SHOW TABLES;