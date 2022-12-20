create table cliente (
	id bigint not null auto_increment,
    nome varchar(60) not null,
    endereco varchar(255) not null,
    telefone varchar(20) not null,
    modelo_carro varchar(50) not null,
    placa varchar(7) not null,
    
    primary key (id)
);