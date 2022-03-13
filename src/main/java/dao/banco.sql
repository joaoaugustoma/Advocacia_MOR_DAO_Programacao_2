CREATE TABLE PESSOA (
                        IDPESSOA SERIAL PRIMARY KEY,
    --Automaticamente gerencia as chaves primarias
                        NOME VARCHAR NOT NULL,
                        ENDERECO VARCHAR,
                        CEP VARCHAR,
                        BAIRRO VARCHAR,
                        CIDADE VARCHAR,
                        UF VARCHAR,
                        TELEFONE VARCHAR,
                        EMAIL VARCHAR
);

CREATE TABLE PESSOAFISICA (
                              CPF bigint PRIMARY KEY,
                              RG int,
                              PESSOA_IDPESSOA int,
                              FOREIGN KEY (PESSOA_IDPESSOA) REFERENCES PESSOA (IDPESSOA)
);

CREATE TABLE PESSOAJURIDICA (
                                CNPJ bigint PRIMARY KEY,
                                PESSOA_IDPESSOA int,
                                FOREIGN KEY (PESSOA_IDPESSOA) REFERENCES PESSOA (IDPESSOA)
);

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

create table auduiencias (
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
                           foreign key (audiencias_idaudiencias) references auduiencias (idaudiencias)
);

create table custas (
                        idcustas serial primary key,
                        datacusta Date,
                        descricao varchar,
                        valor float,
                        processos_idprocessos int,
                        foreign key (processos_idprocessos) references processos (idprocessos)
);