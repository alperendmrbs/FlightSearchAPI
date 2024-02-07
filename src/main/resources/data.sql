-- Havaalanları için örnek veriler
INSERT INTO AIRPORTS (city) VALUES ('Istanbul');
INSERT INTO AIRPORTS (city) VALUES ('Ankara');
INSERT INTO AIRPORTS (city) VALUES ('Izmir');

-- Uçuşlar için örnek veriler
INSERT INTO FLIGHTS (departure_airport_id, arrival_airport_id, departure_datetime, return_datetime, price)
VALUES
    ((SELECT id FROM AIRPORTS WHERE city = 'Istanbul'), (SELECT id FROM AIRPORTS WHERE city = 'Ankara'),
     '2024-01-01 10:00:00', '2024-01-01 12:00:00', 150.0);

INSERT INTO FLIGHTS (departure_airport_id, arrival_airport_id, departure_datetime, return_datetime, price)
VALUES
    ((SELECT id FROM AIRPORTS WHERE city = 'Ankara'), (SELECT id FROM AIRPORTS WHERE city = 'Izmir'),
     '2024-01-02 14:00:00', '2024-01-02 16:00:00', 200.0);

INSERT INTO FLIGHTS (departure_airport_id, arrival_airport_id, departure_datetime, price)
VALUES
    ((SELECT id FROM AIRPORTS WHERE city = 'Izmir'), (SELECT id FROM AIRPORTS WHERE city = 'Istanbul'),
     '2024-01-03 18:00:00', 100.0);


--INSERT INTO USERS(id, email, password) VALUES (1, 'alperen@alperen', '$2a$10$DNp2MWG1PWBddzkE7nXGkux8lhVvtbka0aBu88WFPJyLiBXBs8Vvm');
