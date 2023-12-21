-- This script will destroy your TrackIt database and start anew!
DROP DATABASE IF EXISTS TrackIt;

CREATE DATABASE TrackIt;

-- Make sure we're in the correct database before we add schema.
USE TrackIt;

CREATE TABLE Project (
	ProjectId CHAR(50) PRIMARY KEY,
    `Name` VARCHAR(100) NOT NULL,
    Summary VARCHAR(2000) NULL,
    DueDate DATE NULL,
    IsActive BOOL NOT NULL DEFAULT 1
);

CREATE TABLE Worker (
	WorkerId INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    EmailAddress VARCHAR(250) NULL
);

CREATE TABLE ProjectWorker (
	ProjectId CHAR(50) NOT NULL,
    WorkerId INT NOT NULL,
    PRIMARY KEY pk_ProjectWorker (ProjectId, WorkerId),
	FOREIGN KEY fk_ProjectWorker_Project (ProjectId)
		REFERENCES Project(ProjectId),
	FOREIGN KEY fk_ProjectWorker_Worker (WorkerId)
		REFERENCES Worker(WorkerId)
);

CREATE TABLE TaskType (
	TaskTypeId INT PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(50) NOT NULL
);

CREATE TABLE TaskStatus (
	TaskStatusId INT PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(50) NOT NULL,
    IsResolved BOOL NOT NULL
);

CREATE TABLE Task (

	TaskId INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(100) NOT NULL,
    Details TEXT NULL,
    DueDate DATE NOT NULL,
    EstimatedHours DECIMAL(5, 2) NULL,
    ProjectId CHAR(50) NOT NULL,
    WorkerId INT NOT NULL,
    TaskTypeId INT NOT NULL,
    TaskStatusId INT NULL,
    ParentTaskId INT NULL,
    
    FOREIGN KEY fk_Task_ProjectWorker (ProjectId, WorkerId)
		REFERENCES ProjectWorker(ProjectId, WorkerId),
	FOREIGN KEY fk_Task_TaskType (TaskTypeId)
		REFERENCES TaskType(TaskTypeId),
	FOREIGN KEY fk_Task_TaskStatus (TaskStatusId)
		REFERENCES TaskStatus(TaskStatusId),
	FOREIGN KEY fk_Task_Task (ParentTaskId)
		REFERENCES Task(TaskId)
);

INSERT INTO TaskType (TaskTypeId, `Name`) VALUES
    (1, 'User Story'),
    (2, 'Task'),
    (3, 'Bug/Issue');

INSERT INTO TaskStatus (TaskStatusId, `Name`, IsResolved) VALUES
    (1, 'Parked', 0),
    (2, 'In Progress', 0),
    (3, 'Testing/Validation', 0),
    (4, 'Pending Release', 0),
    (5, 'Resolved', 1),
    (6, 'Resolved, Will Not Fix', 1),
    (7, 'Resolved, Duplicate', 1),
    (8, 'Closed', 1);

INSERT INTO Project(ProjectId, `Name`, Summary, DueDate, IsActive) VALUES
    ('payroll', 'GameIt Payroll', 'Employee payroll, bonuses, and PTO tracking. Mission critical.', null, 1),
    ('hr', 'GameIt Human Resource Intranet', 'SharePoint intranet and document storage', '2013-08-12', 0),
    ('hr-v2', 'GameIt HR Intranet V2', 'Improved usability, simpler interface, a better intranet experience...', null, 1),
    ('accounts-receivable', 'GameIt Accounts Receivable', 'Internal accounting application. Requires integration with accounts receivable project.', '2020-12-31', 1),
    ('accounts-payable', 'GameIt Accounts Payable', 'Internal accounting application', null, 1),
    ('game-toga', 'Tic-Tac-Toga', 'GameIt''s first game!', '1999-12-31', 0),
    ('game-breakout', 'Middle School Breakout', 'Like whack-a-mole, but with acne. Still a hit after all these years.', '2005-05-20', 1),
    ('game-breakout-mobile', 'Middle School Breakout Mobile', 'iOS and Android rewrite of Middle School Breakout', '2018-11-05', 1),
    ('game-sisyphus', 'I Am Sisyphus', 'An open world, open rules, player-directed game. You can''t win, or maybe you can, we''ll never truly know.', '2017-06-12', 1),
    ('game-cooker', 'CookerMaker', 'Time management cooking game. You pick the cuisine.', '2019-01-12', 1),
    ('game-cheese', 'Don''t Eat The Cheese!', 'Based on a true story about an angry tummy in Prague.', '2010-01-19', 0),
    ('game-stormchaser', 'Stormchaser', 'Study weather in the lab and... In the eye of the storm!', '2015-06-01', 1),
    ('game-patience', 'The Patience Game', 'Described by Rock, Scissors, Shotgun as "quiet", "fixed", and "prosaic".', '2018-02-25', 1),
    ('game-horror', 'Horror in Iowa', '', '2018-10-15', 0),
    ('game-goodboy', 'Who''s a GOOD boy!?', 'Dog simulator', '2019-01-07', 1),
    ('game-midge', 'Midge', 'Experience the world as Midge.', '2015-12-31', 0),
    ('enterprise-crm', 'GameIt Enterprise', 'GameIt''s one and only foray into "enterprise" software. Retired.', '2014-08-01', 0),
    ('game-diva', 'Diva Diva Diva', 'Out-sing and out-dance your opponents in this kinetic PvP game. (Requires spatial controllers.)', '2017-11-10', 1),
    ('game-mafia', 'Mafia Hedgefund', '', '2017-09-01', 1),
    ('game-midge2', 'Midge II', 'The blockbuster sequel to Midge!', '2017-12-31', 1),
    ('game-postmodern', 'Postmodern Love Letter', '', '2017-09-01', 1),
    ('game-smell', 'Do you smell that?', 'Best forgotten.', '2016-05-01', 0),
    ('game-bike', 'Ride A Bike!', '', '2018-09-05', 1),
    ('game-grumps', 'Grumps', '', '2018-11-01', 1),
    ('game-churlish', 'Churlish Curling', '', '2018-07-20', 1),
    ('game-economy', 'It''s the Economy, Stupid!', 'Gather resources, build stuff with them, trade with your neighbors. It''s about who you know, not what you know.', '2018-11-25', 1),
    ('game-midge3', 'Midge III', 'Live as Midge in VR and AR.', '2020-12-31', 1);

INSERT INTO Worker (WorkerId, FirstName, LastName, EmailAddress) VALUES
    (1, 'Inez', 'Fanthome', 'ifanthome0@latimes.com'),
    (2, 'Lindy', 'Chattoe', 'lchattoe1@bloglines.com'),
    (3, 'Thorin', 'Achromov', 'tachromov2@blogtalkradio.com'),
    (4, 'Rickie', 'Osgodby', 'rosgodby3@ustream.tv'),
    (5, 'Andriette', 'Dimsdale', 'adimsdale4@google.co.uk'),
    (6, 'May', 'Newbury', 'mnewbury5@yellowbook.com'),
    (7, 'Enoch', 'Innerstone', 'einnerstone6@skyrock.com'),
    (8, 'Buddy', 'Mougel', 'bmougel7@sohu.com'),
    (9, 'Tally', 'Zorzi', 'tzorzi8@nsw.gov.au'),
    (10, 'Aidan', 'Pfeffle', 'apfeffle9@linkedin.com'),
    (11, 'Robina', 'McKernan', 'rmckernana@tinypic.com'),
    (12, 'Aubrey', 'Puttergill', 'aputtergillb@t-online.de'),
    (13, 'Xavier', 'Gheorghescu', 'xgheorghescuc@businessinsider.com'),
    (14, 'Halli', 'Vel', 'hveld@marketwatch.com'),
    (15, 'Vlad', 'Anfusso', 'vanfussoe@wsj.com'),
    (16, 'Karlen', 'Egalton', 'kegaltonf@hexun.com'),
    (17, 'Kenon', 'Kirkham', 'kkirkhamg@tinyurl.com'),
    (18, 'Delbert', 'Malt', 'dmalth@yellowpages.com'),
    (19, 'August', 'Arthurs', 'aarthursi@npr.org'),
    (20, 'Nora', 'Riha', 'nrihaj@istockphoto.com'),
    (21, 'Jehu', 'Ding', 'jdingk@amazon.de'),
    (22, 'Tiffie', 'Gaylor', 'tgaylorl@livejournal.com'),
    (23, 'Luci', 'Reeves', 'lreevesm@istockphoto.com'),
    (24, 'Verena', 'Prince', 'vprincen@wiley.com'),
    (25, 'Goldy', 'Feast', 'gfeasto@domainmarket.com'),
    (26, 'Carny', 'Atton', 'cattonp@mail.ru'),
    (27, 'Renell', 'Cathel', 'rcathelq@blog.com'),
    (28, 'Julia', 'Creenan', 'jcreenanr@sohu.com'),
    (29, 'Ealasaid', 'Blinco', 'eblincos@ucoz.com'),
    (30, 'Roshelle', 'Antoniades', 'rantoniadest@patch.com'),
    (31, 'Blinnie', 'Kersting', 'bkerstingu@clickbank.net'),
    (32, 'Sabra', 'Caskie', 'scaskiev@prlog.org'),
    (33, 'Viviana', 'Seabridge', 'vseabridgew@wunderground.com'),
    (34, 'Maurene', 'Doulton', 'mdoultonx@sbwire.com'),
    (35, 'Andrej', 'Fernao', 'afernaoy@shareasale.com'),
    (36, 'Corbett', 'Senten', 'csentenz@state.gov'),
    (37, 'Corrinne', 'Stebbing', 'cstebbing10@wikia.com'),
    (38, 'Zea', 'Irving', 'zirving11@myspace.com'),
    (39, 'Neddy', 'Wethered', 'nwethered12@over-blog.com'),
    (40, 'Budd', 'Izen', 'bizen13@theglobeandmail.com'),
    (41, 'Silvia', 'Steinhammer', 'ssteinhammer14@wunderground.com'),
    (42, 'Vinni', 'Sive', 'vsive15@oracle.com'),
    (43, 'Cherri', 'Binden', 'cbinden16@merriam-webster.com'),
    (44, 'Tabbie', 'Toothill', 'ttoothill17@ask.com'),
    (45, 'Blake', 'Larcier', 'blarcier18@uol.com.br'),
    (46, 'Mikkel', 'Fronczak', 'mfronczak19@ibm.com'),
    (47, 'Ardyce', 'Lewins', 'alewins1a@4shared.com'),
    (48, 'Husein', 'Plante', 'hplante1b@amazon.de'),
    (49, 'Josee', 'Knapton', 'jknapton1c@constantcontact.com'),
    (50, 'Dionisio', 'Allnatt', 'dallnatt1d@webnode.com'),
    (51, 'Briano', 'Pitkins', 'bpitkins1e@ftc.gov'),
    (52, 'Berny', 'Sabates', 'bsabates1f@japanpost.jp'),
    (53, 'Nester', 'Peat', 'npeat1g@elpais.com'),
    (54, 'Dehlia', 'Rihanek', 'drihanek1h@illinois.edu'),
    (55, 'Jaquenetta', 'Pauel', 'jpauel1i@cnbc.com'),
    (56, 'Dudley', 'Kos', 'dkos1j@wunderground.com'),
    (57, 'Evita', 'Shepeard', 'eshepeard1k@storify.com'),
    (58, 'Philis', 'Marion', 'pmarion1l@xing.com'),
    (59, 'Adrienne', 'Eastlake', 'aeastlake1m@merriam-webster.com'),
    (60, 'Juliet', 'Strivens', 'jstrivens1n@ted.com'),
    (61, 'Conrado', 'Crosby', 'ccrosby1o@spotify.com'),
    (62, 'Lynde', 'Bohlje', 'lbohlje1p@wikimedia.org'),
    (63, 'Courtney', 'Wichard', 'cwichard1q@lycos.com'),
    (64, 'Evangelia', 'Benn', 'ebenn1r@elpais.com'),
    (65, 'Matty', 'Dance', 'mdance1s@google.fr'),
    (66, 'Alia', 'Rozycki', 'arozycki1t@symantec.com'),
    (67, 'Cassandry', 'Hendin', 'chendin1u@nih.gov'),
    (68, 'Marty', 'Jaime', 'mjaime1v@wix.com'),
    (69, 'Dannie', 'Bradly', 'dbradly1w@photobucket.com'),
    (70, 'Kerwinn', 'Meadus', 'kmeadus1x@ebay.co.uk'),
    (71, 'Phil', 'Chattaway', 'pchattaway1y@auda.org.au'),
    (72, 'Mari', 'Tootell', 'mtootell1z@wikimedia.org'),
    (73, 'Meryl', 'Imlacke', 'mimlacke20@themeforest.net'),
    (74, 'Winston', 'Marien', 'wmarien21@imgur.com'),
    (75, 'Sheeree', 'McVicar', 'smcvicar22@salon.com'),
    (76, 'Dalis', 'Krauss', 'dkrauss23@epa.gov'),
    (77, 'Margarette', 'Kippie', 'mkippie24@devhub.com'),
    (78, 'Bryn', 'Quirk', 'bquirk25@bandcamp.com'),
    (79, 'Minna', 'Jonk', 'mjonk26@yahoo.com'),
    (80, 'Chryste', 'Startin', 'cstartin27@microsoft.com'),
    (81, 'Rudd', 'Kitcherside', 'rkitcherside28@twitpic.com'),
    (82, 'Winny', 'Lawles', 'wlawles29@123-reg.co.uk'),
    (83, 'Cullen', 'Romayn', 'cromayn2a@shutterfly.com'),
    (84, 'Ephrayim', 'Aleswell', 'ealeswell2b@smh.com.au'),
    (85, 'Sandie', 'Phinnessy', 'sphinnessy2c@statcounter.com'),
    (86, 'Lisetta', 'Ibarra', 'libarra2d@fc2.com'),
    (87, 'Wayne', 'Lethardy', 'wlethardy2e@myspace.com'),
    (88, 'Audry', 'Marler', 'amarler2f@comcast.net'),
    (89, 'Inglis', 'Wilne', 'iwilne2g@purevolume.com'),
    (90, 'Mauricio', 'Bolitho', 'mbolitho2h@admin.ch'),
    (91, 'Remington', 'Youell', 'ryouell2i@unicef.org'),
    (92, 'Margery', 'Grzeskowski', 'mgrzeskowski2j@vkontakte.ru'),
    (93, 'Bari', 'Fillan', 'bfillan2k@blogtalkradio.com'),
    (94, 'Imogen', 'Garstang', 'igarstang2l@cnbc.com'),
    (95, 'Ynez', 'Rego', 'yrego2m@godaddy.com'),
    (96, 'Ophelie', 'Bullas', 'obullas2n@umn.edu'),
    (97, 'Dianemarie', 'Atley', 'datley2o@techcrunch.com'),
    (98, 'Delano', 'Owbridge', 'dowbridge2p@businesswire.com'),
    (99, 'Josie', 'Swede', 'jswede2q@fda.gov'),
    (100, 'Danyelle', 'O''Hanley', 'dohanley2r@people.com.cn');

