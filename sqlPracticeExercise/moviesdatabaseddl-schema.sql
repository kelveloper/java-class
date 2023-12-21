-- Kelvin Saldana 
-- 12/21/2023

DROP DATABASE IF EXISTS moviesdatabase;
CREATE DATABASE moviesdatabase;
USE moviesdatabase;

DROP TABLE IF EXISTS genre;
CREATE TABLE genre (
	genreId INT AUTO_INCREMENT,
		CONSTRAINT pk_genre
			PRIMARY KEY (genreId),
	genreName VARCHAR(30)
);
DESCRIBE genre;

DROP TABLE IF EXISTS director;
CREATE TABLE director (
	directorId INT AUTO_INCREMENT,
		CONSTRAINT pk_director
			PRIMARY KEY (directorId),
	firstName VARCHAR(30) NOT NULL,
    lastName VARCHAR(30) NOT NULL,
    birthDate DATE
);
DESCRIBE director;

DROP TABLE IF EXISTS rating;
CREATE TABLE rating (
	ratingId INT AUTO_INCREMENT,
		CONSTRAINT pk_rating
			PRIMARY KEY (ratingId),
	ratingName VARCHAR(5) NOT NULL
);
DESCRIBE rating;

DROP TABLE IF EXISTS actor;
CREATE TABLE actor (
	actorId INT AUTO_INCREMENT,
		CONSTRAINT pk_actor
			PRIMARY KEY (actorId),
	firstName VARCHAR(30) NOT NULL,
    lastName VARCHAR(30) NOT NULL,
    birthDate DATE
);
DESCRIBE actor;

DROP TABLE IF EXISTS movie;
CREATE TABLE movie (
	movieId INT AUTO_INCREMENT,
		CONSTRAINT pk_movie
			PRIMARY KEY (movieId),
    genreId INT NOT NULL,
		CONSTRAINT pk_movie_genre
			FOREIGN KEY (genreId)
            REFERENCES genre(genreId),
    directorId INT,
		CONSTRAINT pk_movie_director
			FOREIGN KEY (directorId)
            REFERENCES director(directorId),
    ratingID INT,
		CONSTRAINT pk_movie_rating
			FOREIGN KEY (ratingID)
            REFERENCES rating(ratingID),
	title VARCHAR(128) NOT NULL,
    releaseDate DATE
);
DESCRIBE movie;

DROP TABLE IF EXISTS castMembers;
CREATE TABLE castMembers (
	castMemberId INT AUTO_INCREMENT,
		CONSTRAINT pk_castMembers
			 PRIMARY KEY (castMemberId),
	actorId INT NOT NULL,
    movieId INT NOT NULL,
		CONSTRAINT pk_castMembers_actor
			FOREIGN KEY (actorId)
            REFERENCES actor(actorId),
		CONSTRAINT pk_castMembers_movie
			FOREIGN KEY (movieId)
            REFERENCES movie(movieId),
	role VARCHAR(50) NOT NULL
);
DESCRIBE castMembers;

SHOW TABLES;