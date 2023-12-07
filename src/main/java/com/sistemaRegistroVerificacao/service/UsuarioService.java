package com.sistemaRegistroVerificacao.service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.exception.CampoInvalidoException;
import com.sistemaRegistroVerificacao.model.entity.Usuario;
import com.sistemaRegistroVerificacao.model.repository.UsuarioRepository;
import com.sistemaRegistroVerificacao.model.seletor.UsuarioSeletor;
import com.sistemaRegistroVerificacao.model.specification.UsuarioSpecification;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario inserir(Usuario novoUsuario) throws CampoInvalidoException {
		novoUsuario.setStatusUsuario("Ativo");
		novoUsuario.setDataContratacao(ZonedDateTime.now());
		validarCamposObrigatorios(novoUsuario);
		return usuarioRepository.save(novoUsuario);
	}

	public Usuario atualizar(Usuario usuarioParaAtualizar) throws CampoInvalidoException {
		validarCamposObrigatorios(usuarioParaAtualizar);
		return usuarioRepository.save(usuarioParaAtualizar);
	}

	public Usuario consultarPorId(Integer id) {
		return usuarioRepository.findById(id).get();
	}

	@Transactional
	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}

	public List<Usuario> listarComSeletor(UsuarioSeletor seletor) {
		Specification<Usuario> specification = UsuarioSpecification.comFiltros(seletor);
		return usuarioRepository.findAll(specification);
	}

	public List<String> listarCargos() {
		return List.of(Usuario.CARGO_FAXINA, Usuario.CARGO_ZELADORIA, Usuario.CARGO_TECNICO, Usuario.CARGO_RH,
				Usuario.CARGO_GERENTE);
	}

	public List<String> listarNiveis() {
		return List.of(Usuario.NIVEL_FUNCIONARIO, Usuario.NIVEL_RH, Usuario.NIVEL_GERENTE);
	}

	public List<String> listarStatus() {
		return List.of(Usuario.STATUS_ATIVO, Usuario.STATUS_AFASTADO, Usuario.STATUS_INATIVO);
	}

	private void validarCamposObrigatorios(Usuario usuario) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoNome(usuario.getNome(), "nome");
		mensagemValidacao += validarCampoString(usuario.getCpf(), "cpf");
		mensagemValidacao += validarCampoString(usuario.getTelefone(), "telefone");
		// Olhar em funcionarioController do projeto do semestre passado para saber
		// sobre a validação de Data
		mensagemValidacao += validarCampoData(usuario.getDataNascimento(), "data de nascimento");
		mensagemValidacao += validarCampoString(usuario.getCtps(), "ctps");

		if (!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCampoNome(String nome, String nomeCampo) {
		if (nome == null || nome.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		if (nome.length() <= 2) {
			return "O nome deve ter no mínimo duas letras \\n";
		}
		return "";
	}

	private String validarCampoData(LocalDate dataNascimento, String nomeCampo) {
		int anoNascimento = dataNascimento.getYear();
		int anoAtual = ZonedDateTime.now().getYear();

		if (anoAtual - anoNascimento < 18) {
			return "Temos uma politica de idade mínima de 18 anos";
		}
		if (anoAtual - anoNascimento > 70) {
			return "Temos uma politica de idade máxima de 70 anos";
		}
		return "";
	}

	private String validarCampoString(String valorCampo, String nomeCampo) {
		if (valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}
}
