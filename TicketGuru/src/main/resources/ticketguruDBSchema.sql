SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS appuser;
DROP TABLE IF EXISTS venue;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS ticketType;
DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS saleEvent;

SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE appuser
(userId BIGINT NOT NULL AUTO_INCREMENT
, username VARCHAR(100)
, password VARCHAR(100)
, role VARCHAR(100)
, PRIMARY KEY(userId)
);

CREATE TABLE venue
(venueId BIGINT NOT NULL AUTO_INCREMENT
, name VARCHAR(100) NOT NULL
, address VARCHAR(100) NOT NULL
, city VARCHAR(100) NOT NULL
, capacity INTEGER
, PRIMARY KEY(venueId)
);

CREATE TABLE event
(eventId BIGINT NOT NULL AUTO_INCREMENT
, name VARCHAR(100) NOT NULL
, date DATE
, time TIME
, FOREIGN KEY (venueId) REFERENCES venue(venueId)
, PRIMARY KEY(eventId)
);

CREATE TABLE ticketType
(typeId BIGINT NOT NULL AUTO_INCREMENT
, price DOUBLE NOT NULL
, ticketType VARCHAR(100) NOT NULL
, description VARCHAR(100)
, FOREIGN KEY (eventId) REFERENCES event(eventId)
, PRIMARY KEY(typeId)
);

CREATE TABLE saleEvent
(saleEventId BIGINT NOT NULL AUTO_INCREMENT
, saleDate date NOT NULL
, saleTime time NOT NULL
, amount INT NOT NULL
, PRIMARY KEY(saleEventId)
);

CREATE TABLE ticket
(ticketId BIGINT NOT NULL AUTO_INCREMENT
, barcode VARCHAR(100)
, FOREIGN KEY (eventId) REFERENCES event(eventId)
, FOREIGN KEY (typeId) REFERENCES ticketType(typeId)
, FOREIGN KEY (saleEventId) REFERENCES saleEvent(saleEventId)
, PRIMARY KEY(ticketId)
);

INSERT INTO appuser (username, password, role)
VALUES ('admin', '$2a$10$bRnDm/nAWqHORRh.hA9R1Oqpm6pDQFeLCVvhxgvhONe42qj8bImyi', 'ADMIN');

INSERT INTO venue (name, address, city, capacity)
VALUES ('Stadium', '123 Street', 'City', 5000);

INSERT INTO event (venueId, name, date, time)
VALUES (1, 'Concert', 2023-10-20, 19:30);

INSERT INTO ticketType (price, ticketType, description, eventId)
VALUES (15.00, 'Student', 'Discount for students', 1), 
(25.00, 'Regular', 'Standard price', 1);

SELECT * FROM appuser;
SELECT * FROM venue;
SELECT * FROM event;
SELECT * FROM ticketType;
SELECT * FROM ticket;
SELECT * FROM saleEvent;