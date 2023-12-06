drop
database if exists dbregistroverificacao;
create
database dbregistroverificacao;
use
dbregistroverificacao;
 
CREATE TABLE usuario
(
    ID            INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NOME          VARCHAR(255),
    CPF           VARCHAR(14),
    TELEFONE      VARCHAR(15),
    DATANASCIMENTO  DATE,
    CTPS          VARCHAR(12) UNIQUE,
    NIVELACESSO VARCHAR(255),
    CARGO VARCHAR(255),
	MATRICULA 	  NUMERIC(6) UNIQUE,
    SENHA 		  VARCHAR(55),
    STATUSUSUARIO VARCHAR(255),
    IDULTIMOAFASTAMENTO INT,
    DATACONTRATACAO DATE,
    DATADESLIGAMENTO DATE
);
 
CREATE TABLE afastamento (
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NATUREZA VARCHAR(255),
    DESCRICAO VARCHAR(255),
    DATAINICIO DATE,
    DATAFIM DATE,
    IDUSUARIO INT,
    FOREIGN KEY (IDUSUARIO)
        REFERENCES usuario (ID)
);
 
CREATE TABLE atividade
(
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    DESCRICAO     VARCHAR(255),
    CARGO   VARCHAR(255)
);
 
CREATE TABLE sala
(
    ID         INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NUMERO     VARCHAR(10),
    DISPONIVEL BOOLEAN
);
 
 CREATE TABLE categoria (
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR (255),
    ATIVO BOOLEAN
 );

 CREATE TABLE ocorrencia (
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    DESCRICAO VARCHAR(255),
    STATUSOCORRENCIA BOOLEAN,
    DATAOCORRENCIA    DATETIME
);

CREATE TABLE categoria_ocorrencia (
	IDOCORRENCIA INT,
	FOREIGN KEY (IDOCORRENCIA) REFERENCES ocorrencia (ID),
	IDCATEGORIA INT,
	FOREIGN KEY (IDCATEGORIA) REFERENCES categoria (ID)
);
 
CREATE TABLE servicoprestado
(
    ID            INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    IDSALA        INT,
    FOREIGN KEY (IDSALA) REFERENCES sala (ID),
    DATAINICIO    DATETIME,
    DATAFIM       DATETIME,
    IDUSUARIO INT,
    FOREIGN KEY (IDUSUARIO) REFERENCES usuario (ID),
    IDOCORRENCIA INT,
    FOREIGN KEY (IDOCORRENCIA) REFERENCES ocorrencia (ID)
);
 
CREATE TABLE atividade_servicoprestado 
(
	IDATIVIDADE_SERVICOPRESTADO INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	IDATIVIDADE INT,
    FOREIGN KEY (IDATIVIDADE) REFERENCES atividade (ID),
	IDSERVICOPRESTADO INT,
    FOREIGN KEY (IDSERVICOPRESTADO) REFERENCES servicoprestado (ID)
);
 
/*SALAS*/
INSERT INTO sala (numero, disponivel)
VALUES (101, TRUE);
INSERT INTO sala (numero, disponivel)
VALUES (102, TRUE);
INSERT INTO sala (numero, disponivel)
VALUES (103, TRUE);
INSERT INTO sala (numero, disponivel)
VALUES (104, TRUE);
INSERT INTO sala (numero, disponivel)
VALUES (105, TRUE);
INSERT INTO sala (numero, disponivel)
VALUES (106, TRUE);
INSERT INTO sala (numero, disponivel)
VALUES (107, TRUE);
INSERT INTO sala (numero, disponivel)
VALUES (108, TRUE);
INSERT INTO sala (numero, disponivel)
VALUES (109, TRUE);
INSERT INTO sala (numero, disponivel)
VALUES (110, TRUE);

/*CATEGORIAS*/
INSERT INTO categoria (nome, ativo)
VALUES ('Avaria', TRUE);
INSERT INTO categoria (nome, ativo)
VALUES ('Furto', TRUE);
INSERT INTO categoria (nome, ativo)
VALUES ('Problema Técnico', TRUE);
INSERT INTO categoria (nome, ativo)
VALUES ('Vandalismo', TRUE);

/*ATIVIDADES*/
INSERT INTO atividade (descricao, cargo)
VALUES ('Limpeza rotineira', 'Faxina');
INSERT INTO atividade (descricao, cargo)
VALUES ('Limpeza pesada Chão', 'Faxina');
INSERT INTO atividade (descricao, cargo)
VALUES ('Limpeza pesada Janelas', 'Faxina');
INSERT INTO atividade (descricao, cargo)
VALUES ('Limpeza pesada Paredes', 'Faxina');
INSERT INTO atividade (descricao, cargo)
VALUES ('Limpeza pesada Forro', 'Faxina');

INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Elétrica', 'Zeladoria');
INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Hidráulica', 'Zeladoria');
INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Ar Condicionado', 'Zeladoria');
INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Porta/Janela', 'Zeladoria');
INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Lâmpadas', 'Zeladoria');
INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Pragas', 'Zeladoria');
INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Mobília', 'Zeladoria');
INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Telefonia', 'Zeladoria');

INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Elétrica', 'Técnico');
INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Hidráulica', 'Técnico');
INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Ar Condicionado', 'Técnico');
INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Porta/Janela', 'Técnico');
INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Lâmpadas', 'Técnico');
INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Pragas', 'Técnico');
INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Mobília', 'Técnico');
INSERT INTO atividade (descricao, cargo)
VALUES ('Manutenção Telefonia', 'Técnico');
