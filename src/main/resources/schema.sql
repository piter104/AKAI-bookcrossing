CREATE TABLE IF NOT EXISTS tb_user(
    id INT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_book(
    id INT AUTO_INCREMENT NOT NULL ,
    title VARCHAR (255) NOT NULL,
    author VARCHAR (255) NOT NULL,
    description TEXT,
    owner_id INT,
    current_owner_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (owner_id) REFERENCES tb_user(id),
    FOREIGN KEY (current_owner_id) REFERENCES tb_user(id)
);

CREATE TABLE IF NOT EXISTS tb_opinion (
     id INT AUTO_INCREMENT NOT NULL,
     rating INT NOT NULL,
     description TEXT,
     book_id INT NOT NULL,
     author_id INT NOT NULL,
     PRIMARY KEY(id),
     FOREIGN KEY(book_id) REFERENCES tb_book(id),
     FOREIGN KEY(author_id) REFERENCES tb_user(id)
);