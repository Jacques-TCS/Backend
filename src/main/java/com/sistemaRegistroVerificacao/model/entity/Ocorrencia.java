package com.sistemaRegistroVerificacao.model.entity;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ocorrencia")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ocorrencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	private String descricao;

	/*
	 * Cria uma nova entidade chamada "ocorrencia_tem_categorias" para
	 * relacionar as categorias de uma ocorrência.
	 */
	@ManyToMany
	@JoinTable(name = "ocorrencia_tem_categorias", joinColumns = @JoinColumn(name = "id_ocorrencia", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id"))
	@NotNull(message = "É necessário informar a categoria")
	private Set<Categoria> categorias;

	/*
	 * Status podem ser:
	 * 0 => Em andamento
	 * 1 => Concluído
	 */
	@Column(name = "status")
	private Boolean status;

	@Column(name = "data_ocorrencia")
    @NotNull(message = "É necessário informar a data da ocorrência")
	private LocalDateTime dataOcorrencia;
	
	@OneToOne()
    @JoinColumn(name="servico_prestado_id", referencedColumnName = "id")
	@NotNull(message = "É necessário informar o serviço")
	@JsonIgnoreProperties("ocorrencia")
	private ServicoPrestado servicoPrestado;
}
