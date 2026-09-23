create database BDaula07;

show databases;

use bdaula07;

CREATE TABLE pessoa(
id int auto_increment PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
sexo VARCHAR(1) NOT NULL,
idioma VARCHAR(10) NOT NULL
);

SHOW TABLES;
DESC PESSOA;

INSERT INTO pessoa (nome, sexo, idioma)
VALUES
("Ricardo" , "M", "Português"),
("Vitor" , "M", "Português"),
("Renato Gaúcho" , "M", "boleiro"),
("Felipão" , "M", "Ingles"),
("Weverton" , "M", "Português");

SELECT *
FROM pessoa;


