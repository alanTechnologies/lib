--changeset CIOBANU_IONUT_99_CREATE_TABLE_CLIENT

DROP TABLE IF EXISTS lib.BOOK;

CREATE TABLE lib.BOOK
(

    ID        SERIAL,
    NAME     character varying(255),
    AGE int,
    GENDER       character varying(255)




);
