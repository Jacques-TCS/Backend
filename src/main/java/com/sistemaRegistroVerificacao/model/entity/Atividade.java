package com.sistemaRegistroVerificacao.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "atividade")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Atividade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column()
    @NotEmpty(message = "É necessário informar a descrição")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "id_cargo", referencedColumnName = "id", nullable = false)
    @NotNull(message = "É necessário informar o cargo")
	private Cargo cargo;

	@Transient
	private Boolean selecionado;
}
