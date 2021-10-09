--changeset CIOBANU_IONUT_INSERT_INTO_CLIENT

ALTER TABLE IF EXISTS lib.client
ADD cnp VARCHAR(255);

INSERT INTO lib.CLIENT(NAME, AGE, GENDER, CNP)
VALUES('Arthur Kenneth Vanderwall', 23, 'Male', 1234567891234),
        ('Patricia Parker', 20, 'Female', 9876543219876),
        ('Kye Snyder', 25, 'Male', 2222333344441),
        ('Roza Burch', 21, 'Female', 1222233334444),
        ('Gloria Mercer', 24, 'Female', 3222233334444);
