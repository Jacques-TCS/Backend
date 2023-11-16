package com.sistemaRegistroVerificacao.model.entity;

import java.time.LocalDate;

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

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "AFASTAMENTO")
public class Afastamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String natureza;

	@ManyToOne
	@JoinColumn(name = "IDUSUARIO")
	private Usuario idUsuario;

	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String descricao;

}
