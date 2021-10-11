--changeset STEFAN_CIPRIAN_INSERT_INTO_BOOK

INSERT INTO lib.BOOK(PRICE, TITLE, AUTHOR, GENRE, BRAND, LANGUAGE, YEAR, BOOK_CONTENT, AVAILABLE, URL, STOCK)
VALUES (95, 'Jurnalul Annei', 'Anne Frank', 'Comedie', 'Atlas', 'Romana', 1990, '[B@b5311cb', true, 'https://cdn.dc5.ro/img-prod/86957055-0.jpeg', 0),
       (58, 'Enigma Otiliei', 'George Calinescu', 'Comedie', 'Humanitas', 'Romana', 1980, '[B@72240290', false,'https://s1.domo.ro/images/mari/2020/08/07/enigma-otiliei-george-calinescu-9786068391359.jpg', 1),
       (58, 'Hotul de carti', 'Markus Zusak', 'Thriller', 'Minerva', 'Romana', 2010, '[B@6a97517', true,'https://www.librarie.net/coperti2/1/6/9/7/3/1/300x300.jpg', 3),
       (100, 'Fericirea mea esti tu', 'Jamie Mcquire', 'Drama', 'Humanitas', 'Romana', 2002, '[B@4a3516fd', true,'https://i0.wp.com/www.delicateseliterare.ro/wp-content/uploads/2016/07/fericirea-mea-esti-tu_1_fullsize.jpg?fit=1274%2C2048&ssl=1', 4);
