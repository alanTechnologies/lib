--changeset ALEX_D_CREATE_TABEL_STUDENT
DROP TABLE IF EXISTS lib.student cascade;

CREATE TABLE IF NOT EXISTS  lib.student
(
    ID        SERIAL unique ,
    NAME   character varying(255),
    AGE     integer,
    IS_VALID_FOR_RENTAL BOOLEAN,
    CNP     character varying(255),
    GENRE       character varying(255),
    UNIVERSITY  character varying(255),
    NUMBER_OF_LATE_RETURNINGS integer,
    RENT_BOOK_ID integer,

    CONSTRAINT RENT_BOOK_ID FOREIGN KEY (RENT_BOOK_ID) REFERENCES lib.RENTBOOK (ID)

);


