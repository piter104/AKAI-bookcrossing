INSERT INTO bookcrossing.tb_book (title, author, description)
VALUES ('Czysty kod. Podręcznik dobrego programisty', 'Robert C. Martin', 'Bardzo ważna książka');

INSERT INTO bookcrossing.tb_user (firstName, lastName)
VALUES ('Adam', 'Nowak');

INSERT INTO bookcrossing.tb_opinion (rating, bookId, authorId)
VALUES (6, 1, 1);
