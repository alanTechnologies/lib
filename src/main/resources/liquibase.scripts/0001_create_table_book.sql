--changeset CIOBANU_IONUT_99_CREATE_TABEL_BOOK

DROP TABLE IF EXISTS lib.book cascade;

CREATE TABLE IF NOT EXISTS lib.book
(

    ID        SERIAL unique ,
    PRICE     double precision,
    TITLE   character varying(255),
    AUTHOR character varying(255),
    GENRE       character varying(255),
    BRAND  character varying(255),
    LANGUAGE character varying(255),
    YEAR int,
    URL character  varying (255),
    BOOK_CONTENT bytea NOT NULL,  -- this one saves a large object (array of bytes -- bytes[] )
    AVAILABLE BOOLEAN,
    STOCK int


);
