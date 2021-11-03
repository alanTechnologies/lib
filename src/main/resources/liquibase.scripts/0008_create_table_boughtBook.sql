--changeset CREATE_TABLE_BOUGHT_BOOK
DROP TABLE IF EXISTS lib.boughtbook cascade;

CREATE TABLE IF NOT EXISTS lib.boughtbook
(
    ID SERIAL unique,
    MAX_RETURN_DATE DATE,
    START_DATE DATE,
    BOOK_ID integer,
    CLIENT_ID integer,

    CONSTRAINT BOOK_ID FOREIGN KEY (BOOK_ID) REFERENCES lib.book (ID)
)