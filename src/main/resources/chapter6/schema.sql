CREATE TABLE singer (
    id serial NOT NULL PRIMARY KEY,
    first_name varchar(60) NOT NULL,
    last_name varchar(40) NOT NULL,
    birth_date date,
    CONSTRAINT uq_singer_1 UNIQUE(first_name, last_name)
);

CREATE TABLE album (
    id serial NOT NULL PRIMARY KEY,
    singer_id integer NOT NULL,
    title varchar(100) NOT NULL,
    release_date date,
    CONSTRAINT uq_singer_album_1 UNIQUE(singer_id, title),
    CONSTRAINT fk_album FOREIGN KEY(singer_id) REFERENCES singer(id)
);