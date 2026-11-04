SET NAMES utf8mb4;

CREATE DATABASE IF NOT EXISTS loja;

USE loja;

-- categorias vem antes: produtos aponta para ela
CREATE TABLE categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL,
    categoria_id INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);

INSERT INTO categorias (nome)
VALUES
    ('Alimentos'),
    ('Bebidas'),
    ('Limpeza');

INSERT INTO produtos (nome, preco, quantidade, categoria_id)
VALUES
    ('Arroz 5kg', 25.90, 10, 1),
    ('Feijão 1kg', 8.50, 20, 1),
    ('Refri 2L', 9.99, 15, 2),
    ('Detergente', 2.75, 30, 3);

SHOW TABLES;
