create table medicos(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(6) not null unique,
    especialidade varchar(20) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    Complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    Cidade varchar(100) not null,

    primary key(id)
);