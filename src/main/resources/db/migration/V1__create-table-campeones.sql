
create table campeones(

    id bigint not null auto_increment,
    nombre varchar(100) not null unique,
    region varchar(100) not null ,
    carril varchar(100) not null ,
    especialidad varchar(100) not null,
    habilidadpasiva varchar(100) not null,
    habilidadq varchar(100) not null,
    habilidadw varchar(100) not null,
    habilidade varchar(100) not null,
    habilidadr varchar(100) not null,
    primary key (id)

);