-- Criação das tabelas
CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS posts (
    id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    user_id INT NOT NULL,
    status VARCHAR(25) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS categories (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tags (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS post_tags (
    post_id INT NOT NULL,
    tag_id INT NOT NULL,
    PRIMARY KEY (post_id, tag_id),
    FOREIGN KEY (post_id) REFERENCES posts(id),
    FOREIGN KEY (tag_id) REFERENCES tags(id)
);

CREATE TABLE IF NOT EXISTS post_category (
    post_id INT NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (post_id, category_id),
    FOREIGN KEY (post_id) REFERENCES posts(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE IF NOT EXISTS comments (
    id INT PRIMARY KEY,
    content TEXT,
    post_id INT,
    user_id INT,
    parent_id INT, -- Coluna para comentário pai
    publication_date TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES posts(id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (parent_id) REFERENCES comments(id) -- Chave estrangeira para comentário pai
);

INSERT INTO users (id, name, email, password) VALUES
(1, 'João', 'joao@example.com', 'senha123'),
(2, 'Maria', 'maria@example.com', 'senha456');

INSERT INTO categories (id, name) VALUES
(1, 'Tecnologia'),
(2, 'Esportes'),
(3, 'Notícias');

INSERT INTO tags (id, name) VALUES
(1, 'Java'),
(2, 'Spring'),
(3, 'Kotlin');

INSERT INTO posts (id, title, content, user_id, status) VALUES
(1, 'Novidades no mundo da tecnologia', 'Confira as últimas novidades no mundo da tecnologia.', 1, 'PUBLISHED'),
(2, 'Resultados do campeonato de futebol', 'Veja os resultados do último campeonato de futebol.', 2, 'DRAFT');

INSERT INTO post_category (post_id, category_id) VALUES
(1, 1),
(1, 3),
(2, 2);

INSERT INTO post_tags (post_id, tag_id) VALUES
(1, 1),
(1, 2),
(2, 3);

INSERT INTO comments (id, content, post_id, user_id, publication_date) VALUES
(1, 'Ótimo artigo! Fiquei impressionado com as novidades.', 1, 2, CURRENT_TIMESTAMP),
(2, 'Gostaria de saber mais sobre as tecnologias mencionadas.', 1, 1, CURRENT_TIMESTAMP);

INSERT INTO comments (id, content, post_id, user_id, parent_id, publication_date) VALUES
(3, 'Realmente, as novidades são incríveis!', 1, 1, 1, CURRENT_TIMESTAMP),
(4, 'Também achei interessante, Maria!', 1, 2, 3, CURRENT_TIMESTAMP);
