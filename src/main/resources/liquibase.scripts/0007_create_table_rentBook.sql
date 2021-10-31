--changeset CREATE_TABLE_RENT_BOOK
DROP TABLE IF EXISTS lib.rentbook cascade;

CREATE TABLE IF NOT EXISTS lib.rentbook
(

    ID SERIAL unique,
    START_DATE DATE,
    END_DATE DATE,
    BOOK_ID integer,
    STUDENT_ID integer,

    CONSTRAINT BOOK_ID FOREIGN KEY (BOOK_ID) REFERENCES lib.book (ID)
)
