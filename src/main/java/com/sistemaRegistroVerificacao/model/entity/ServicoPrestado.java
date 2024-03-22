package com.sistemaRegistroVerificacao.model.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

import org.hibernate.query.sqm.FetchClauseType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "servico_prestado")
public class ServicoPrestado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_sala", referencedColumnName = "id")
    @NotNull(message = "É necessário informar a sala do serviço")
	private Sala sala;

	@Column(name = "data_hora_inicio")
    @NotNull(message = "É necessário informar a hora de início do serviço")
	private LocalDateTime dataHoraInicio;
	
	@Column(name = "data_hora_fim")
	private LocalDateTime dataHoraFim;

	/*
	 * Cria uma nova entidade chamada "servico_prestado_tem_atividades" para
	 * relacionar as atividades de um serviço prestado.
	 */
	@ManyToMany
	@JoinTable(name = "servico_prestado_tem_atividades", joinColumns = @JoinColumn(name = "id_servico_prestado", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_atividade", referencedColumnName = "id"))
	@NotNull(message = "É necessário informar as atividades")
	private Set<Atividade> atividades;

	/*
	 * Lista com o histórico do serviço prestado.
	 * A annotation @JsonIgnoreProperties serve para que um loop não seja criado,
	 * já que a entidade ServicoPrestadoHistorico possui uma chave estrangeira de 
	 * ServicoPrestado
	 */
	@OneToMany(mappedBy = "servicoPrestado")
	@JsonIgnoreProperties("servicoPrestado")
    private List<ServicoPrestadoHistorico> historico;

	/*
	 * Ocorrência do serviço prestado.
	 * A annotation @JsonIgnoreProperties serve para que um loop não seja criado,
	 * já que a entidade Ocorrencia possui uma chave estrangeira de 
	 * ServicoPrestado
	 */
	@OneToOne(mappedBy = "servicoPrestado")
	@JsonIgnoreProperties("servicoPrestado")
    private Ocorrencia ocorrencia;
}