INSERT INTO ProjectWorker (ProjectId, WorkerId) VALUES
    ('payroll', 5),
    ('payroll', 45),
    ('payroll', 100),
    ('payroll', 37),
    ('payroll', 64),
    ('payroll', 60),
    ('payroll', 6),
    ('hr', 21),
    ('hr', 29),
    ('hr', 60),
    ('hr', 1),
    ('hr', 19),
    ('hr', 53),
    ('hr', 94),
    ('hr', 46),
    ('hr-v2', 82),
    ('hr-v2', 28),
    ('hr-v2', 35),
    ('hr-v2', 87),
    ('hr-v2', 41),
    ('hr-v2', 9),
    ('hr-v2', 60),
    ('hr-v2', 32),
    ('accounts-receivable', 21),
    ('accounts-receivable', 16),
    ('accounts-receivable', 2),
    ('accounts-receivable', 10),
    ('accounts-receivable', 79),
    ('accounts-payable', 29),
    ('accounts-payable', 69),
    ('accounts-payable', 38),
    ('accounts-payable', 17),
    ('accounts-payable', 10),
    ('accounts-payable', 14),
    ('accounts-payable', 65),
    ('accounts-payable', 43),
    ('game-toga', 5),
    ('game-toga', 100),
    ('game-toga', 9),
    ('game-toga', 29),
    ('game-breakout', 66),
    ('game-breakout', 56),
    ('game-breakout', 36),
    ('game-breakout', 37),
    ('game-breakout', 34),
    ('game-breakout', 32),
    ('game-breakout', 96),
    ('game-breakout', 30),
    ('game-breakout-mobile', 100),
    ('game-breakout-mobile', 57),
    ('game-breakout-mobile', 31),
    ('game-breakout-mobile', 7),
    ('game-breakout-mobile', 18),
    ('game-sisyphus', 71),
    ('game-sisyphus', 54),
    ('game-sisyphus', 40),
    ('game-sisyphus', 72),
    ('game-cooker', 22),
    ('game-cooker', 78),
    ('game-cooker', 53),
    ('game-cooker', 63),
    ('game-cooker', 74),
    ('game-cooker', 59),
    ('game-cooker', 43),
    ('game-cooker', 28),
    ('game-cooker', 97),
    ('game-cheese', 62),
    ('game-cheese', 94),
    ('game-cheese', 60),
    ('game-cheese', 25),
    ('game-stormchaser', 68),
    ('game-stormchaser', 85),
    ('game-stormchaser', 59),
    ('game-stormchaser', 16),
    ('game-stormchaser', 23),
    ('game-stormchaser', 28),
    ('game-patience', 74),
    ('game-patience', 1),
    ('game-patience', 90),
    ('game-patience', 42),
    ('game-horror', 70),
    ('game-horror', 92),
    ('game-horror', 99),
    ('game-horror', 95),
    ('game-horror', 89),
    ('game-horror', 11),
    ('game-horror', 72),
    ('game-horror', 12),
    ('game-goodboy', 29),
    ('game-goodboy', 58),
    ('game-goodboy', 15),
    ('game-goodboy', 47),
    ('game-goodboy', 57),
    ('game-goodboy', 82),
    ('game-goodboy', 69),
    ('game-midge', 87),
    ('game-midge', 1),
    ('game-midge', 83),
    ('game-midge', 74),
    ('game-midge', 7),
    ('game-midge', 61),
    ('game-midge', 50),
    ('game-midge', 97),
    ('game-midge', 89),
    ('enterprise-crm', 93),
    ('enterprise-crm', 47),
    ('enterprise-crm', 17),
    ('enterprise-crm', 15),
    ('game-diva', 16),
    ('game-diva', 46),
    ('game-diva', 34),
    ('game-diva', 13),
    ('game-diva', 75),
    ('game-diva', 23),
    ('game-diva', 37),
    ('game-diva', 69),
    ('game-mafia', 94),
    ('game-mafia', 23),
    ('game-mafia', 57),
    ('game-mafia', 88),
    ('game-mafia', 36),
    ('game-midge2', 82),
    ('game-midge2', 91),
    ('game-midge2', 65),
    ('game-midge2', 58),
    ('game-midge2', 97),
    ('game-midge2', 93),
    ('game-postmodern', 77),
    ('game-postmodern', 10),
    ('game-postmodern', 60),
    ('game-postmodern', 63),
    ('game-postmodern', 74),
    ('game-bike', 11),
    ('game-bike', 94),
    ('game-bike', 98),
    ('game-bike', 16),
    ('game-bike', 82),
    ('game-bike', 92),
    ('game-bike', 42),
    ('game-bike', 37),
    ('game-grumps', 56),
    ('game-grumps', 9),
    ('game-grumps', 80),
    ('game-grumps', 67),
    ('game-grumps', 99),
    ('game-grumps', 52),
    ('game-churlish', 66),
    ('game-churlish', 23),
    ('game-churlish', 13),
    ('game-churlish', 67),
    ('game-churlish', 79),
    ('game-churlish', 35),
    ('game-churlish', 4),
    ('game-churlish', 39),
    ('game-economy', 5),
    ('game-economy', 84),
    ('game-economy', 34),
    ('game-economy', 49),
    ('game-economy', 24),
    ('game-economy', 15),
    ('game-economy', 3),
    ('game-midge3', 94),
    ('game-midge3', 8),
    ('game-midge3', 96),
    ('game-midge3', 88);


