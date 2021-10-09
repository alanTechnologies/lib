--changeset ALEX_D_CREATE_TABEL_STUDENT
DROP TABLE IF EXISTS lib.STUDENT;

CREATE TABLE lib.STUDENT
(
    ID        SERIAL,
    NAME   character varying(255),
    AGE     integer,
    CNP     character varying(255),
    GENRE       character varying(255),
    UNIVERSITY  character varying(255),
    NUMBER_OF_LATE_RETURNINGS integer
);


