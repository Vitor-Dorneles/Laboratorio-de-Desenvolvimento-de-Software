CREATE DATABASE escola;

use escola;

CREATE TABLE aluno(
id int auto_increment PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
idade int NOT null,
curso VARCHAR(50) NOT NULL
);

SHOW TABLES;
DESC aluno;

INSERT INTO aluno(nome, idade, curso)
VALUES
('João' , 20, 'Matemática'),
('Maria' , 23, 'Biologia'),
('Pedro' , 25, 'Farmácia'),
('Ana' , 20, 'História'),
('Carlos' , 26, 'Ciencia da computacao');

CREATE TABLE professor(
id INT auto_increment primary key,
nome VARCHAR(50) NOT NULL,
idade int not null,
disciplina VARCHAR(50) NOT NULL
);

INSERT INTO professor(nome, idade, disciplina)
VALUES
('Embid' , 20, 'Matemática'),
('Curry' , 20, 'História'),
('Nilo' , 26, 'Ciencia da computacao');

CREATE TABLE matricula(
id int auto_increment primary key,
id_aluno int,
id_profesor int,
data_matricula DATE,

foreign key (id_aluno) references aluno(id),
foreign key (id_profesor) references professor(id)
);


INSERT INTO matricula(id_aluno, id_professor, data_matricula)
VALUES
(1, 1, '2026-01-15' ),
(1, 3, '2025-01-15' ),
(2, 2, '2026-01-15' ),
(3, 3, '2026-01-15' );

select * from aluno;

select nome, disciplina    
from professor;