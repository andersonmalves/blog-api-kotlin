CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS posts (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    user_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS post_category (
    post_id INT NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (post_id, category_id),
    FOREIGN KEY (post_id) REFERENCES posts(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

INSERT INTO users (name, email, password) VALUES
    ('João', 'joao@example.com', 'senha123'),
    ('Maria', 'maria@example.com', 'senha456');

INSERT INTO categories (name) VALUES
    ('Tecnologia'),
    ('Esportes');

INSERT INTO posts (title, content, user_id, created_at) VALUES
    ('Introdução ao Spring Boot', 'Este é um tutorial sobre como começar com o Spring Boot.', 1, NOW());

INSERT INTO post_category (post_id, category_id) VALUES
    (1, 1);

INSERT INTO posts (title, content, user_id, created_at) VALUES
    ('Melhores Exercícios para Ganho de Massa Muscular', 'Confira os melhores exercícios para ganhar massa muscular rapidamente.', 2, NOW());

INSERT INTO post_category (post_id, category_id) VALUES
    (2, 2);