INSERT INTO Task (TaskId, Title, Details, DueDate, EstimatedHours, ProjectId, WorkerId, TaskTypeId, TaskStatusId, ParentTaskId) VALUES
    (1, 'Log in', '', '2007-02-19', 22.00, 'payroll', 60, 1, 2, null),
    (2, 'Refactor data store', '', '2015-04-04', 5.25, 'payroll', 5, 2, 2, 1),
    (3, 'Refactor service layer and classes', '', '2018-09-03', 4.75, 'payroll', 64, 2, 6, 1),
    (4, 'Create network architecture', '', '2009-11-13', 4.25, 'payroll', 60, 2, 4, 1),
    (5, 'Refactor interface', '', '2002-05-13', 7.75, 'payroll', 64, 2, 6, 1),
    (6, 'Log out', '', '2007-07-19', 26.25, 'payroll', 5, 1, 8, null),
    (7, 'Refactor database', '', '2008-12-25', 8.00, 'payroll', 45, 2, 3, 6),
    (8, 'Construct service layer and classes', '', '2011-11-22', 2.25, 'payroll', 37, 2, 7, 6),
    (9, 'Implement network architecture', '', '2007-04-07', 8.00, 'payroll', 37, 2, 5, 6),
    (10, 'Create front-end components', '', '2000-05-10', 8.00, 'payroll', 6, 2, 5, 6),
    (11, 'Add an employee', '', '2005-09-17', 24.25, 'payroll', 45, 1, 8, null),
    (12, 'Construct database', '', '2013-07-06', 7.00, 'payroll', 5, 2, 2, 11),
    (13, 'Refactor domain services', '', '2017-06-16', 6.50, 'payroll', 37, 2, 6, 11),
    (14, 'Extend fail-over chain', '', '2018-03-25', 7.25, 'payroll', 45, 2, 7, 11),
    (15, 'Model UI', '', '2006-04-12', 3.50, 'payroll', 60, 2, 5, 11),
    (16, 'Edit an employee', '', '2008-05-14', 25.50, 'payroll', 5, 1, 8, null),
    (17, 'Prototype data components and access', '', '2018-02-06', 3.25, 'payroll', 100, 2, 4, 16),
    (18, 'Check domain rules and structure', '', '2006-01-23', 6.25, 'payroll', 64, 2, 6, 16),
    (19, 'Implement network APIs', '', '2008-02-03', 8.00, 'payroll', 5, 2, 2, 16),
    (20, 'Model interface', '', '2015-01-06', 8.00, 'payroll', 100, 2, 7, 16),
    (21, 'Disable an employee', '', '2007-11-21', 21.00, 'payroll', 100, 1, 1, null),
    (22, 'Build data store', '', '2006-01-27', 4.25, 'payroll', 6, 2, 3, 21),
    (23, 'Lay out service layer and classes', '', '2009-12-09', 4.00, 'payroll', 100, 2, 1, 21),
    (24, 'Construct authentication and authorization', '', '2000-03-23', 8.00, 'payroll', 5, 2, 1, 21),
    (25, 'Construct user interface', '', '2015-09-15', 4.75, 'payroll', 45, 2, null, 21),
    (26, 'Submit timesheet', '', '2014-04-10', 18.25, 'payroll', 6, 1, 8, null),
    (27, 'Profile database', '', '2006-06-01', 3.75, 'payroll', 64, 2, 1, 26),
    (28, 'Lay out domain services', '', '2008-12-08', 8.00, 'payroll', 60, 2, 2, 26),
    (29, 'Lay out fail-over chain', '', '2001-03-16', 2.25, 'payroll', 6, 2, 2, 26),
    (30, 'Extend user interface', '', '2019-07-03', 4.25, 'payroll', 6, 2, 2, 26),
    (31, 'I appear to be logged in as someone else.', '', '2017-02-01', 7.25, 'payroll', 6, 3, 1, null),
    (32, 'Upload a document', '', '2018-07-25', 17.00, 'hr', 29, 1, 2, null),
    (33, 'Lay out schema', '', '2010-09-26', 3.00, 'hr', 29, 2, 3, 32),
    (34, 'Lay out service layer and classes', '', '2013-07-07', 3.00, 'hr', 19, 2, 5, 32),
    (35, 'Model fail-over chain', '', '2003-01-13', 5.75, 'hr', 53, 2, 8, 32),
    (36, 'Lay out interface', '', '2009-07-14', 5.25, 'hr', 19, 2, 4, 32),
    (37, 'Post an announcement', '', '2015-05-09', 20.50, 'hr', 21, 1, 8, null),
    (38, 'Lay out data store', '', '2018-06-24', 5.25, 'hr', 94, 2, 3, 37),
    (39, 'Refactor service layer and classes', '', '2016-10-10', 5.75, 'hr', 53, 2, 5, 37),
    (40, 'Construct authentication and authorization', '', '2010-02-14', 7.25, 'hr', 21, 2, 8, 37),
    (41, 'Refactor views', '', '2000-09-26', 2.25, 'hr', 19, 2, 8, 37),
    (42, 'Remove an announcement', '', '2003-12-10', 15.50, 'hr', 46, 1, 8, null),
    (43, 'Add schema', '', '2002-12-06', 3.00, 'hr', 19, 2, 6, 42),
    (44, 'Check domain services', '', '2017-01-05', 6.75, 'hr', 19, 2, 5, 42),
    (45, 'Extend authentication and authorization', '', '2016-09-25', 2.75, 'hr', 60, 2, 6, 42),
    (46, 'Profile front-end components', '', '2005-02-20', 3.00, 'hr', 53, 2, 6, 42),
    (47, 'W2 download link doesn''t work', '', '2002-07-06', 7.00, 'hr', 29, 3, 2, null),
    (48, 'Upload a document', '', '2008-01-27', 13.50, 'hr-v2', 28, 1, 4, null),
    (49, 'Implement data components and access', '', '2011-12-12', 4.00, 'hr-v2', 28, 2, 7, 48),
    (50, 'Check service layer and classes', '', '2006-11-06', 2.25, 'hr-v2', 87, 2, null, 48),
    (51, 'Design authentication and authorization', '', '2008-01-06', 2.25, 'hr-v2', 41, 2, 6, 48),
    (52, 'Build front-end components', '', '2004-01-01', 5.00, 'hr-v2', 60, 2, 3, 48),
    (53, 'Search documents', '', '2005-03-08', 24.25, 'hr-v2', 87, 1, 5, null),
    (54, 'Build tables and relationships', '', '2010-12-06', 7.50, 'hr-v2', 82, 2, 1, 53),
    (55, 'Build domain rules and structure', '', '2006-01-25', 4.75, 'hr-v2', 35, 2, 6, 53),
    (56, 'Implement fail-over chain', '', '2006-03-22', 4.25, 'hr-v2', 35, 2, 2, 53),
    (57, 'Prototype views', '', '2006-08-01', 7.75, 'hr-v2', 35, 2, 5, 53),
    (58, 'Post an announcement', '', '2000-12-02', 21.25, 'hr-v2', 35, 1, 5, null),
    (59, 'Build data components and access', '', '2002-12-26', 4.00, 'hr-v2', 35, 2, 7, 58),
    (60, 'Profile domain services', '', '2018-06-13', 6.75, 'hr-v2', 41, 2, 3, 58),
    (61, 'Add fail-over chain', '', '2005-08-19', 5.50, 'hr-v2', 41, 2, 6, 58),
    (62, 'Construct interface', '', '2009-07-04', 5.00, 'hr-v2', 87, 2, 2, 58),
    (63, 'Search announcements', '', '2009-11-06', 26.00, 'hr-v2', 60, 1, 5, null),
    (64, 'Create schema', '', '2008-03-08', 6.75, 'hr-v2', 82, 2, 4, 63),
    (65, 'Design service layer and classes', '', '2012-07-13', 5.50, 'hr-v2', 87, 2, 6, 63),
    (66, 'Implement network APIs', '', '2004-03-27', 7.00, 'hr-v2', 82, 2, 6, 63),
    (67, 'Model user interface', '', '2000-08-10', 6.75, 'hr-v2', 28, 2, 7, 63),
    (68, 'Edit and announcement', '', '2018-06-09', 16.75, 'hr-v2', 41, 1, 6, null),
    (69, 'Prototype data components and access', '', '2011-08-27', 3.25, 'hr-v2', 82, 2, 7, 68),
    (70, 'Extend service layer and classes', '', '2018-08-24', 2.50, 'hr-v2', 87, 2, 1, 68),
    (71, 'Create authentication and authorization', '', '2018-12-26', 7.00, 'hr-v2', 32, 2, 4, 68),
    (72, 'Build front-end components', '', '2003-05-13', 4.00, 'hr-v2', 28, 2, 5, 68),
    (73, 'Remove and announcement', '', '2015-01-07', 20.50, 'hr-v2', 9, 1, 3, null),
    (74, 'Create data store', '', '2002-10-07', 6.25, 'hr-v2', 60, 2, 8, 73),
    (75, 'Profile domain rules and structure', '', '2002-04-23', 6.00, 'hr-v2', 9, 2, null, 73),
    (76, 'Extend authentication and authorization', '', '2007-05-23', 5.50, 'hr-v2', 32, 2, 2, 73),
    (77, 'Build user interface', '', '2009-01-24', 2.75, 'hr-v2', 32, 2, 4, 73),
    (78, 'Log in', '', '2014-08-18', 21.75, 'accounts-receivable', 10, 1, 3, null),
    (79, 'Profile schema', '', '2007-02-06', 2.75, 'accounts-receivable', 16, 2, 8, 78),
    (80, 'Build domain services', '', '2015-04-23', 6.50, 'accounts-receivable', 10, 2, 8, 78),
    (81, 'Profile network architecture', '', '2014-08-22', 5.75, 'accounts-receivable', 10, 2, 7, 78),
    (82, 'Design UI', '', '2013-05-09', 6.75, 'accounts-receivable', 2, 2, 8, 78),
    (83, 'Log out', '', '2019-10-01', 19.75, 'accounts-receivable', 79, 1, 8, null),
    (84, 'Extend data components and access', '', '2013-09-01', 2.50, 'accounts-receivable', 16, 2, 5, 83),
    (85, 'Build service layer and classes', '', '2013-09-19', 6.50, 'accounts-receivable', 16, 2, 8, 83),
    (86, 'Add network architecture', '', '2008-02-04', 3.25, 'accounts-receivable', 21, 2, 8, 83),
    (87, 'Check views', '', '2013-07-09', 7.50, 'accounts-receivable', 16, 2, 1, 83),
    (88, 'Generate an invoice', '', '2017-08-23', 20.75, 'accounts-receivable', 16, 1, 6, null),
    (89, 'Lay out schema', '', '2015-06-18', 6.00, 'accounts-receivable', 10, 2, 2, 88),
    (90, 'Create domain services', '', '2013-09-23', 3.50, 'accounts-receivable', 79, 2, 2, 88),
    (91, 'Construct network architecture', '', '2014-02-03', 6.50, 'accounts-receivable', 79, 2, 1, 88),
    (92, 'Construct views', '', '2002-04-15', 4.75, 'accounts-receivable', 10, 2, 6, 88),
    (93, 'Apply a payment', '', '2010-06-04', 26.50, 'accounts-receivable', 2, 1, 4, null),
    (94, 'Model schema', '', '2002-10-17', 8.00, 'accounts-receivable', 10, 2, 6, 93),
    (95, 'Add service layer and classes', '', '2018-11-02', 5.25, 'accounts-receivable', 16, 2, 1, 93),
    (96, 'Profile network APIs', '', '2003-06-27', 7.25, 'accounts-receivable', 21, 2, 7, 93),
    (97, 'Profile UI', '', '2005-02-04', 6.00, 'accounts-receivable', 21, 2, 7, 93),
    (98, 'Send invoice reminder', '', '2009-08-17', 16.00, 'accounts-receivable', 16, 1, 8, null),
    (99, 'Build database', '', '2018-07-02', 5.50, 'accounts-receivable', 79, 2, 4, 98),
    (100, 'Extend service layer and classes', '', '2001-03-23', 3.00, 'accounts-receivable', 2, 2, null, 98),
    (101, 'Lay out network architecture', '', '2005-12-24', 4.50, 'accounts-receivable', 16, 2, 3, 98),
    (102, 'Construct front-end components', '', '2004-09-17', 3.00, 'accounts-receivable', 2, 2, 3, 98),
    (103, 'Report 30/60/90 day invoices', '', '2003-05-28', 24.25, 'accounts-receivable', 2, 1, 6, null),
    (104, 'Design tables and relationships', '', '2002-06-23', 5.50, 'accounts-receivable', 16, 2, 2, 103),
    (105, 'Check domain services', '', '2017-09-27', 7.75, 'accounts-receivable', 10, 2, 4, 103),
    (106, 'Profile network architecture', '', '2007-02-06', 6.75, 'accounts-receivable', 21, 2, 5, 103),
    (107, 'Construct front-end components', '', '2005-12-17', 4.25, 'accounts-receivable', 2, 2, 1, 103),
    (108, 'Log in', '', '2002-09-15', 18.75, 'accounts-payable', 29, 1, 8, null),
    (109, 'Design database', '', '2006-10-18', 5.25, 'accounts-payable', 29, 2, 7, 108),
    (110, 'Extend domain services', '', '2013-01-08', 4.00, 'accounts-payable', 17, 2, 6, 108),
    (111, 'Profile network architecture', '', '2018-04-17', 2.75, 'accounts-payable', 29, 2, 8, 108),
    (112, 'Model UI', '', '2010-08-27', 6.75, 'accounts-payable', 14, 2, 1, 108),
    (113, 'Log out', '', '2012-12-02', 20.75, 'accounts-payable', 17, 1, 7, null),
    (114, 'Create data store', '', '2019-07-26', 7.50, 'accounts-payable', 14, 2, 8, 113),
    (115, 'Design domain services', '', '2007-05-04', 5.25, 'accounts-payable', 65, 2, 4, 113),
    (116, 'Construct authentication and authorization', '', '2008-08-21', 2.50, 'accounts-payable', 65, 2, 8, 113),
    (117, 'Create views', '', '2000-02-11', 5.50, 'accounts-payable', 38, 2, 3, 113),
    (118, 'Pay an invoice', '', '2012-12-07', 19.50, 'accounts-payable', 38, 1, 7, null),
    (119, 'Create data components and access', '', '2011-10-10', 5.50, 'accounts-payable', 10, 2, 6, 118),
    (120, 'Model domain rules and structure', '', '2009-12-23', 3.75, 'accounts-payable', 14, 2, 6, 118),
    (121, 'Add network architecture', '', '2017-07-06', 4.50, 'accounts-payable', 43, 2, 6, 118),
    (122, 'Build views', '', '2016-09-10', 5.75, 'accounts-payable', 17, 2, 6, 118),
    (123, 'Generate outstanding invoice report', '', '2019-04-10', 15.50, 'accounts-payable', 38, 1, 2, null),
    (124, 'Profile data store', '', '2019-08-21', 3.75, 'accounts-payable', 14, 2, 6, 123),
    (125, 'Design domain services', '', '2003-10-20', 2.75, 'accounts-payable', 29, 2, null, 123),
    (126, 'Prototype fail-over chain', '', '2002-05-27', 4.25, 'accounts-payable', 43, 2, 2, 123),
    (127, 'Refactor views', '', '2000-08-06', 4.75, 'accounts-payable', 29, 2, 8, 123),
    (128, 'Record vendor communication', '', '2013-05-03', 22.00, 'accounts-payable', 17, 1, 1, null),
    (129, 'Refactor tables and relationships', '', '2004-11-18', 6.75, 'accounts-payable', 65, 2, 1, 128),
    (130, 'Lay out domain rules and structure', '', '2004-02-28', 7.25, 'accounts-payable', 29, 2, 2, 128),
    (131, 'Construct network APIs', '', '2006-12-14', 5.75, 'accounts-payable', 65, 2, 5, 128),
    (132, 'Construct user interface', '', '2001-04-17', 2.25, 'accounts-payable', 43, 2, 3, 128),
    (133, 'Log in', '', '2004-01-11', 22.75, 'enterprise-crm', 47, 1, 2, null),
    (134, 'Prototype data store', '', '2014-10-16', 6.25, 'enterprise-crm', 93, 2, 1, 133),
    (135, 'Check service layer and classes', '', '2007-06-20', 4.50, 'enterprise-crm', 93, 2, 1, 133),
    (136, 'Design fail-over chain', '', '2001-08-28', 4.25, 'enterprise-crm', 93, 2, 1, 133),
    (137, 'Add user interface', '', '2011-12-17', 7.75, 'enterprise-crm', 15, 2, 2, 133),
    (138, 'Log out', '', '2016-07-24', 20.50, 'enterprise-crm', 17, 1, 7, null),
    (139, 'Extend tables and relationships', '', '2016-06-27', 3.00, 'enterprise-crm', 47, 2, 1, 138),
    (140, 'Prototype domain services', '', '2002-03-05', 5.25, 'enterprise-crm', 47, 2, 8, 138),
    (141, 'Create fail-over chain', '', '2007-10-20', 4.50, 'enterprise-crm', 15, 2, 7, 138),
    (142, 'Build UI', '', '2016-09-18', 7.75, 'enterprise-crm', 47, 2, 8, 138),
    (143, 'Add a customer', '', '2018-07-12', 22.25, 'enterprise-crm', 17, 1, 3, null),
    (144, 'Profile tables and relationships', '', '2018-02-23', 3.00, 'enterprise-crm', 17, 2, 7, 143),
    (145, 'Lay out domain services', '', '2019-07-22', 7.00, 'enterprise-crm', 17, 2, 2, 143),
    (146, 'Lay out authentication and authorization', '', '2018-11-28', 4.75, 'enterprise-crm', 17, 2, 6, 143),
    (147, 'Prototype UI', '', '2006-02-13', 7.50, 'enterprise-crm', 15, 2, 2, 143),
    (148, 'Edit a customer', '', '2007-12-11', 22.25, 'enterprise-crm', 15, 1, 7, null),
    (149, 'Construct data components and access', '', '2003-09-26', 5.25, 'enterprise-crm', 15, 2, 5, 148),
    (150, 'Create service layer and classes', '', '2014-06-11', 4.00, 'enterprise-crm', 47, 2, null, 148),
    (151, 'Extend network APIs', '', '2000-10-04', 6.00, 'enterprise-crm', 17, 2, 2, 148),
    (152, 'Design front-end components', '', '2000-01-06', 7.00, 'enterprise-crm', 93, 2, 4, 148),
    (153, 'Delete a customer', '', '2006-12-11', 24.00, 'enterprise-crm', 93, 1, 7, null),
    (154, 'Extend data store', '', '2016-01-25', 7.75, 'enterprise-crm', 17, 2, 1, 153),
    (155, 'Profile service layer and classes', '', '2000-08-25', 6.00, 'enterprise-crm', 17, 2, 4, 153),
    (156, 'Design authentication and authorization', '', '2015-09-28', 7.75, 'enterprise-crm', 93, 2, 5, 153),
    (157, 'Model UI', '', '2019-06-08', 2.50, 'enterprise-crm', 17, 2, 4, 153),
    (158, 'Search for customers', '', '2019-02-08', 19.75, 'enterprise-crm', 17, 1, 4, null),
    (159, 'Extend database', '', '2005-08-05', 6.25, 'enterprise-crm', 17, 2, 4, 158),
    (160, 'Prototype service layer and classes', '', '2015-04-01', 3.50, 'enterprise-crm', 17, 2, 5, 158),
    (161, 'Check authentication and authorization', '', '2017-02-01', 7.50, 'enterprise-crm', 17, 2, 5, 158),
    (162, 'Build front-end components', '', '2016-03-19', 2.50, 'enterprise-crm', 15, 2, 8, 158),
    (163, 'Note a contact', '', '2002-02-16', 19.25, 'enterprise-crm', 15, 1, 2, null),
    (164, 'Profile tables and relationships', '', '2012-08-05', 5.25, 'enterprise-crm', 15, 2, 7, 163),
    (165, 'Profile domain services', '', '2007-01-04', 6.00, 'enterprise-crm', 17, 2, 7, 163),
    (166, 'Create authentication and authorization', '', '2018-03-02', 4.50, 'enterprise-crm', 93, 2, 1, 163),
    (167, 'Lay out UI', '', '2017-02-16', 3.50, 'enterprise-crm', 15, 2, 8, 163),
    (168, 'Create a follow-up', '', '2019-08-28', 15.50, 'enterprise-crm', 17, 1, 4, null),
    (169, 'Refactor data store', '', '2005-09-28', 3.00, 'enterprise-crm', 15, 2, 4, 168),
    (170, 'Lay out domain services', '', '2001-07-10', 2.50, 'enterprise-crm', 15, 2, 7, 168),
    (171, 'Profile fail-over chain', '', '2011-07-16', 2.50, 'enterprise-crm', 47, 2, 6, 168),
    (172, 'Prototype user interface', '', '2015-11-08', 7.50, 'enterprise-crm', 15, 2, 3, 168),
    (173, 'Record a sales opportunity', '', '2016-07-10', 14.75, 'enterprise-crm', 93, 1, 8, null),
    (174, 'Build schema', '', '2000-04-28', 5.25, 'enterprise-crm', 15, 2, 4, 173),
    (175, 'Extend domain rules and structure', '', '2019-01-08', 2.50, 'enterprise-crm', 17, 2, 3, 173),
    (176, 'Prototype fail-over chain', '', '2015-12-26', 3.75, 'enterprise-crm', 47, 2, 8, 173),
    (177, 'Create UI', '', '2019-11-22', 3.25, 'enterprise-crm', 47, 2, 8, 173),
    (178, 'Sales pipeline report', '', '2016-05-28', 24.75, 'enterprise-crm', 17, 1, 6, null),
    (179, 'Check tables and relationships', '', '2017-09-23', 7.75, 'enterprise-crm', 93, 2, 7, 178),
    (180, 'Add domain rules and structure', '', '2004-05-20', 3.50, 'enterprise-crm', 93, 2, 6, 178),
    (181, 'Refactor authentication and authorization', '', '2014-06-14', 7.25, 'enterprise-crm', 47, 2, 4, 178),
    (182, 'Profile UI', '', '2010-12-07', 6.25, 'enterprise-crm', 15, 2, 6, 178),
    (183, 'Create welcome animation', '', '2012-11-21', 6.50, 'game-toga', 100, 2, 1, null),
    (184, 'Build gameplay', '', '2006-10-17', 21.00, 'game-toga', 100, 1, 6, null),
    (185, 'Profile world and object engine', '', '2018-10-17', 3.25, 'game-toga', 100, 2, 3, 184),
    (186, 'Add level and scene services', '', '2015-10-23', 8.00, 'game-toga', 29, 2, 3, 184),
    (187, 'Design views', '', '2005-11-06', 5.25, 'game-toga', 100, 2, 8, 184),
    (188, 'Build viewpoint systems', '', '2004-07-05', 4.50, 'game-toga', 9, 2, 8, 184),
    (189, 'Display high scores', '', '2013-01-21', 13.75, 'game-toga', 5, 1, 5, null),
    (190, 'Build 2D game models', '', '2001-03-13', 2.25, 'game-toga', 5, 2, 6, 189),
    (191, 'Refactor middle-tier rules', '', '2002-11-24', 3.25, 'game-toga', 29, 2, 2, 189),
    (192, 'Design interface', '', '2014-03-04', 3.50, 'game-toga', 100, 2, 2, 189),
    (193, 'Extend viewpoint systems', '', '2010-10-07', 4.75, 'game-toga', 9, 2, 7, 189),
    (194, 'Prototype gameplay', '', '2008-08-05', 2.50, 'game-breakout', 96, 2, 6, null),
    (195, 'Build Level 1', '', '2009-11-14', 15.00, 'game-breakout', 36, 1, 5, null),
    (196, 'Refactor game engine', '', '2011-07-02', 3.25, 'game-breakout', 96, 2, 8, 195),
    (197, 'Refactor scene rules and structure', '', '2002-02-09', 2.75, 'game-breakout', 34, 2, 7, 195),
    (198, 'Check front-end components', '', '2001-02-16', 6.75, 'game-breakout', 30, 2, null, 195),
    (199, 'Add atmosphere & effects', '', '2003-10-11', 2.25, 'game-breakout', 66, 2, 2, 195),
    (200, 'Build Level 2', '', '2008-01-26', 23.25, 'game-breakout', 30, 1, 3, null),
    (201, 'Construct 2D game models', '', '2009-05-03', 5.25, 'game-breakout', 37, 2, 4, 200),
    (202, 'Refactor middle-tier rules', '', '2009-05-13', 7.00, 'game-breakout', 34, 2, 7, 200),
    (203, 'Build user interface', '', '2002-02-04', 5.75, 'game-breakout', 32, 2, 8, 200),
    (204, 'Lay out backgrounds and texture', '', '2016-03-24', 5.25, 'game-breakout', 96, 2, 6, 200),
    (205, 'Build Level 3', '', '2010-12-28', 21.50, 'game-breakout', 56, 1, 3, null),
    (206, 'Create physics engine', '', '2012-03-16', 7.00, 'game-breakout', 56, 2, 7, 205),
    (207, 'Model scene rules and structure', '', '2004-04-26', 4.00, 'game-breakout', 66, 2, 2, 205),
    (208, 'Design views', '', '2001-08-21', 6.50, 'game-breakout', 32, 2, 6, 205),
    (209, 'Add backgrounds and texture', '', '2011-06-18', 4.00, 'game-breakout', 66, 2, 6, 205),
    (210, 'Submit a score', '', '2006-10-25', 19.00, 'game-breakout', 30, 1, 6, null),
    (211, 'Extend game engine', '', '2017-08-06', 7.75, 'game-breakout', 32, 2, 8, 210),
    (212, 'Create scene rules and structure', '', '2012-05-06', 2.50, 'game-breakout', 30, 2, 7, 210),
    (213, 'Implement front-end components', '', '2000-10-10', 4.75, 'game-breakout', 36, 2, 7, 210),
    (214, 'Refactor backgrounds and texture', '', '2014-08-10', 4.00, 'game-breakout', 36, 2, 6, 210),
    (215, 'Create welcome animation', '', '2002-04-14', 6.25, 'game-breakout-mobile', 31, 2, 3, null),
    (216, 'Build Level 1', '', '2008-04-08', 22.25, 'game-breakout-mobile', 7, 1, 1, null),
    (217, 'Model game engine', '', '2018-02-16', 7.75, 'game-breakout-mobile', 18, 2, 1, 216),
    (218, 'Create middle-tier rules', '', '2002-09-01', 4.50, 'game-breakout-mobile', 18, 2, 6, 216),
    (219, 'Design interface', '', '2006-02-20', 4.25, 'game-breakout-mobile', 100, 2, 5, 216),
    (220, 'Create primary location', '', '2017-06-12', 5.75, 'game-breakout-mobile', 31, 2, 4, 216),
    (221, 'Build Level 2', '', '2004-04-06', 26.50, 'game-breakout-mobile', 100, 1, 5, null),
    (222, 'Model physics engine', '', '2002-04-05', 7.25, 'game-breakout-mobile', 7, 2, 8, 221),
    (223, 'Model level and scene services', '', '2009-06-09', 7.00, 'game-breakout-mobile', 57, 2, 6, 221),
    (224, 'Add front-end components', '', '2007-05-26', 8.00, 'game-breakout-mobile', 100, 2, 1, 221),
    (225, 'Create character assets', '', '2011-02-23', 4.25, 'game-breakout-mobile', 7, 2, 7, 221),
    (226, 'Build Level 3', '', '2009-01-25', 23.00, 'game-breakout-mobile', 31, 1, 6, null),
    (227, 'Create 2D game models', '', '2012-06-21', 7.25, 'game-breakout-mobile', 18, 2, 7, 226),
    (228, 'Add scene rules and structure', '', '2016-02-21', 4.50, 'game-breakout-mobile', 18, 2, 2, 226),
    (229, 'Extend views', '', '2013-10-15', 7.50, 'game-breakout-mobile', 31, 2, 2, 226),
    (230, 'Profile vehicle, clothing, and building assets', '', '2011-10-18', 3.75, 'game-breakout-mobile', 7, 2, 7, 226),
    (231, 'Play with a friend', '', '2018-01-05', 27.00, 'game-breakout-mobile', 31, 1, 3, null),
    (232, 'Create physics engine', '', '2005-10-03', 6.50, 'game-breakout-mobile', 7, 2, null, 231),
    (233, 'Add scene rules and structure', '', '2011-03-23', 7.75, 'game-breakout-mobile', 31, 2, 6, 231),
    (234, 'Profile front-end components', '', '2008-11-16', 7.00, 'game-breakout-mobile', 100, 2, 8, 231),
    (235, 'Implement backgrounds and texture', '', '2002-06-28', 5.75, 'game-breakout-mobile', 18, 2, 8, 231),
    (236, 'Implement in-app purchases', '', '2019-04-20', 15.75, 'game-breakout-mobile', 7, 1, 7, null),
    (237, 'Refactor world and object engine', '', '2009-07-22', 4.50, 'game-breakout-mobile', 18, 2, 7, 236),
    (238, 'Model scene rules and structure', '', '2017-01-12', 4.00, 'game-breakout-mobile', 100, 2, 5, 236),
    (239, 'Model interface', '', '2002-04-17', 3.50, 'game-breakout-mobile', 57, 2, 7, 236),
    (240, 'Construct primary location', '', '2002-07-18', 3.75, 'game-breakout-mobile', 18, 2, 1, 236),
    (241, 'Research generative algos', '', '2018-08-21', 7.25, 'game-sisyphus', 54, 2, 3, null),
    (242, 'Prototype on-demand scenario generation', '', '2000-11-24', 5.50, 'game-sisyphus', 72, 2, 6, null),
    (243, 'Start explore-mode', '', '2019-04-11', 24.00, 'game-sisyphus', 71, 1, 3, null),
    (244, 'Design world and object engine', '', '2013-09-25', 5.50, 'game-sisyphus', 71, 2, 2, 243),
    (245, 'Implement middle-tier rules', '', '2009-11-16', 6.50, 'game-sisyphus', 71, 2, 8, 243),
    (246, 'Prototype interface', '', '2003-06-04', 5.50, 'game-sisyphus', 54, 2, 6, 243),
    (247, 'Refactor character assets', '', '2017-02-19', 6.50, 'game-sisyphus', 71, 2, 8, 243),
    (248, 'Develop wait mode', '', '2018-10-27', 23.00, 'game-sisyphus', 72, 1, 5, null),
    (249, 'Construct world and object engine', '', '2017-03-04', 6.75, 'game-sisyphus', 71, 2, 1, 248),
    (250, 'Check scene rules and structure', '', '2014-02-07', 3.75, 'game-sisyphus', 40, 2, 6, 248),
    (251, 'Lay out views', '', '2013-04-08', 5.25, 'game-sisyphus', 72, 2, 4, 248),
    (252, 'Lay out atmosphere & effects', '', '2000-04-25', 7.25, 'game-sisyphus', 40, 2, 2, 248),
    (253, 'Should not be so easy to get yourself killed.', '', '2013-04-02', 2.50, 'game-sisyphus', 40, 3, 4, null),
    (254, 'Scenarios repeat too often.', '', '2018-01-17', 2.75, 'game-sisyphus', 40, 3, 2, null),
    (255, 'Transition between welcome and Level 1 still glitchy', '', '2013-08-09', 5.75, 'game-cooker', 63, 3, 3, null),
    (256, 'Build flat-grill burger scenario', '', '2005-11-12', 15.50, 'game-cooker', 78, 1, 4, null),
    (257, 'Construct game engine', '', '2010-09-04', 2.75, 'game-cooker', 63, 2, 1, 256),
    (258, 'Design scene rules and structure', '', '2006-06-14', 4.75, 'game-cooker', 78, 2, 7, 256),
    (259, 'Construct UI', '', '2016-12-11', 2.25, 'game-cooker', 59, 2, 8, 256),
    (260, 'Lay out character assets', '', '2015-10-25', 5.75, 'game-cooker', 22, 2, 6, 256),
    (261, 'Build sushi bar', '', '2016-10-05', 21.75, 'game-cooker', 63, 1, 8, null),
    (262, 'Lay out world and object engine', '', '2015-09-24', 3.00, 'game-cooker', 53, 2, 2, 261),
    (263, 'Lay out level and scene services', '', '2000-09-05', 6.50, 'game-cooker', 53, 2, 2, 261),
    (264, 'Construct interface', '', '2005-03-03', 5.75, 'game-cooker', 53, 2, 5, 261),
    (265, 'Model backgrounds and texture', '', '2007-04-12', 6.50, 'game-cooker', 74, 2, 3, 261),
    (266, 'Build build-your-own pasta scenario', '', '2008-06-23', 20.50, 'game-cooker', 97, 1, 4, null),
    (267, 'Create world and object engine', '', '2000-05-05', 6.25, 'game-cooker', 53, 2, 4, 266),
    (268, 'Design scene rules and structure', '', '2019-07-25', 5.25, 'game-cooker', 59, 2, 7, 266),
    (269, 'Build interface', '', '2015-04-05', 2.25, 'game-cooker', 22, 2, 3, 266),
    (270, 'Check backgrounds and texture', '', '2007-12-12', 6.75, 'game-cooker', 74, 2, 3, 266),
    (271, 'Build tapas!', '', '2019-04-19', 19.75, 'game-cooker', 59, 1, 7, null),
    (272, 'Lay out world and object engine', '', '2018-04-26', 5.75, 'game-cooker', 97, 2, 6, 271),
    (273, 'Construct level and scene services', '', '2002-08-12', 7.25, 'game-cooker', 28, 2, 8, 271),
    (274, 'Implement front-end components', '', '2006-10-08', 2.50, 'game-cooker', 22, 2, 8, 271),
    (275, 'Add vehicle, clothing, and building assets', '', '2006-04-24', 4.25, 'game-cooker', 22, 2, null, 271),
    (276, 'Create welcome animation', '', '2009-01-07', 5.50, 'game-cheese', 62, 2, 2, null),
    (277, 'Build Level 1', '', '2003-11-18', 20.00, 'game-cheese', 60, 1, 2, null),
    (278, 'Implement world and object engine', '', '2006-02-24', 5.00, 'game-cheese', 25, 2, 7, 277),
    (279, 'Profile scene rules and structure', '', '2013-03-01', 7.00, 'game-cheese', 25, 2, 2, 277),
    (280, 'Design interface', '', '2005-10-09', 5.75, 'game-cheese', 94, 2, 7, 277),
    (281, 'Create primary location', '', '2017-10-15', 2.25, 'game-cheese', 60, 2, 8, 277),
    (282, 'Build Level 2', '', '2009-03-01', 26.75, 'game-cheese', 25, 1, 7, null),
    (283, 'Prototype physics engine', '', '2018-05-14', 7.75, 'game-cheese', 25, 2, 6, 282),
    (284, 'Lay out scene rules and structure', '', '2000-03-24', 7.50, 'game-cheese', 62, 2, 1, 282),
    (285, 'Model interface', '', '2016-01-27', 8.00, 'game-cheese', 94, 2, 4, 282),
    (286, 'Create backgrounds and texture', '', '2012-08-17', 3.50, 'game-cheese', 62, 2, 4, 282),
    (287, 'Build Level 3', '', '2012-05-25', 23.75, 'game-cheese', 62, 1, 1, null),
    (288, 'Implement 2D game models', '', '2002-06-10', 8.00, 'game-cheese', 62, 2, 1, 287),
    (289, 'Model level and scene services', '', '2004-01-26', 5.75, 'game-cheese', 60, 2, 3, 287),
    (290, 'Add user interface', '', '2001-11-23', 5.50, 'game-cheese', 25, 2, 7, 287),
    (291, 'Build viewpoint systems', '', '2017-09-02', 4.50, 'game-cheese', 60, 2, 7, 287),
    (292, 'Build Nebraska - easy', '', '2014-10-09', 11.50, 'game-stormchaser', 59, 1, 6, null),
    (293, 'Extend 2D game models', '', '2018-10-28', 3.00, 'game-stormchaser', 68, 2, 8, 292),
    (294, 'Check scene rules and structure', '', '2011-02-28', 3.50, 'game-stormchaser', 28, 2, 1, 292),
    (295, 'Implement UI', '', '2018-05-06', 2.25, 'game-stormchaser', 85, 2, 4, 292),
    (296, 'Design backgrounds and texture', '', '2013-06-13', 2.75, 'game-stormchaser', 85, 2, 8, 292),
    (297, 'Build Florida - intermediate', '', '2002-10-22', 23.75, 'game-stormchaser', 23, 1, 2, null),
    (298, 'Check 2D game models', '', '2006-06-15', 5.00, 'game-stormchaser', 28, 2, 3, 297),
    (299, 'Construct scene rules and structure', '', '2012-08-01', 5.25, 'game-stormchaser', 23, 2, 3, 297),
    (300, 'Extend front-end components', '', '2011-01-16', 7.75, 'game-stormchaser', 85, 2, 8, 297),
    (301, 'Model vehicle, clothing, and building assets', '', '2014-06-22', 5.75, 'game-stormchaser', 23, 2, 1, 297),
    (302, 'Build Kansas scenario - hard', '', '2004-10-22', 20.75, 'game-stormchaser', 16, 1, 8, null),
    (303, 'Profile world and object engine', '', '2016-11-24', 4.50, 'game-stormchaser', 85, 2, 5, 302),
    (304, 'Model level and scene services', '', '2016-01-24', 4.25, 'game-stormchaser', 68, 2, 1, 302),
    (305, 'Model user interface', '', '2007-07-16', 6.50, 'game-stormchaser', 28, 2, 8, 302),
    (306, 'Construct viewpoint systems', '', '2009-08-22', 5.50, 'game-stormchaser', 85, 2, 3, 302),
    (307, 'Loses network connection after SuperGale', '', '2019-10-21', 7.00, 'game-stormchaser', 68, 3, 4, null),
    (308, 'Transfer Sarah''s pencil sketches', '', '2018-03-14', 6.75, 'game-patience', 42, 2, 2, null),
    (309, 'Prototype eye tracking', '', '2007-04-18', 2.25, 'game-patience', 90, 2, 7, null),
    (310, 'Create starter mode', '', '2000-01-14', 17.00, 'game-patience', 90, 1, 2, null),
    (311, 'Prototype world and object engine', '', '2007-11-16', 4.50, 'game-patience', 74, 2, 5, 310),
    (312, 'Profile middle-tier rules', '', '2016-01-07', 2.25, 'game-patience', 1, 2, 1, 310),
    (313, 'Prototype user interface', '', '2015-05-27', 7.50, 'game-patience', 90, 2, 8, 310),
    (314, 'Refactor vehicle, clothing, and building assets', '', '2004-04-28', 2.75, 'game-patience', 74, 2, 6, 310),
    (315, 'Create "be still" mode', '', '2005-01-26', 16.75, 'game-patience', 42, 1, 1, null),
    (316, 'Profile game engine', '', '2002-06-03', 3.50, 'game-patience', 1, 2, 1, 315),
    (317, 'Prototype middle-tier rules', '', '2004-06-18', 5.50, 'game-patience', 42, 2, 5, 315),
    (318, 'Add front-end components', '', '2014-10-14', 2.50, 'game-patience', 90, 2, 1, 315),
    (319, 'Extend backgrounds and texture', '', '2003-09-18', 5.25, 'game-patience', 74, 2, 6, 315),
    (320, 'Cedar Rapids Scenario', '', '2002-09-14', 24.75, 'game-horror', 72, 1, 7, null),
    (321, 'Create physics engine', '', '2009-05-23', 6.75, 'game-horror', 72, 2, 6, 320),
    (322, 'Prototype middle-tier rules', '', '2010-01-20', 5.00, 'game-horror', 70, 2, 3, 320),
    (323, 'Design front-end components', '', '2001-02-01', 6.50, 'game-horror', 92, 2, 3, 320),
    (324, 'Prototype primary location', '', '2007-03-04', 6.50, 'game-horror', 72, 2, 6, 320),
    (325, 'Sioux Falls Scenario', '', '2007-08-12', 19.00, 'game-horror', 12, 1, 8, null),
    (326, 'Add 2D game models', '', '2005-02-03', 3.75, 'game-horror', 95, 2, 6, 325),
    (327, 'Add scene rules and structure', '', '2011-03-16', 7.75, 'game-horror', 72, 2, 1, 325),
    (328, 'Add user interface', '', '2006-12-14', 5.25, 'game-horror', 72, 2, 4, 325),
    (329, 'Lay out viewpoint systems', '', '2013-05-02', 2.25, 'game-horror', 89, 2, 5, 325),
    (330, 'Developer Mason City interlude and mini-game', '', '2011-11-02', 18.75, 'game-horror', 89, 1, 6, null),
    (331, 'Build game engine', '', '2007-11-02', 7.50, 'game-horror', 70, 2, 2, 330),
    (332, 'Design level and scene services', '', '2014-03-05', 4.25, 'game-horror', 99, 2, 8, 330),
    (333, 'Profile UI', '', '2003-05-28', 4.75, 'game-horror', 70, 2, 6, 330),
    (334, 'Construct character assets', '', '2018-05-16', 2.25, 'game-horror', 95, 2, 3, 330),
    (335, 'Des Moines Scenario', '', '2013-01-16', 18.50, 'game-horror', 11, 1, 7, null),
    (336, 'Lay out physics engine', '', '2008-04-19', 4.75, 'game-horror', 72, 2, 7, 335),
    (337, 'Extend scene rules and structure', '', '2004-04-09', 2.75, 'game-horror', 12, 2, 2, 335),
    (338, 'Extend user interface', '', '2001-09-09', 4.25, 'game-horror', 89, 2, 4, 335),
    (339, 'Profile character assets', '', '2014-10-12', 6.75, 'game-horror', 92, 2, 3, 335),
    (340, 'Create welcome animation', '', '2012-07-09', 3.00, 'game-horror', 70, 2, 5, null),
    (341, 'Run motion capture at the Humane Society', '', '2012-07-23', 5.50, 'game-goodboy', 69, 2, 3, null),
    (342, 'Build Level 1', '', '2005-01-01', 22.25, 'game-goodboy', 29, 1, 4, null),
    (343, 'Model 2D game models', '', '2001-05-04', 5.25, 'game-goodboy', 82, 2, 2, 342),
    (344, 'Extend scene rules and structure', '', '2004-06-04', 7.00, 'game-goodboy', 57, 2, 6, 342),
    (345, 'Lay out views', '', '2000-11-13', 2.50, 'game-goodboy', 82, 2, 3, 342),
    (346, 'Prototype backgrounds and texture', '', '2015-09-04', 7.50, 'game-goodboy', 82, 2, 3, 342),
    (347, 'Build Level 2', '', '2004-08-03', 22.25, 'game-goodboy', 82, 1, 4, null),
    (348, 'Create world and object engine', '', '2015-05-23', 5.50, 'game-goodboy', 15, 2, 5, 347),
    (349, 'Model scene rules and structure', '', '2019-04-01', 7.25, 'game-goodboy', 15, 2, 2, 347),
    (350, 'Model UI', '', '2000-11-08', 5.25, 'game-goodboy', 29, 2, 4, 347),
    (351, 'Implement atmosphere & effects', '', '2018-02-09', 4.25, 'game-goodboy', 58, 2, 6, 347),
    (352, 'Build Level 3', '', '2010-09-22', 19.50, 'game-goodboy', 57, 1, 8, null),
    (353, 'Lay out game engine', '', '2006-09-23', 4.75, 'game-goodboy', 57, 2, 1, 352),
    (354, 'Lay out level and scene services', '', '2013-12-06', 4.50, 'game-goodboy', 57, 2, 3, 352),
    (355, 'Add front-end components', '', '2013-03-03', 7.00, 'game-goodboy', 29, 2, 6, 352),
    (356, 'Implement character assets', '', '2006-02-01', 3.25, 'game-goodboy', 69, 2, null, 352),
    (357, 'Create dog donation mechanism', '', '2002-08-03', 22.25, 'game-goodboy', 29, 1, 2, null),
    (358, 'Design game engine', '', '2004-10-18', 5.00, 'game-goodboy', 47, 2, 8, 357),
    (359, 'Prototype middle-tier rules', '', '2004-06-17', 4.00, 'game-goodboy', 58, 2, 5, 357),
    (360, 'Prototype front-end components', '', '2010-04-14', 7.50, 'game-goodboy', 15, 2, 1, 357),
    (361, 'Prototype viewpoint systems', '', '2005-05-03', 5.75, 'game-goodboy', 69, 2, 3, 357),
    (362, 'Provide concept art', '', '2016-01-25', 4.25, 'game-midge', 7, 2, 2, null),
    (363, 'Build: Midge in New Orleans', '', '2009-11-12', 19.00, 'game-midge', 1, 1, 8, null),
    (364, 'Profile physics engine', '', '2009-11-01', 7.75, 'game-midge', 61, 2, 6, 363),
    (365, 'Lay out middle-tier rules', '', '2000-08-11', 5.75, 'game-midge', 74, 2, 2, 363),
    (366, 'Prototype user interface', '', '2010-09-26', 2.50, 'game-midge', 74, 2, 6, 363),
    (367, 'Check primary location', '', '2019-09-16', 3.00, 'game-midge', 74, 2, 4, 363),
    (368, 'Build: Midge in New York', '', '2018-11-14', 21.25, 'game-midge', 83, 1, 1, null),
    (369, 'Add physics engine', '', '2009-10-03', 4.00, 'game-midge', 7, 2, 8, 368),
    (370, 'Build level and scene services', '', '2009-06-12', 6.75, 'game-midge', 74, 2, 3, 368),
    (371, 'Create views', '', '2000-01-25', 4.00, 'game-midge', 61, 2, 3, 368),
    (372, 'Refactor viewpoint systems', '', '2012-04-24', 6.50, 'game-midge', 74, 2, 5, 368),
    (373, 'Build: Midge in Paris', '', '2003-06-19', 18.25, 'game-midge', 1, 1, 6, null),
    (374, 'Prototype game engine', '', '2010-08-23', 5.50, 'game-midge', 87, 2, 1, 373),
    (375, 'Design middle-tier rules', '', '2016-03-22', 7.25, 'game-midge', 61, 2, 7, 373),
    (376, 'Prototype views', '', '2001-06-17', 2.75, 'game-midge', 50, 2, 8, 373),
    (377, 'Extend viewpoint systems', '', '2006-06-17', 2.75, 'game-midge', 83, 2, 8, 373),
    (378, 'Develop Midge-is-dreaming sequence and healing/level-up', '', '2018-01-18', 22.50, 'game-midge', 1, 1, 5, null),
    (379, 'Build 2D game models', '', '2015-01-06', 6.75, 'game-midge', 61, 2, 8, 378),
    (380, 'Check level and scene services', '', '2006-06-10', 4.25, 'game-midge', 74, 2, 8, 378),
    (381, 'Model interface', '', '2016-12-28', 7.25, 'game-midge', 89, 2, 1, 378),
    (382, 'Construct character assets', '', '2013-02-02', 4.25, 'game-midge', 97, 2, 4, 378),
    (383, 'Create welcome animation', '', '2010-09-09', 5.25, 'game-diva', 34, 2, 5, null),
    (384, 'Prototype gesture tracking', '', '2014-03-26', 6.25, 'game-diva', 34, 2, 4, null),
    (385, 'Build Level 1', '', '2003-02-07', 23.75, 'game-diva', 23, 1, 6, null),
    (386, 'Add game engine', '', '2013-06-10', 7.25, 'game-diva', 13, 2, 6, 385),
    (387, 'Design scene rules and structure', '', '2002-08-16', 3.00, 'game-diva', 37, 2, 5, 385),
    (388, 'Construct interface', '', '2010-08-24', 7.50, 'game-diva', 23, 2, 6, 385),
    (389, 'Prototype vehicle, clothing, and building assets', '', '2007-04-03', 6.00, 'game-diva', 34, 2, 7, 385),
    (390, 'Build Level 2', '', '2012-04-11', 25.00, 'game-diva', 69, 1, 8, null),
    (391, 'Prototype 2D game models', '', '2018-05-23', 6.75, 'game-diva', 23, 2, 7, 390),
    (392, 'Lay out middle-tier rules', '', '2014-01-03', 3.25, 'game-diva', 23, 2, 2, 390),
    (393, 'Check views', '', '2012-09-14', 7.00, 'game-diva', 16, 2, 7, 390),
    (394, 'Design atmosphere & effects', '', '2005-08-03', 8.00, 'game-diva', 23, 2, 2, 390),
    (395, 'Build Level 3', '', '2003-01-06', 17.00, 'game-diva', 75, 1, 4, null),
    (396, 'Profile game engine', '', '2004-02-26', 4.50, 'game-diva', 34, 2, 6, 395),
    (397, 'Prototype scene rules and structure', '', '2014-07-11', 3.00, 'game-diva', 75, 2, 8, 395),
    (398, 'Construct UI', '', '2019-05-14', 3.25, 'game-diva', 69, 2, 5, 395),
    (399, 'Model viewpoint systems', '', '2003-08-17', 6.25, 'game-diva', 69, 2, 3, 395),
    (400, 'Build Level 4', '', '2015-06-18', 20.00, 'game-diva', 37, 1, 7, null),
    (401, 'Add physics engine', '', '2004-11-18', 3.75, 'game-diva', 16, 2, 3, 400),
    (402, 'Construct level and scene services', '', '2014-10-25', 5.25, 'game-diva', 69, 2, 3, 400),
    (403, 'Add views', '', '2017-10-25', 7.75, 'game-diva', 16, 2, 4, 400),
    (404, 'Add primary location', '', '2018-11-04', 3.25, 'game-diva', 75, 2, 8, 400),
    (405, 'Implement Musitano Fund', '', '2013-01-06', 25.00, 'game-mafia', 36, 1, 4, null),
    (406, 'Create 2D game models', '', '2003-01-06', 7.25, 'game-mafia', 23, 2, 4, 405),
    (407, 'Implement scene rules and structure', '', '2009-06-04', 7.75, 'game-mafia', 88, 2, 5, 405),
    (408, 'Design UI', '', '2008-01-07', 5.50, 'game-mafia', 23, 2, 4, 405),
    (409, 'Add character assets', '', '2000-05-26', 4.50, 'game-mafia', 57, 2, 4, 405),
    (410, 'Implement Papalina Fund', '', '2002-11-08', 19.75, 'game-mafia', 88, 1, 5, null),
    (411, 'Add 2D game models', '', '2003-04-11', 5.50, 'game-mafia', 36, 2, 2, 410),
    (412, 'Lay out level and scene services', '', '2017-07-17', 5.00, 'game-mafia', 36, 2, 7, 410),
    (413, 'Check user interface', '', '2010-06-05', 5.50, 'game-mafia', 36, 2, 7, 410),
    (414, 'Lay out viewpoint systems', '', '2006-07-07', 3.75, 'game-mafia', 88, 2, 5, 410),
    (415, 'Implement Luppino Fund', '', '2008-10-02', 18.25, 'game-mafia', 88, 1, 2, null),
    (416, 'Lay out world and object engine', '', '2016-03-27', 5.50, 'game-mafia', 57, 2, 4, 415),
    (417, 'Build level and scene services', '', '2011-07-03', 2.75, 'game-mafia', 36, 2, 1, 415),
    (418, 'Prototype views', '', '2017-04-13', 7.00, 'game-mafia', 88, 2, 3, 415),
    (419, 'Lay out vehicle, clothing, and building assets', '', '2019-12-02', 3.00, 'game-mafia', 94, 2, 1, 415),
    (420, 'Implement Balistrieri Fund', '', '2019-02-04', 15.50, 'game-mafia', 23, 1, 3, null),
    (421, 'Create 2D game models', '', '2015-11-06', 4.75, 'game-mafia', 88, 2, 4, 420),
    (422, 'Design scene rules and structure', '', '2002-04-11', 3.75, 'game-mafia', 23, 2, 1, 420),
    (423, 'Refactor interface', '', '2006-07-12', 3.50, 'game-mafia', 88, 2, 5, 420),
    (424, 'Model viewpoint systems', '', '2008-06-08', 3.50, 'game-mafia', 94, 2, 4, 420),
    (425, '"Parley" feature is still weird.', '', '2010-06-17', 5.50, 'game-mafia', 94, 3, 1, null),
    (426, 'Cotroni family is too powerful. Makes for unbalanced gameplay.', '', '2018-01-06', 6.25, 'game-mafia', 88, 3, 4, null),
    (427, 'Build: Midge in Las Vegas', '', '2005-07-27', 15.25, 'game-midge2', 91, 1, 6, null),
    (428, 'Create world and object engine', '', '2007-06-07', 3.50, 'game-midge2', 58, 2, 8, 427),
    (429, 'Profile level and scene services', '', '2007-02-11', 3.50, 'game-midge2', 93, 2, 4, 427),
    (430, 'Profile interface', '', '2013-03-07', 3.75, 'game-midge2', 97, 2, 1, 427),
    (431, 'Construct backgrounds and texture', '', '2002-07-14', 4.50, 'game-midge2', 93, 2, 5, 427),
    (432, 'Build: Midge in Macua', '', '2012-08-08', 22.00, 'game-midge2', 58, 1, 2, null),
    (433, 'Add world and object engine', '', '2015-11-26', 2.50, 'game-midge2', 58, 2, 3, 432),
    (434, 'Design middle-tier rules', '', '2019-03-10', 8.00, 'game-midge2', 91, 2, 4, 432),
    (435, 'Implement user interface', '', '2002-09-06', 6.50, 'game-midge2', 65, 2, 1, 432),
    (436, 'Refactor backgrounds and texture', '', '2004-10-09', 5.00, 'game-midge2', 58, 2, 2, 432),
    (437, 'Build: Midge in Atlantic City', '', '2009-12-14', 20.50, 'game-midge2', 58, 1, 8, null),
    (438, 'Refactor world and object engine', '', '2019-03-03', 5.25, 'game-midge2', 65, 2, 3, 437),
    (439, 'Extend scene rules and structure', '', '2006-12-08', 3.50, 'game-midge2', 93, 2, 8, 437),
    (440, 'Extend views', '', '2015-10-21', 4.00, 'game-midge2', 65, 2, 6, 437),
    (441, 'Prototype viewpoint systems', '', '2015-04-27', 7.75, 'game-midge2', 65, 2, 2, 437),
    (442, 'Develop "The Aristocrats"', '', '2014-12-24', 22.75, 'game-postmodern', 63, 1, 7, null),
    (443, 'Prototype game engine', '', '2010-03-25', 6.75, 'game-postmodern', 77, 2, 3, 442),
    (444, 'Create middle-tier rules', '', '2015-06-26', 4.50, 'game-postmodern', 74, 2, 6, 442),
    (445, 'Implement interface', '', '2011-10-03', 6.75, 'game-postmodern', 63, 2, 2, 442),
    (446, 'Design vehicle, clothing, and building assets', '', '2002-01-04', 4.75, 'game-postmodern', 10, 2, 3, 442),
    (447, 'Develop "Punk ''n Love"', '', '2011-08-21', 18.50, 'game-postmodern', 74, 1, 1, null),
    (448, 'Lay out 2D game models', '', '2010-04-06', 7.25, 'game-postmodern', 10, 2, 4, 447),
    (449, 'Design middle-tier rules', '', '2000-11-02', 4.25, 'game-postmodern', 63, 2, 2, 447),
    (450, 'Profile front-end components', '', '2013-07-03', 4.00, 'game-postmodern', 60, 2, 1, 447),
    (451, 'Profile viewpoint systems', '', '2007-07-14', 3.00, 'game-postmodern', 77, 2, 8, 447),
    (452, 'Develop "Did smart phones kill letter writing?"', '', '2012-08-25', 23.75, 'game-postmodern', 74, 1, 5, null),
    (453, 'Build 2D game models', '', '2005-10-10', 4.25, 'game-postmodern', 74, 2, 5, 452),
    (454, 'Check scene rules and structure', '', '2014-02-23', 7.75, 'game-postmodern', 10, 2, 4, 452),
    (455, 'Extend user interface', '', '2012-02-21', 7.50, 'game-postmodern', 63, 2, 1, 452),
    (456, 'Lay out viewpoint systems', '', '2005-03-05', 4.25, 'game-postmodern', 10, 2, 8, 452),
    (457, 'Build Level 1', '', '2006-08-07', 17.25, 'game-bike', 82, 1, 3, null),
    (458, 'Design 2D game models', '', '2010-11-23', 3.50, 'game-bike', 98, 2, 6, 457),
    (459, 'Check middle-tier rules', '', '2004-04-24', 2.50, 'game-bike', 94, 2, 4, 457),
    (460, 'Add UI', '', '2014-02-08', 5.00, 'game-bike', 42, 2, 5, 457),
    (461, 'Profile viewpoint systems', '', '2008-03-06', 6.25, 'game-bike', 82, 2, 7, 457),
    (462, 'Build Level 2', '', '2014-02-14', 19.75, 'game-bike', 92, 1, 3, null),
    (463, 'Build physics engine', '', '2007-08-27', 6.25, 'game-bike', 16, 2, 1, 462),
    (464, 'Refactor level and scene services', '', '2001-12-28', 2.50, 'game-bike', 11, 2, 1, 462),
    (465, 'Check UI', '', '2011-10-03', 6.50, 'game-bike', 98, 2, 2, 462),
    (466, 'Design character assets', '', '2005-12-17', 4.50, 'game-bike', 98, 2, 4, 462),
    (467, 'Build Level 1', '', '2018-09-10', 22.00, 'game-grumps', 56, 1, 6, null),
    (468, 'Lay out world and object engine', '', '2011-09-23', 8.00, 'game-grumps', 99, 2, 3, 467),
    (469, 'Prototype middle-tier rules', '', '2004-02-17', 6.75, 'game-grumps', 99, 2, 3, 467),
    (470, 'Design user interface', '', '2005-07-04', 4.50, 'game-grumps', 9, 2, 3, 467),
    (471, 'Prototype atmosphere & effects', '', '2005-12-26', 2.75, 'game-grumps', 9, 2, 4, 467),
    (472, 'Build Level 2', '', '2012-04-11', 20.25, 'game-grumps', 56, 1, 1, null),
    (473, 'Design game engine', '', '2002-06-18', 6.00, 'game-grumps', 52, 2, 8, 472),
    (474, 'Build level and scene services', '', '2016-01-07', 6.00, 'game-grumps', 67, 2, 5, 472),
    (475, 'Profile UI', '', '2016-12-14', 5.50, 'game-grumps', 9, 2, 3, 472),
    (476, 'Model viewpoint systems', '', '2015-10-17', 2.75, 'game-grumps', 56, 2, 5, 472),
    (477, 'Build Level 3', '', '2001-06-28', 25.25, 'game-grumps', 9, 1, 5, null),
    (478, 'Extend physics engine', '', '2007-04-11', 7.75, 'game-grumps', 9, 2, 6, 477),
    (479, 'Create middle-tier rules', '', '2001-04-15', 6.75, 'game-grumps', 99, 2, 1, 477),
    (480, 'Add user interface', '', '2000-01-15', 4.75, 'game-grumps', 56, 2, 4, 477),
    (481, 'Create vehicle, clothing, and building assets', '', '2009-07-09', 6.00, 'game-grumps', 80, 2, 1, 477),
    (482, 'Build Level 4', '', '2017-03-16', 16.00, 'game-grumps', 56, 1, 4, null),
    (483, 'Lay out world and object engine', '', '2005-03-22', 3.50, 'game-grumps', 56, 2, 6, 482),
    (484, 'Add level and scene services', '', '2013-08-06', 5.75, 'game-grumps', 99, 2, 6, 482),
    (485, 'Build UI', '', '2010-12-06', 4.00, 'game-grumps', 99, 2, 3, 482),
    (486, 'Extend vehicle, clothing, and building assets', '', '2002-10-12', 2.75, 'game-grumps', 99, 2, 1, 482),
    (487, 'Implement 1v1', '', '2005-01-07', 21.50, 'game-churlish', 67, 1, 5, null),
    (488, 'Refactor world and object engine', '', '2011-02-03', 7.25, 'game-churlish', 23, 2, 4, 487),
    (489, 'Lay out middle-tier rules', '', '2002-06-28', 6.50, 'game-churlish', 23, 2, 3, 487),
    (490, 'Extend views', '', '2017-01-17', 5.00, 'game-churlish', 4, 2, 5, 487),
    (491, 'Refactor backgrounds and texture', '', '2000-09-13', 2.75, 'game-churlish', 13, 2, 4, 487),
    (492, 'Implement 2v2', '', '2011-02-01', 17.00, 'game-churlish', 39, 1, 7, null),
    (493, 'Implement world and object engine', '', '2007-05-07', 6.25, 'game-churlish', 79, 2, 1, 492),
    (494, 'Implement scene rules and structure', '', '2012-09-09', 3.25, 'game-churlish', 66, 2, 4, 492),
    (495, 'Check front-end components', '', '2012-04-07', 2.50, 'game-churlish', 23, 2, 1, 492),
    (496, 'Prototype atmosphere & effects', '', '2014-09-03', 5.00, 'game-churlish', 4, 2, 5, 492),
    (497, 'Implement Melee Royale', '', '2014-08-11', 22.00, 'game-churlish', 35, 1, 8, null),
    (498, 'Build world and object engine', '', '2004-06-02', 4.00, 'game-churlish', 13, 2, 6, 497),
    (499, 'Extend level and scene services', '', '2006-12-22', 7.00, 'game-churlish', 4, 2, 5, 497),
    (500, 'Prototype user interface', '', '2004-08-11', 7.25, 'game-churlish', 4, 2, 8, 497),
    (501, 'Extend character assets', '', '2017-11-17', 3.75, 'game-churlish', 13, 2, 2, 497),
    (502, 'Complete local Scout Troup', '', '2010-05-15', 19.00, 'game-economy', 3, 1, 6, null),
    (503, 'Build 2D game models', '', '2018-09-10', 4.25, 'game-economy', 34, 2, 3, 502),
    (504, 'Construct level and scene services', '', '2004-05-04', 4.00, 'game-economy', 24, 2, 5, 502),
    (505, 'Profile interface', '', '2006-08-20', 5.00, 'game-economy', 15, 2, 8, 502),
    (506, 'Profile vehicle, clothing, and building assets', '', '2015-01-11', 5.75, 'game-economy', 5, 2, 6, 502),
    (507, 'Complete neighborhood Co-op', '', '2011-01-18', 22.25, 'game-economy', 84, 1, 8, null),
    (508, 'Prototype world and object engine', '', '2001-06-05', 6.00, 'game-economy', 5, 2, 7, 507),
    (509, 'Check level and scene services', '', '2003-12-06', 7.00, 'game-economy', 15, 2, 1, 507),
    (510, 'Lay out UI', '', '2018-09-11', 5.50, 'game-economy', 3, 2, 4, 507),
    (511, 'Create primary location', '', '2017-08-24', 3.75, 'game-economy', 3, 2, 6, 507),
    (512, 'Complete City Mode', '', '2019-04-27', 21.75, 'game-economy', 5, 1, 6, null),
    (513, 'Extend physics engine', '', '2003-06-27', 6.00, 'game-economy', 34, 2, 8, 512),
    (514, 'Lay out scene rules and structure', '', '2009-08-03', 6.25, 'game-economy', 5, 2, 1, 512),
    (515, 'Model views', '', '2011-09-09', 2.25, 'game-economy', 24, 2, 7, 512),
    (516, 'Prototype primary location', '', '2006-04-23', 7.25, 'game-economy', 84, 2, 7, 512),
    (517, 'Complete State Mode', '', '2016-12-16', 16.75, 'game-economy', 15, 1, 7, null),
    (518, 'Profile world and object engine', '', '2012-07-28', 3.50, 'game-economy', 34, 2, 1, 517),
    (519, 'Prototype scene rules and structure', '', '2010-09-12', 5.25, 'game-economy', 5, 2, 2, 517),
    (520, 'Extend front-end components', '', '2004-07-22', 4.75, 'game-economy', 24, 2, 6, 517),
    (521, 'Build character assets', '', '2019-04-22', 3.25, 'game-economy', 49, 2, 2, 517),
    (522, 'Complete Country-wide Empire', '', '2016-03-17', 17.00, 'game-economy', 5, 1, 8, null),
    (523, 'Profile 2D game models', '', '2011-04-15', 4.00, 'game-economy', 3, 2, 4, 522),
    (524, 'Check middle-tier rules', '', '2015-04-27', 2.25, 'game-economy', 24, 2, 2, 522),
    (525, 'Create views', '', '2003-07-24', 5.00, 'game-economy', 5, 2, 3, 522),
    (526, 'Create atmosphere & effects', '', '2016-09-02', 5.75, 'game-economy', 34, 2, 8, 522),
    (527, 'Complete Global Domination', '', '2010-09-18', 10.50, 'game-economy', 3, 1, 3, null),
    (528, 'Construct physics engine', '', '2005-03-14', 2.75, 'game-economy', 3, 2, 7, 527),
    (529, 'Refactor middle-tier rules', '', '2010-09-06', 2.50, 'game-economy', 5, 2, 2, 527),
    (530, 'Model front-end components', '', '2007-07-05', 3.00, 'game-economy', 5, 2, null, 527),
    (531, 'Extend atmosphere & effects', '', '2010-08-18', 2.25, 'game-economy', 15, 2, 2, 527),
    (532, 'Build: Midge does yoga', '', '2002-11-01', 26.50, 'game-midge3', 94, 1, 3, null),
    (533, 'Refactor physics engine', '', '2013-04-02', 5.00, 'game-midge3', 94, 2, 7, 532),
    (534, 'Extend level and scene services', '', '2018-01-18', 6.25, 'game-midge3', 88, 2, 6, 532),
    (535, 'Construct interface', '', '2016-11-05', 7.25, 'game-midge3', 96, 2, 4, 532),
    (536, 'Check primary location', '', '2009-07-17', 8.00, 'game-midge3', 8, 2, 8, 532),
    (537, 'Build: Midge makes fresh pasta', '', '2009-05-14', 16.75, 'game-midge3', 96, 1, 6, null),
    (538, 'Refactor game engine', '', '2002-05-14', 3.00, 'game-midge3', 94, 2, 8, 537),
    (539, 'Prototype level and scene services', '', '2011-02-02', 7.75, 'game-midge3', 88, 2, 6, 537),
    (540, 'Create views', '', '2014-08-24', 2.50, 'game-midge3', 88, 2, 4, 537),
    (541, 'Implement primary location', '', '2005-05-05', 3.50, 'game-midge3', 96, 2, 8, 537),
    (542, 'Research Occulus API', '', '2014-09-02', 5.25, 'game-midge3', 88, 2, 8, null),
    (543, 'Research MS AR', '', '2002-12-12', 4.25, 'game-midge3', 96, 2, 1, null);
    
