-- Kelvin Saldana 
-- 12/20/2023

USE vinylrecordshop;

-- INSERT INTO album 
-- VALUES (1,'Imagine','Apple','1971-9-9',9.99);

-- INSERT INTO album (albumTitle, releaseDate, price, label)
-- VALUES ('2525 (Exordium & Terminus)', '1969-7-1', 25.99, 'RCA');

-- INSERT INTO album (albumTitle, releaseDate, price, label)
-- VALUES 
-- 	ROW ("No One's Gonna Change Our World", '1969-12-12', 39.95,'Regal Starline'), 
-- 	ROW ('Moondance Studio Album', '1969-8-1',14.99,'Warner Bros');
    
-- INSERT INTO album (albumTitle, releaseDate, price, label)
-- VALUES 
-- 	  ROW ("Clouds", '1969-5-1', 9.99, "Reprise"),
--    ROW ("Sounds of Silence Studio Album", '1966-1-17', 9.99, "Columbia"),
--    ROW ("Abbey Road", '1969-10-1', 12.99, "Apple"),
--    ROW ("Smiley Smile", '1967-9-18', 5.99, "Capitol");
    
-- DELETE FROM album -- Deletes albumId #5 named "Cloud"
-- WHERE albumId = 5;

-- INSERT INTO album (albumTitle, releaseDate, price, label) -- Will now be #9 with no #5 in output 
-- VALUES ("Clouds", '1969-5-1', 9.99,'Reprise'); 

-- SELECT * FROM album;

-- USE vinylrecordshop;
-- UPDATE album 
-- 	SET albumId = 5
-- WHERE albumTitle = 'Clouds';

-- USE vinylrecordshop;
-- UPDATE album 
-- 	SET albumId = 9
-- WHERE albumTitle = 'Smiley Smile';

-- SELECT * FROM album;

-- USE vinylrecordshop;
-- DELETE FROM artist WHERE artistId < 30;

-- SELECT * FROM album;

-- LOAD DATA LOCAL INFILE 'C:/Users/kelvi/Documents/kelveloper_repos/sql-class/vinylrecordshop/artist.csv'
-- INTO TABLE vinylrecordshop.artist 
-- FIELDS TERMINATED BY ','; --USE THIS WHEN FILES ARE IN THE CORRECT ORDER AND NO TITLE/LABEL

-- SELECT * FROM artist;

-- USE vinylrecordshop;
-- SELECT * FROM band;

INSERT INTO `artist` 
	VALUES	(1,'John','Lennon',1),
			(2,'Paul','McCartney',1),
			(3,'George','Harrison',1),
            (4,'Ringo','Starr',1),
            (5,'Denny','Zager',0),
            (6,'Rick','Evans',0),
            (10,'Van','Morrison',1),
            (11,'Judy','Collins',0),
            (12,'Paul','Simon',1),
            (13,'Art','Garfunkel',0),
            (14,'Brian','Wilson',0),
            (15,'Dennis','Wilson',0),
            (16,'Carl','Wilson',0),
            (17,'Ricky','Fataar',0),
            (18,'Blondie','Chaplin',0),
            (19,'Jimmy','Page',0),
            (20,'Robert','Plant',0),
            (21,'John Paul','Jones',0),
            (22,'John','Bonham',0),
            (23,'Mike ','Love',0),
            (24,'Al ','Jardine',0),
            (25,'David','Marks',0),
            (26,'Bruce ','Johnston',0);
SELECT * FROM artist;

INSERT INTO `album` 
	VALUES	(1,'Imagine','Apple','1971-09-09',9.99),
			(2,'2525 (Exordium & Terminus)','RCA','1969-07-01',25.99),
            (3,'No One\'s Gonna Change Our World','Regal Starline','1969-12-12',39.95),
            (4,'Moondance Studio Album','Warner Bros','1969-08-01',14.99),
            (5,'Simon and Garfunkel',NULL,NULL,NULL),
            (6,'Sounds of Silence Studio Album','Columbia','1966-01-17',9.99),
            (7,'Abbey Road','Apple','1969-10-01',12.99),
            (8,'Smiley Smile','Capitol','1967-09-18',5.99),
            (9,'Clouds','Reprise','1969-05-01',9.99);
SELECT * FROM album;

