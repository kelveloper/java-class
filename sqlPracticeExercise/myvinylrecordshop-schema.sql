-- Kelvin Saldana
-- 12/20/2023

DROP DATABASE IF EXISTS myvinylrecordshop; -- won't throw err
CREATE DATABASE myvinylrecordshop; -- create new database
USE myvinylrecordshop; -- show action in output

-- Create album table
CREATE TABLE album (
    albumId INT AUTO_INCREMENT,
    CONSTRAINT pk_album 
        PRIMARY KEY (albumId),
    albumTitle VARCHAR(100) NOT NULL,
    label VARCHAR(50),
    releaseDate DATE,
    price DECIMAL(5,2) -- no commas at the end
);

DESCRIBE album; -- check if table works

DROP TABLE IF EXISTS artist;
CREATE TABLE artist (
	artistId INT AUTO_INCREMENT,
    CONSTRAINT pk_artist
		PRIMARY KEY (artistId),
	artistFirstName VARCHAR(25),
    artistLastName VARCHAR(50) NOT NULL
);

DESCRIBE artist;

DROP TABLE IF EXISTS band;
CREATE TABLE band ( 
	bandId INT AUTO_INCREMENT,
    CONSTRAINT pk_band
		PRIMARY KEY (bandId),
	bandName VARCHAR(50) NOT NULL
);

DESCRIBE band;

DROP TABLE IF EXISTS song;
CREATE TABLE song (
    songId INT NOT NULL AUTO_INCREMENT,
    songTitle VARCHAR(100) NOT NULL,
    videoUrl VARCHAR(100),
    bandId INT NOT NULL,
    CONSTRAINT pk_song 
    	PRIMARY KEY (songId),
    CONSTRAINT fk_song_band		-- FK after the PK
    	FOREIGN KEY (bandID)
    	REFERENCES band(bandId)
);

DESCRIBE song;

DROP TABLE IF EXISTS songAlbum;
CREATE TABLE songAlbum (
    songId INT,
    albumId INT,
    CONSTRAINT pk_songAlbum 			
    	PRIMARY KEY (songId, albumId),
    CONSTRAINT fk_songAlbum_song		
    	FOREIGN KEY (songId)			-- has composite key
    	REFERENCES song(songId),
    CONSTRAINT fk_songAlbum_album		
    	FOREIGN KEY (albumId)			-- has composite key
    	REFERENCES album(albumId)
);

DESCRIBE songAlbum;

DROP TABLE IF EXISTS bandArtist; 

CREATE TABLE bandArtist( 
	bandId INT,
    artistId Int,
    CONSTRAINT pk_bandArtist
		PRIMARY KEY (bandId, artistId),
	CONSTRAINT fk_bandArtist_band
		FOREIGN KEY (bandId)
        REFERENCES band(bandId),
	CONSTRAINT fk_bandArtist_artist
		FOREIGN KEY (artistId)
        REFERENCES artist(artistId)
);

DESCRIBE bandArtist;
SHOW TABLES;