-- START CODE ALONG --    
USE TrackIt;

SELECT *
FROM TaskStatus
WHERE IsResolved = 1;

-- TaskStatusIds are in order, so we can use BETWEEN.
-- If they were out of sequence, we might use an IN (id1, id2, idN).
SELECT *
FROM Task
WHERE TaskStatusId BETWEEN 5 AND 8;

SELECT 
    Task.TaskId,
    Task.Title,
    TaskStatus.Name AS StatusName
FROM TaskStatus
INNER JOIN Task ON TaskStatus.TaskStatusId = Task.TaskStatusId
WHERE TaskStatus.IsResolved = 1;

SELECT 					-- also write this query using WHERE instead of JOIN. same table as the one on top ^^
    Task.TaskId,
    Task.Title,
    TaskStatus.Name
FROM TaskStatus, Task
WHERE TaskStatus.TaskStatusId = Task.TaskStatusId
AND TaskStatus.IsResolved = 1;

-- Compare this (no table names):
SELECT 
    TaskId,
    Title,
    `Name`
FROM TaskStatus
INNER JOIN Task ON TaskStatus.TaskStatusId = Task.TaskStatusId
WHERE TaskStatus.IsResolved = 1;
-- to this (includes table names).
SELECT 
    Task.TaskId,
    Task.Title,
    TaskStatus.Name
