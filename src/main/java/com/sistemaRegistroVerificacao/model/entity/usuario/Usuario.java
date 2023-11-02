package com.sistemaRegistroVerificacao.model.entity.usuario;

import java.time.LocalDate;

import com.sistemaRegistroVerificacao.model.entity.afastamento.Afastamento;
import com.sistemaRegistroVerificacao.model.entity.cargo.Cargo;
import com.sistemaRegistroVerificacao.model.entity.nivelAcesso.NivelAcesso;
import com.sistemaRegistroVerificacao.model.entity.statusUsuario.StatusUsuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private String telefone;
	private LocalDate dataNascimento;
	private String ctps;

	@ManyToOne
	@JoinColumn(name = "IDNIVELACESSO")
	private NivelAcesso nivelAcesso;

	@ManyToOne
	@JoinColumn(name = "IDCARGO")
	private Cargo cargo;

	private String matricula;
	private String senha;

	@ManyToOne
	@JoinColumn(name = "IDSTATUSUSUARIO")
	private StatusUsuario statusUsuario;

	private Afastamento ultimoAfastamento;

	private LocalDate dataDesligamento;
	private LocalDate dataContratacao;
}
