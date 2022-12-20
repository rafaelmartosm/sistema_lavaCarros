create table ordem_servico(
	id bigint not null auto_increment,
    cliente_id bigint not null,
    taxa decimal(10,2) not null,
    tipo varchar(15) not null,
    status varchar(10) not null,
    data_ordem datetime not null,
    data_final_ordem datetime,
    
    primary key (id)
);

alter table ordem_servico add constraint fk_ordem_servico_cliente
foreign key (cliente_id) references cliente (id);
