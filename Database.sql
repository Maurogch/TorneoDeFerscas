create database TorneoDeFrescas;

create table Ganadores(
    idGanador int auto_increment,
    nombreGanador varchar(70) not null,
    bebidaEnCuerpo int not null,
    constraint `pk_idGanador` primary key (idGanador)
);