FROM TaskStatus
INNER JOIN Task ON TaskStatus.TaskStatusId = Task.TaskStatusId
WHERE TaskStatus.IsResolved = 1;

SELECT 
    TaskId,
    Title,
    `Name`
    -- TaskStatusId -- This will cause problems. --UNCOMMENT TO CHECK ERROR AND ADD COMMA ON 'name'
FROM TaskStatus  -- Error Code: 1052. Column 'TaskStatusId' in field list is ambiguous
INNER JOIN Task ON TaskStatus.TaskStatusId = Task.TaskStatusId
WHERE TaskStatus.IsResolved = 1;

SELECT 
    Task.TaskId,
    Task.Title,
    TaskStatus.Name
FROM TaskStatus
JOIN Task ON TaskStatus.TaskStatusId = Task.TaskStatusId -- INNER omitted, still works but DON'T do it.
WHERE TaskStatus.IsResolved = 1;

SELECT
    Project.Name,
    Worker.FirstName,
    Worker.LastName
FROM Project
INNER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
INNER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
WHERE Project.ProjectId = 'game-goodboy';

SELECT  -- Using WHERE to Join; same result as above ^^ 
 Project.Name,
 Worker.FirstName,
 Worker.LastName
FROM Project, ProjectWorker, Worker
WHERE Project.ProjectId = ProjectWorker.ProjectId
AND ProjectWorker.WorkerId = Worker.WorkerId
AND Project.ProjectId = 'game-goodboy';

