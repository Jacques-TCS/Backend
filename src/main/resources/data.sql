insert into nivel_acesso (nome) values
    ("Gerente"),
    ("RH"),
    ("Funcionário");
    
insert into cargo (nome, id_nivel_acesso) values
    ("Gerente", 1),
	("Faxina", 3),
	("Recursos Humanos", 2),
	("Zeladoria", 3),
	("Técnico", 3);

insert into usuario (nome, cpf, telefone, data_nascimento, ctps, id_cargo, matricula, senha, status, data_contratacao) values
    ('João', '32165498710', '4898653274', '2000-01-01', '32165498732', 1, '875421', 'senha', 'ativo', '2020-01-01'),
    ('Pedro', '32165498710', '4898653274', '2000-01-01', '32165498732', 2, '875421', 'senha', 'ativo', '2020-01-01'),
    ('Maria', '32165498710', '4898653274', '2000-01-01', '32165498732', 3, '875421', 'senha', 'ativo', '2020-01-01'),
    ('José', '32165498710', '4898653274', '2000-01-01', '32165498732', 3, '875421', 'senha', 'ativo', '2020-01-01'),
    ('Carlos', '32165498710', '4898653274', '2000-01-01', '32165498732', 3, '875421', 'senha', 'ativo', '2020-01-01'),
    ('Joana', '32165498710', '4898653274', '2000-01-01', '32165498732', 3, '875421', 'senha', 'ativo', '2020-01-01'),
    ('Daniela', '32165498710', '4898653274', '2000-01-01', '32165498732', 3, '875421', 'senha', 'ativo', '2020-01-01');

insert into natureza_afastamento (descricao) values 
    ("Doença ou acidente"),
    ("Saúde mental"),
    ("Licença-maternidade"),
    ("Licença-paternidade");

insert into afastamento (id_natureza_afastamento, descricao, data_inicio, data_fim, id_usuario) values
    (1, 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 1),
    (1, 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 2),
    (3, 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 3),
    (4, 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 4),
    (2, 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 5),
    (2, 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 6),
    (3, 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 7);

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

insert into servico_prestado (id_sala, data_hora_inicio) values 
    (1, '2020-01-01 09:00:00'),
    (2, '2020-01-01 09:00:00'),
    (3, '2020-01-01 09:00:00'),
    (4, '2020-01-01 09:00:00'),
    (5, '2020-01-01 09:00:00');

insert into servico_prestado_historico (de, id_servico_prestado, id_usuario, para, data_hora_alteracao) values 
    ('R', 1, 3, 'I', '2020-01-01 09:00:00'),
    ('R', 2, 4, 'I', '2020-01-01 09:00:00'),
    ('R', 3, 5, 'I', '2020-01-01 09:00:00'),
    ('R', 4, 6, 'I', '2020-01-01 09:00:00'),
    ('R', 5, 7, 'I', '2020-01-01 09:00:00');

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