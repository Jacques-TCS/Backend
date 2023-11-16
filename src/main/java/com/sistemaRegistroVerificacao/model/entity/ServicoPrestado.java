package com.sistemaRegistroVerificacao.model.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "SERVICOPRESTADO")
public class ServicoPrestado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "IDSALA")
	private Sala idSala;

	private LocalDate dataHoraInicio;
	private LocalDate dataHoraFim;

	@ManyToOne
	@JoinColumn(name = "IDUSUARIO")
	private Usuario idUsuario;

	@JsonBackReference
	@OneToMany(mappedBy = "ATIVIDADE")
	private List<Atividade> atividades;

	@JsonBackReference
	@OneToMany(mappedBy = "OCORRENCIA")
	private List<Ocorrencia> ocorrencias;

}