--changeset CIOBANU_IONUT_99_CREATE_TABLE_CLIENT

DROP TABLE IF EXISTS lib.client cascade;

CREATE TABLE IF NOT EXISTS  lib.client
(

    ID        SERIAL,
    NAME     character varying(255),
    AGE int,
    GENDER       character varying(255),
    CNP character varying(255),
    EMAIL character varying(255),
    ADRESS character varying (255)


);