SELECT
    Project.Name,
    Worker.FirstName,
    Worker.LastName,
    Task.Title
FROM Project
INNER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
INNER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
INNER JOIN Task ON ProjectWorker.ProjectId = Task.ProjectId
    AND ProjectWorker.WorkerId = Task.WorkerId
WHERE Project.ProjectId = 'game-goodboy';

-- To be successful with JOIN queries, you must first map out tables and conditions for the ON statements.
-- A few minutes of research will save countless minutes of debugging.

-- OUTER JOIN 
SELECT * FROM Task; -- The query returns 543 rows.

SELECT * -- but the query only returns 532 rows! What's going on?
FROM Task
INNER JOIN TaskStatus ON Task.TaskStatusId = TaskStatus.TaskStatusId;

SELECT *  -- The query returns 11 rows. There are our missing rows! 543 - 11 = 532.
FROM Task
WHERE TaskStatusId IS NULL;

SELECT *
FROM Task
LEFT OUTER JOIN TaskStatus 
    ON Task.TaskStatusId = TaskStatus.TaskStatusId;
    
SELECT
    Task.TaskId,
    Task.Title,
    IFNULL(Task.TaskStatusId, 0) AS TaskStatusId, -- Replacing a NULL Value With IFNULL() = 0
    IFNULL(TaskStatus.Name, '[None]') AS StatusName -- Replacing a NULL Value With IFNULL() = '[none]'
