--changeset ALEX_D_INSERT_DATA_INTO_STUDENT

INSERT INTO lib.STUDENT(NAME, AGE, CNP, GENRE, UNIVERSITY, NUMBER_OF_LATE_RETURNINGS,IS_VALID_FOR_RENTAL)
VALUES('Alex Petarda', 23,'1990126440044', 'Male', 'TRAIAN', 2, true),
        ('Cipi Piftie', 20,'1941023440018' , 'Male', 'Izvor', 3,true),
        ('Ion Neculce', 25,'2990126440078' , 'Male', 'Politehnica', 5,false),
        ('Andrada Boss', 21,'2990126440198' , 'Female', 'University of Glasgow', 1,true),
        ('Andrei Camatar', 28,'1990126449987' , 'Male', 'University of Oxford', 10,false),
        ('Elena Regina', 22,'2990126441231' , 'Female', 'University of Cambridge', 0,true);

