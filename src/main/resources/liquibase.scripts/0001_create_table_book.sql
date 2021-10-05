--changeset CIOBANU_IONUT_99_CREATE_TABEL_BOOK
DROP TABLE IF EXISTS lib.BOOK;

CREATE TABLE lib.BOOK
(

    ID        SERIAL,
    PRICE     double precision,
    TITLE   character varying(255),
    AUTHOR character varying(255),
    GENRE       character varying(255),
    BRAND  character varying(255),
    LANGUAGE character varying(255),
    YEAR int,
    AVAIALABLE boolean



);