FROM Task
LEFT OUTER JOIN TaskStatus 
    ON Task.TaskStatusId = TaskStatus.TaskStatusId;

SELECT
    Project.Name ProjectName, -- An alias makes this more clear.
    Worker.FirstName,
    Worker.LastName
FROM Project
LEFT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
LEFT OUTER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId;

-- INNER JOIN - relationship must exist
-- OUTER JOIN - relationship is optional
-- OUTER JOIN with filter - relationship must not exist

SELECT
    Project.Name ProjectName,
    Worker.FirstName,
    Worker.LastName
FROM Project
LEFT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
LEFT OUTER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
WHERE ProjectWorker.WorkerId IS NULL; -- Throws out projects with workers.

-- Projects without workers, we only need the bridge table to confirm.
SELECT
    Project.Name ProjectName
FROM Project
LEFT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
WHERE ProjectWorker.WorkerId IS NULL;

SELECT
    Project.Name ProjectName,
    Worker.FirstName,
    Worker.LastName
FROM Project
RIGHT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
RIGHT OUTER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
WHERE ProjectWorker.ProjectId IS NULL;
-- WHERE ProjectWorker.WorkerId IS NULL; // This works as well. Why?

-- Workers without a project
SELECT
    Worker.FirstName,
    Worker.LastName
