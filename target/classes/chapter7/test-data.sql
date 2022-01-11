INSERT INTO singer (first_name, last_name, birth_date)
VALUES ('John', 'Mayer', '1997-10-16');

INSERT INTO singer (first_name, last_name, birth_date)
VALUES ('Eric', 'Clapton', '1945-03-30');

INSERT INTO singer (first_name, last_name, birth_date)
VALUES ('John', 'Butler', '1975-04-01');


INSERT INTO album (singer_id, title, release_date)
VALUES (1, 'The Search For Everything', '2017-01-20');

INSERT INTO album (singer_id, title, release_date)
VALUES (1, 'Battle Studies', '2009-11-17');

INSERT INTO album (singer_id, title, release_date)
VALUES (2, 'From The Cradle', '1994-09-13');

INSERT INTO instrument (instrument_id) values ('Guitar');
INSERT INTO instrument (instrument_id) values ('Piano');
INSERT INTO instrument (instrument_id) values ('Voice');
INSERT INTO instrument (instrument_id) values ('Drums');
INSERT INTO instrument (instrument_id) values ('Synthesizer');

INSERT INTO singer_instrument (singer_id, instrument_id) values (1, 'Guitar');
INSERT INTO singer_instrument (singer_id, instrument_id) values (1, 'Piano');
INSERT INTO singer_instrument (singer_id, instrument_id) values (2, 'Guitar');
