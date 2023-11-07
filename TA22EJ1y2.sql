CREATE DATABASE TA22Ej1;

USE TA22Ej1;

CREATE TABLE `cliente` (
`id` int(11) NOT NULL auto_increment,
`nombre` varchar(250) default null,
`apellido` varchar(250) default null,
`direccion` varchar(250) default null,
`dni` int(11) default null,
`fecha` date default null,
PRIMARY KEY (`id`)
);

CREATE TABLE `videos` (
`id` int(11) NOT NULL auto_increment,
`title` varchar(250) default null,
`director` varchar(250) default null,
`cli_id` int(11) default null,
PRIMARY KEY (`id`),
CONSTRAINT `videos_fk` foreign key (`cli_id`) REFERENCES `cliente` (`id`)
);






