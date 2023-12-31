CREATE DATABASE IF NOT EXISTS ticketgurudb;
USE ticketgurudb;

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS appuser;
DROP TABLE IF EXISTS venue;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS tickettype;
DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS saleevent;

SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE appuser(
userid BIGINT NOT NULL AUTO_INCREMENT, 
username VARCHAR(100), 
password VARCHAR(100), 
role VARCHAR(100), 
PRIMARY KEY(userid)
);

CREATE TABLE venue(
venueid BIGINT NOT NULL AUTO_INCREMENT, 
name VARCHAR(100) NOT NULL, 
address VARCHAR(100) NOT NULL, 
city VARCHAR(100) NOT NULL, 
capacity INTEGER, 
PRIMARY KEY(venueid)
);

CREATE TABLE event(
eventid BIGINT NOT NULL AUTO_INCREMENT, 
name VARCHAR(100) NOT NULL, 
date DATE, 
time TIME, 
venueid BIGINT NOT NULL, 
FOREIGN KEY (venueid) REFERENCES venue(venueid), 
PRIMARY KEY(eventid)
);

CREATE TABLE tickettype(
tickettypeid BIGINT NOT NULL AUTO_INCREMENT, 
price DOUBLE NOT NULL, 
ticketname VARCHAR(100) NOT NULL, 
description VARCHAR(100), 
eventid BIGINT NOT NULL, 
FOREIGN KEY (eventid) REFERENCES event(eventid), 
PRIMARY KEY(tickettypeid)
);

CREATE TABLE saleevent(
saleeventid BIGINT NOT NULL AUTO_INCREMENT, 
saledate date NOT NULL, 
saletime time NOT NULL, 
amount INT NOT NULL, 
PRIMARY KEY(saleeventid)
);

CREATE TABLE ticket(
ticketid BIGINT NOT NULL AUTO_INCREMENT, 
barcode VARCHAR(100), 
eventid BIGINT NOT NULL, 
tickettypeid BIGINT NOT NULL, 
saleeventid BIGINT NOT NULL, 
ischecked BOOLEAN NOT NULL DEFAULT FALSE,
FOREIGN KEY (eventid) REFERENCES event(eventid), 
FOREIGN KEY (tickettypeid) REFERENCES tickettype(tickettypeid), 
FOREIGN KEY (saleeventid) REFERENCES saleevent(saleeventid), 
PRIMARY KEY(ticketid)
);

INSERT INTO appuser (username, password, role)
VALUES ('admin', '$2a$10$bRnDm/nAWqHORRh.hA9R1Oqpm6pDQFeLCVvhxgvhONe42qj8bImyi', 'ADMIN'),
('ticketseller', '$2a$10$SvEWddkbGQttIFRZ3By4Gej1RHvlLiorZT4FVRw3qAVtlPyCFtCGu', 'TICKETSELLER');

INSERT INTO venue (name, address, city, capacity)
VALUES ('Stadium', '123 Street', 'City', 5000);

INSERT INTO event (venueid, name, date, time)
VALUES (1, 'Concert', '2023-10-20', '19:30');

INSERT INTO tickettype (price, ticketname, description, eventid)
VALUES (15.00, 'Student', 'Discount for students', 1), 
(25.00, 'Regular', 'Standard price', 1);

SELECT * FROM appuser;
SELECT * FROM venue;
SELECT * FROM event;
SELECT * FROM tickettype;
SELECT * FROM ticket;
SELECT * FROM saleevent;
