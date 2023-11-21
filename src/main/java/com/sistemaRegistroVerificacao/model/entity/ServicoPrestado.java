package com.sistemaRegistroVerificacao.model.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraFim;

	@ManyToOne
	@JoinColumn(name = "IDUSUARIO")
	private Usuario idUsuario;

	@ManyToMany
	@JoinTable(name = "ATIVIDADE_SERVICOPRESTADO", joinColumns = @JoinColumn(name = "IDSERVICOPRESTADO"), inverseJoinColumns = @JoinColumn(name = "IDATIVIDADE"))
	Set<Atividade> atividades;

	@ManyToMany
	@JoinTable(name = "OCORRENCIA_SERVICOPRESTADO", joinColumns = @JoinColumn(name = "IDSERVICOPRESTADO"), inverseJoinColumns = @JoinColumn(name = "IDOCORRENCIA"))
	Set<Ocorrencia> ocorrencias;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sala getIdSala() {
		return idSala;
	}

	public void setIdSala(Sala idSala) {
		this.idSala = idSala;
	}

	public LocalDateTime getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public LocalDateTime getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(LocalDateTime dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Set<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(Set<Atividade> atividades) {
		this.atividades = atividades;
	}

	public Set<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(Set<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

}
