package com.sistemaRegistroVerificacao.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cargo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cargo {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Column()
    @NotEmpty(message = "É necessário informar o nome do cargo")
	private String nome;

    @ManyToOne()
    @JoinColumn(name = "id_nivel_acesso", referencedColumnName = "id", nullable = false)
    @NotNull(message = "É necessário informar o nível de acesso")
    private NivelAcesso nivelAcesso;
}
