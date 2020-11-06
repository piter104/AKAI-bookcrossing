CREATE TABLE IF NOT EXISTS tb_user
(
    id        INT AUTO_INCREMENT NOT NULL,
    full_name VARCHAR(255),
    email     VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_book
(
    id          INT AUTO_INCREMENT NOT NULL,
    title       VARCHAR(255)       NOT NULL,
    author      VARCHAR(255)       NOT NULL,
    description TEXT,
    owner_id    INT,
    reader_id   INT,
    PRIMARY KEY (id),
    FOREIGN KEY (owner_id) REFERENCES tb_user (id),
    FOREIGN KEY (reader_id) REFERENCES tb_user (id)
);

CREATE TABLE IF NOT EXISTS tb_opinion
(
    id          INT AUTO_INCREMENT NOT NULL,
    rating      INT                NOT NULL,
    description TEXT,
    book_id     INT                NOT NULL,
    author_id   INT                NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (book_id) REFERENCES tb_book (id),
    FOREIGN KEY (author_id) REFERENCES tb_user (id)
);

CREATE TABLE IF NOT EXISTS tb_tag
(
    id   INT AUTO_INCREMENT NOT NULL,
    name varchar(255)       NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_book_tags
(
    book_id INT NOT NULL,
    tag_id  INT NOT NULL,
    PRIMARY KEY (book_id, tag_id),
    FOREIGN KEY (book_id) REFERENCES tb_book (id),
    FOREIGN KEY (tag_id) REFERENCES tb_tag (id)
);