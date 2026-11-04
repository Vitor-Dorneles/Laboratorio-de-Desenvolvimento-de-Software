CREATE DATABASE escola;

USE escola;

CREATE TABLE aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    idade INT NOT NULL,
    curso VARCHAR(50) NOT NULL
);

SHOW TABLES;
DESC aluno;

INSERT INTO aluno (nome, idade, curso)
VALUES
    ('João', 20, 'Matemática'),
    ('Maria', 23, 'Biologia'),
    ('Pedro', 25, 'Farmácia'),
    ('Ana', 20, 'História'),
    ('Carlos', 26, 'Ciência da Computação');

CREATE TABLE professor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    idade INT NOT NULL,
    disciplina VARCHAR(50) NOT NULL
);

INSERT INTO professor (nome, idade, disciplina)
VALUES
    ('Embid', 20, 'Matemática'),
    ('Curry', 20, 'História'),
    ('Nilo', 26, 'Ciência da Computação');

CREATE TABLE matricula (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_aluno INT,
    id_professor INT,
    data_matricula DATE,
    FOREIGN KEY (id_aluno) REFERENCES aluno(id),
    FOREIGN KEY (id_professor) REFERENCES professor(id)
);

INSERT INTO matricula (id_aluno, id_professor, data_matricula)
VALUES
    (1, 1, '2026-01-15'),
    (1, 3, '2025-01-15'),
    (2, 2, '2026-01-15'),
    (3, 3, '2026-01-15');

SELECT *
FROM aluno;

SELECT nome, disciplina
FROM professor;
