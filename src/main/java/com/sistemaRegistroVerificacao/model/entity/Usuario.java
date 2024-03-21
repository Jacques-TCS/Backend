package com.sistemaRegistroVerificacao.model.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Estes @ reduzem o código pois eliminam todas as linhas de construtores e gets e sets
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "USUARIO")
public class Usuario implements UserDetails {
	public static final String STATUS_ATIVO = "Ativo";
	public static final String STATUS_INATIVO = "Inativo";
	public static final String STATUS_AFASTADO = "Afastado";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
    @NotNull(message = "É necessário informar o nome")	
	private String nome;
	
	@Column()
    @NotNull(message = "É necessário informar o CPF")	
	private String cpf;
	
	@Column()
    @NotNull(message = "É necessário informar o telefone")
	private String telefone;

	@Column(name = "data_nascimento")
    @NotNull(message = "É necessário informar a data de nascimento")
	private LocalDate dataNascimento;

	@Column()
    @NotEmpty(message = "É necessário informar o e-mail")
	private String email;

	@ManyToOne
	@JoinColumn(name = "id_cargo", referencedColumnName = "id")
	private Cargo cargo;

	@Column(name = "status")
    @NotNull(message = "É necessário informar o status")
	private String statusUsuario;

	@JsonBackReference
	@OneToMany(mappedBy = "usuario")
	private List<Afastamento> afastamentos;

	@Column(name = "data_desligamento")
	private LocalDate dataDesligamento;

	@Column(name = "data_contratacao")
    @NotNull(message = "É necessário informar a data de contratação")
	private LocalDate dataContratacao;

	@Column(length = 50)
    @NotNull(message = "É necessário informar o login")
    private String username;

	@Column()
    @NotNull(message = "É necessário informar a senha")
    private String password;

    @Override
    /*
     * Esse método retorna os perfis que o usuário possui.
     * Idealmente, a classe Usuario deveria ter um atributo do tipo Perfil (ENUM), 
	 * onde seriam descritos os possíveis perfis que um usuário pode possuir.
     */
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.cargo.getNome()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    /*
     * Esse método retorna apenas true porque não existe validação de usuário
     */
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    /*
     * Esse método retorna apenas true porque não existe validação de usuário
     */
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    /*
     * Esse método retorna apenas true porque não existe validação de usuário
     */
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    /*
     * Esse método retorna apenas true porque não existe validação de usuário ativo ou inativo
     */
    public boolean isEnabled() {
        return true;
    }
}
