-- Banco da escola: aluno, professor e matrícula (veio do ESCOLA.sql da Aula 10)

-- sem isto o Docker lê o arquivo como latin1 e grava "JoÃ£o" no lugar de "João"
SET NAMES utf8mb4;

CREATE DATABASE IF NOT EXISTS escola;

USE escola;

CREATE TABLE aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    idade INT NOT NULL,
    sexo VARCHAR(1) NOT NULL,
    curso VARCHAR(50) NOT NULL
);

INSERT INTO aluno (nome, idade, sexo, curso)
VALUES
    ('João', 20, 'M', 'Matemática'),
    ('Maria', 23, 'F', 'Biologia'),
    ('Pedro', 25, 'M', 'Farmácia'),
    ('Ana', 20, 'F', 'História'),
    ('Carlos', 26, 'M', 'Ciência da Computação');

CREATE TABLE professor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    idade INT NOT NULL,
    sexo VARCHAR(1) NOT NULL,
    disciplina VARCHAR(50) NOT NULL
);

INSERT INTO professor (nome, idade, sexo, disciplina)
VALUES
    ('Embid', 20, 'M', 'Matemática'),
    ('Curry', 20, 'M', 'História'),
    ('Nilo', 26, 'M', 'Ciência da Computação'),
    ('Helena', 41, 'F', 'Biologia');

CREATE TABLE matricula (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_aluno INT NOT NULL,
    id_professor INT NOT NULL,
    data_matricula DATE NOT NULL,
    FOREIGN KEY (id_aluno) REFERENCES aluno(id) ON DELETE CASCADE,
    FOREIGN KEY (id_professor) REFERENCES professor(id) ON DELETE CASCADE
);

INSERT INTO matricula (id_aluno, id_professor, data_matricula)
VALUES
    (1, 1, '2026-01-15'),
    (1, 3, '2025-01-15'),
    (2, 2, '2026-01-15'),
    (3, 3, '2026-01-15');

SHOW TABLES;
