-- Banco da Pessoa e do Veículo (veio do BdAula01.sql da Aula 07)

-- sem isto o Docker lê o arquivo como latin1 e grava "JoÃ£o" no lugar de "João"
SET NAMES utf8mb4;

CREATE DATABASE IF NOT EXISTS bdaula01;

USE bdaula01;

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

INSERT INTO veiculo (modelo, placa, id_pessoa)
VALUES
    ('Gol', 'ABC1D23', 1),
    ('Onix', 'XYZ9K87', 2);

SHOW TABLES;
