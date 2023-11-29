package com.sistemaRegistroVerificacao.model.entity;

import java.time.LocalDate;
import java.util.List;

import org.apache.tomcat.util.bcel.Const;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

	public static final String CARGO_GERENTE = "Gerente";
	public static final String CARGO_FAXINA = "Faxina";
	public static final String CARGO_RH = "Recursos Humanos";
	public static final String CARGO_ZELADORIA = "Zeladoria";
	public static final String CARGO_TECNICO = "Técnico";

	public static final String NIVEL_FUNCIONARIO = "Funcionário";
	public static final String NIVEL_GERENTE = "Gerente";
	public static final String NIVEL_RH = "Recursos Humanos";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private String telefone;

	@Column(name = "DATANASCIMENTO")
	private LocalDate dataNascimento;
	private String ctps;

	@Column(name = "NIVELACESSO")
	private String nivelAcesso;
	private String cargo;

	private String matricula;
	private String senha;

	@Column(name = "STATUSUSUARIO")
	private String statusUsuario;

	@JsonBackReference
	@OneToMany(mappedBy = "usuario")
	private List<Afastamento> afastamentos;

	@Column(name = "DATADESLIGAMENTO")
	private LocalDate dataDesligamento;

	@Column(name = "DATACONTRATACAO")
	private LocalDate dataContratacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public String getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(String statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	// public Afastamento getUltimoAfastamento() {
	// return ultimoAfastamento;
	// }

	// public void setUltimoAfastamento(Afastamento ultimoAfastamento) {
	// this.ultimoAfastamento = ultimoAfastamento;
	// }

	public LocalDate getDataDesligamento() {
		return dataDesligamento;
	}

	public void setDataDesligamento(LocalDate dataDesligamento) {
		this.dataDesligamento = dataDesligamento;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
}
