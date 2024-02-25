package com.sistemaRegistroVerificacao.model.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @NotNull(message = "É necessário informar o funcionário")
	private Usuario usuario;

	/*
	 * Cria uma nova entidade chamada "servico_prestado_tem_atividades" para
	 * relacionar as atividades de um serviço prestado.
	 */
	@ManyToMany
	@JoinTable(name = "servico_prestado_tem_atividades", joinColumns = @JoinColumn(name = "id_servico_prestado", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_atividade", referencedColumnName = "id"))
	Set<Atividade> atividades;

	@OneToOne(mappedBy = "servicoPrestado")
	private Ocorrencia ocorrencia;

	public ZonedDateTime getDataHoraInicio() {
		ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
		return dataHoraInicio.atZone(zoneId);
	}

	public void setDataHoraInicio(ZonedDateTime dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio.toLocalDateTime();
	}

	public ZonedDateTime getDataHoraFim() {
		ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
		return dataHoraFim.atZone(zoneId);
	}

	public void setDataHoraFim(ZonedDateTime dataHoraFim) {
		this.dataHoraFim = dataHoraFim.toLocalDateTime();
	}
}
