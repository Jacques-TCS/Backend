package com.sistemaRegistroVerificacao.model.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
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
	private Sala sala;

	@Column(name = "DATAINICIO")
	private LocalDateTime dataHoraInicio;
	
	@Column(name = "DATAFIM")
	private LocalDateTime dataHoraFim;

	@ManyToOne
	@JoinColumn(name = "IDUSUARIO")
	private Usuario usuario;

	@ManyToMany
	@JoinTable(name = "ATIVIDADE_SERVICOPRESTADO", joinColumns = @JoinColumn(name = "IDSERVICOPRESTADO"), inverseJoinColumns = @JoinColumn(name = "IDATIVIDADE"))
	Set<Atividade> atividades;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "IDOCORRENCIA")
	private Ocorrencia ocorrencia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

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

	public Set<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(Set<Atividade> atividades) {
		this.atividades = atividades;
	}

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
}
