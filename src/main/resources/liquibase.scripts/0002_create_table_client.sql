--changeset CIOBANU_IONUT_99_CREATE_TABLE_CLIENT

DROP TABLE IF EXISTS lib.CLIENT cascade;

CREATE TABLE IF NOT EXISTS  lib.CLIENT
(

    ID        SERIAL,
    NAME     character varying(255),
    AGE int,
    GENDER       character varying(255),
    CNP character varying(255)



);
