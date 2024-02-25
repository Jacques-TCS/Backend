insert into cargo (nome) values
    ("Gerente"),
	("Faxina"),
	("Recursos Humanos"),
	("Zeladoria"),
	("Técnico");

insert into usuario (nome, cpf, telefone, data_nascimento, ctps, nivel_acesso, id_cargo, matricula, senha, status, data_contratacao) values
    ('João', '32165498710', '4898653274', '2000-01-01', '32165498732', 'nivel de acesso', 1, '875421', 'senha', 'ativo', '2020-01-01'),
    ('Pedro', '32165498710', '4898653274', '2000-01-01', '32165498732', 'nivel de acesso', 2, '875421', 'senha', 'ativo', '2020-01-01'),
    ('Maria', '32165498710', '4898653274', '2000-01-01', '32165498732', 'nivel de acesso', 3, '875421', 'senha', 'ativo', '2020-01-01'),
    ('José', '32165498710', '4898653274', '2000-01-01', '32165498732', 'nivel de acesso', 4, '875421', 'senha', 'ativo', '2020-01-01'),
    ('Carlos', '32165498710', '4898653274', '2000-01-01', '32165498732', 'nivel de acesso', 5, '875421', 'senha', 'ativo', '2020-01-01'),
    ('Joana', '32165498710', '4898653274', '2000-01-01', '32165498732', 'nivel de acesso', 2, '875421', 'senha', 'ativo', '2020-01-01'),
    ('Daniela', '32165498710', '4898653274', '2000-01-01', '32165498732', 'nivel de acesso', 2, '875421', 'senha', 'ativo', '2020-01-01');

insert into afastamento (natureza, descricao, data_inicio, data_fim, id_usuario) values
    ('Doença', 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 1),
    ('Doença', 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 2),
    ('Doença', 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 3),
    ('Doença', 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 4),
    ('Doença', 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 5),
    ('Doença', 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 6),
    ('Doença', 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 7);

insert into sala (numero, disponivel) values 
    ('101', true),
    ('102', true),
    ('103', true),
    ('201', true),
    ('202', true),
    ('203', true);

insert into atividade (descricao, id_cargo) values
    ('Limpeza de sala', 2),
    ('Limpeza de janela', 2),
    ('Manutenção de sala', 5);

insert into servico_prestado (id_sala, id_usuario, data_hora_inicio, data_hora_fim) values 
    (1, 2, '2020-01-01 09:00:00', '2020-01-01 10:00:00'),
    (2, 6, '2020-01-01 09:00:00', '2020-01-01 10:00:00'),
    (3, 7, '2020-01-01 09:00:00', '2020-01-01 10:00:00'),
    (4, 2, '2020-01-01 09:00:00', '2020-01-01 10:00:00'),
    (5, 6, '2020-01-01 09:00:00', '2020-01-01 10:00:00');

insert into servico_prestado_tem_atividades(id_servico_prestado, id_atividade) values
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 1),
    (5, 2);

insert into categoria (nome, ativo) values
    ('Cadeira quebrada', true),
    ('Mesa quebrada', true),
    ('Janela quebrada', true);

insert into ocorrencia (servico_prestado_id, descricao, status, data_ocorrencia) values 
    (1, 'Ocorrência', true, '2020-01-01'),
    (2, 'Ocorrência', true, '2020-01-01'),
    (3, 'Ocorrência', true, '2020-01-01');

insert into ocorrencia_tem_categorias (id_ocorrencia, id_categoria) values
    (1, 1),
    (1, 2),
    (2, 1),
    (3, 3);