FROM ProjectWorker
RIGHT OUTER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
WHERE ProjectWorker.ProjectId IS NULL;

SELECT
    Worker.FirstName,
    Worker.LastName
FROM Worker
LEFT OUTER JOIN ProjectWorker ON Worker.WorkerId = ProjectWorker.WorkerId
WHERE ProjectWorker.WorkerId IS NULL;

SELECT
    parent.TaskId ParentTaskId,
    child.TaskId ChildTaskId,
    CONCAT(parent.Title, ': ', child.Title) Title
FROM Task parent
INNER JOIN Task child ON parent.TaskId = child.ParentTaskId;

SELECT
    p.Name ProjectName,
    w.FirstName,
    w.LastName,
    t.Title
FROM Project p
INNER JOIN ProjectWorker pw ON p.ProjectId = pw.ProjectId
INNER JOIN Worker w ON pw.WorkerId = w.WorkerId
INNER JOIN Task t ON pw.ProjectId = t.ProjectId
    AND pw.WorkerId = t.WorkerId
WHERE p.ProjectId = 'game-goodboy';

-- CROSS JOIN -- 
SELECT
   CONCAT(w.FirstName, ' ', w.LastName) WorkerName,
   p.Name ProjectName
FROM Worker w
CROSS JOIN Project p
WHERE w.WorkerId = 1
AND p.ProjectId NOT LIKE 'game-%';