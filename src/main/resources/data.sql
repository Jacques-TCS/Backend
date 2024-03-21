insert into nivel_acesso (nome) values
    ("Gerente"),
    ("Funcionário");
    
insert into cargo (nome, id_nivel_acesso) values
    ("Gerente", 1),
	("Faxina", 2);

insert into usuario (nome, cpf, telefone, data_nascimento, email, id_cargo, password, status, data_contratacao, username) values
    ('Funcionário', '32165498710', '4898653274', '2000-01-01', 'teste@teste.com', 2, '$2a$10$zN.2y7fWobw73I4oI3aiQes6/oIaED6pBxROSNOW8QQp9n1lqk83i', 'Ativo', '2020-01-01', 'faxina'),
    ('Admin', '08725149889', '48999845751', '2000-11-06', 'admin@teste.com', 1, '$2a$10$zN.2y7fWobw73I4oI3aiQes6/oIaED6pBxROSNOW8QQp9n1lqk83i', 'Ativo', '2023-11-06', 'gerente');

insert into natureza_afastamento (descricao) values 
    ("Doença ou acidente"),
    ("Saúde mental"),
    ("Licença-maternidade"),
    ("Licença-paternidade");

insert into afastamento (id_natureza_afastamento, descricao, data_inicio, data_fim, id_usuario) values
    (1, 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 1),
    (1, 'Doença', '2020-01-01 09:00:00', '2020-01-05 09:00:00', 2);

insert into sala (numero, disponivel) values 
    ('101', true),
    ('102', true),
    ('103', true),
    ('201', true),
    ('202', true),
    ('203', true);

insert into atividade (descricao, id_cargo) values
    ('Limpeza de sala', 2),
    ('Limpeza de janela', 2);

insert into servico_prestado (id_sala, data_hora_inicio) values 
    (1, '2020-01-01 09:00:00'),
    (2, '2020-01-01 09:00:00'),
    (3, '2020-01-01 09:00:00'),
    (4, '2020-01-01 09:00:00'),
    (5, '2020-01-01 09:00:00');

insert into servico_prestado_historico (de, id_servico_prestado, id_usuario, para, data_hora_alteracao) values 
    ('R', 1, 2, 'I', '2020-01-01 09:00:00'),
    ('R', 2, 2, 'I', '2020-01-01 09:00:00'),
    ('R', 3, 2, 'I', '2020-01-01 09:00:00'),
    ('R', 4, 2, 'I', '2020-01-01 09:00:00'),
    ('R', 5, 2, 'I', '2020-01-01 09:00:00');

insert into servico_prestado_tem_atividades(id_servico_prestado, id_atividade) values
    (1, 1),
    (2, 2),
    (3, 2),
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