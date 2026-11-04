CREATE DATABASE BDAula01;

SHOW DATABASES;

USE BDAula01;

CREATE TABLE pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sexo VARCHAR(1) NOT NULL,
    idioma VARCHAR(10) NOT NULL
);

CREATE TABLE veiculo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(30),
    placa VARCHAR(7),
    id_pessoa INT NOT NULL,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)
);

SHOW TABLES;
DESC pessoa;

INSERT INTO pessoa (nome, sexo, idioma)
VALUES
    ('João Silva', 'M', 'Português'),
    ('Maria Souza', 'F', 'Português'),
    ('Carlos Oliveira', 'M', 'Inglês'),
    ('Ana Costa', 'F', 'Espanhol'),
    ('Pedro Santos', 'M', 'Francês'),
    ('Julia Almeida', 'F', 'Alemão'),
    ('Lucas Pereira', 'M', 'Italiano'),
    ('Beatriz Lima', 'F', 'Japonês'),
    ('Rafael Gomes', 'M', 'Português'),
    ('Camila Rocha', 'F', 'Inglês'),
    ('Bruno Martins', 'M', 'Espanhol'),
    ('Larissa Alves', 'F', 'Francês'),
    ('Gabriel Ribeiro', 'M', 'Alemão'),
    ('Fernanda Dias', 'F', 'Italiano'),
    ('Diego Carvalho', 'M', 'Português');

SELECT *
FROM pessoa;
