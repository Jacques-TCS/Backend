package com.sistemaRegistroVerificacao.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "afastamento")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Afastamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column()
    @NotNull(message = "É necessário informar a natureza do afastamento")
	private String natureza;

	@ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;


	@Column(name = "data_inicio")
    @NotNull(message = "É necessário informar a data de início de afastamento")
	private LocalDate dataInicio;

	@Column(name = "data_fim")
    @NotNull(message = "É necessário informar a data de fim de afastamento")
	private LocalDate dataFim;

	@Column()
	private String descricao;
}
