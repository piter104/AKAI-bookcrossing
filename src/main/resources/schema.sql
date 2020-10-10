CREATE TABLE IF NOT EXISTS tb_book(
    id INT AUTO_INCREMENT NOT NULL ,
    title VARCHAR (255) NOT NULL,
    author VARCHAR (255) NOT NULL,
    description TEXT,
    owner_id INT,
    PRIMARY KEY (id)
);