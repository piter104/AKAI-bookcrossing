INSERT INTO bookcrossing.tb_user (first_name, last_name)
VALUES ('Adam', 'Nowak');

INSERT INTO bookcrossing.tb_book (title, author, description, owner_id, reader_id)
VALUES ('Czysty kod. Podręcznik dobrego programisty', 'Robert C. Martin', 'Bardzo ważna książka', 1, 1);

INSERT INTO bookcrossing.tb_opinion (rating, book_id, author_id)
VALUES (6, 1, 1);
