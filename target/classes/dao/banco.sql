create table TRIBUNAIS (
                           IDTRIBUNAIS serial primary key,
                           DESCRICAO varchar,
                           ENDERECO varchar
);

create table varas (
                       idvaras serial primary key,
                       descricao varchar,
                       tribunais_idtribunais int,
                       foreign key (tribunais_idtribunais) references tribunais (idtribunais)
);

create table audiencias (
                             idaudiencias serial primary key,
                             dataaudiencia Date,
                             parecer varchar
);

create table processos (
                           idprocessos serial primary key,
                           dataabertura Date,
                           dataconclusao Date,
                           situacao int,
                           audiencias_idaudiencias int,
                           foreign key (audiencias_idaudiencias) references audiencias (idaudiencias)
);

create table custas (
                        idcustas serial primary key,
                        datacusta Date,
                        descricao varchar,
                        valor float,
                        processos_idprocessos int,
                        foreign key (processos_idprocessos) references processos (idprocessos)
);