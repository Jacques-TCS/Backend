package com.sistemaRegistroVerificacao.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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

@Entity
@Table(name = "servico_prestado_historico")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServicoPrestadoHistorico {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Column(name = "de")
    private char de;

    @Column(name = "data_hora_alteracao")
	private LocalDateTime dataHoraAlteracao;

    @Column(name = "para")
    private char para;

    @ManyToOne
    @JoinColumn(name = "id_servico_prestado", referencedColumnName = "id")
    private ServicoPrestado servicoPrestado;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario atualizadoPor;
}
