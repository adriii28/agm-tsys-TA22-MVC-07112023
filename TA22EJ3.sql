CREATE DATABASE TA22Ej3;

USE TA22Ej3;

DROP TABLE cientificos;
DROP TABLE proyecto;
DROP TABLE asignado_a;

CREATE TABLE cientificos (
dni varchar(9),
nomApels nvarchar(255),
PRIMARY KEY (dni)
);

CREATE TABLE proyecto (
id char(4),
nombre nvarchar(255),
horas int,
PRIMARY KEY (id)
);

CREATE TABLE asignado_a (
cientifico varchar(9),
proyecto char(4),
PRIMARY KEY (cientifico, proyecto),
FOREIGN KEY (cientifico) REFERENCES cientificos(dni)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (proyecto) REFERENCES proyecto(id)
ON DELETE CASCADE ON UPDATE CASCADE
);

