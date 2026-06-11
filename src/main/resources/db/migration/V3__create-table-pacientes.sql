create table pacientes
(

    id    bigint       not null auto_increment,
    nome  varchar(100) not null,
    idade tinyint unsigned not null,
    plano varchar(100),

    primary key (id)

);