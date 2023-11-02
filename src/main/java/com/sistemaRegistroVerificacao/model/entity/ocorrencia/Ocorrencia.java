package com.sistemaRegistroVerificacao.model.entity.ocorrencia;

import com.sistemaRegistroVerificacao.model.entity.servicoPrestado.ServicoPrestado;

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
@Table(name = "OCORRENCIA")
public class Ocorrencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "IDSERVICOPRESTADO")
	private ServicoPrestado idServicoPrestado;

}
