package com.sistemaRegistroVerificacao.model.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Estes @ reduzem o código pois eliminam todas as linhas de construtores e gets e sets
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "USUARIO")
public class Usuario {
	public static final String NIVEL_FUNCIONARIO = "Funcionário";
	public static final String NIVEL_GERENTE = "Gerente";
	public static final String NIVEL_RH = "Recursos Humanos";

	public static final String STATUS_ATIVO = "Ativo";
	public static final String STATUS_INATIVO = "Inativo";
	public static final String STATUS_AFASTADO = "Afastado";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
    @NotNull(message = "É necessário informar o nome")	
	private String nome;
	
	@Column()
    @NotNull(message = "É necessário informar o CPF")	
	private String cpf;
	
	@Column()
    @NotNull(message = "É necessário informar o telefone")
	private String telefone;

	@Column(name = "data_nascimento")
    @NotNull(message = "É necessário informar a data de nascimento")
	private LocalDate dataNascimento;

	@Column()
	private String ctps;

	@Column(name = "nivel_acesso")
	private String nivelAcesso;

	@ManyToOne
	@JoinColumn(name = "id_cargo", referencedColumnName = "id")
	private Cargo cargo;

	@Column()
	private String matricula;
	
	@Column()
    @NotNull(message = "É necessário informar a senha")
	private String senha;

	@Column(name = "status")
    @NotNull(message = "É necessário informar o status")
	private String statusUsuario;

	@JsonBackReference
	@OneToMany(mappedBy = "usuario")
	private List<Afastamento> afastamentos;

	@Column(name = "data_desligamento")
	private LocalDate dataDesligamento;

	@Column(name = "data_contratacao")
    @NotNull(message = "É necessário informar a data de contratação")
	private LocalDate dataContratacao;
}
