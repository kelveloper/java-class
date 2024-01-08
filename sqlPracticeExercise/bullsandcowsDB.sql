-- Create the database
CREATE DATABASE IF NOT EXISTS bullsandcowsDB;

-- Use the created database
USE bullsandcowsDB;

-- Create the 'game' table
CREATE TABLE game (
    id INT PRIMARY KEY AUTO_INCREMENT,
    answer VARCHAR(4) NOT NULL,
    status ENUM('IN_PROGRESS', 'FINISHED') NOT NULL
);

-- Create the 'round' table
CREATE TABLE round (
    id INT PRIMARY KEY AUTO_INCREMENT,
    gameId INT NOT NULL,
    guess VARCHAR(4) NOT NULL,
    guessTime DATETIME NOT NULL,
    result VARCHAR(10) NOT NULL,
    FOREIGN KEY (gameId) REFERENCES game(id)
);

-- Insert a sample game
INSERT INTO game (answer, status) VALUES ('1234', 'IN_PROGRESS');

-- Insert sample rounds for the game
INSERT INTO round (gameId, guess, guessTime, result) VALUES
(1, '5678', '2024-01-05 12:00:00', 'e:0:p:0'),
(1, '1243', '2024-01-05 12:05:00', 'e:2:p:2'),
(1, '4321', '2024-01-05 12:10:00', 'e:0:p:4');