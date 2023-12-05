package com.sistemaRegistroVerificacao.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
		novoUsuario.setDataContratacao(LocalDate.now());
		// tirarMascaras(novoUsuario);
		validarCamposObrigatorios(novoUsuario);
		return usuarioRepository.save(novoUsuario);
	}

	public Usuario atualizar(Usuario usuarioParaAtualizar) throws CampoInvalidoException {
		// tirarMascaras(usuarioParaAtualizar);
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

	// public Page<Usuario> listarComSeletor(UsuarioSeletor seletor) {
	// Specification<Usuario> specification =
	// UsuarioSpecification.comFiltros(seletor);

	// if (seletor.temPaginacao()) {
	// Pageable paginacao = PageRequest.of(seletor.getPagina(),
	// seletor.getLimite());
	// return (Page<Usuario>) usuarioRepository.findAll(specification, paginacao);
	// }

	// return (Page<Usuario>) usuarioRepository.findAll(specification);
	// }

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

//	private void tirarMascaras(Usuario usuario) {
//		System.out.println("CPF Original: " + usuario.getCpf());
//		String cpfSemMascara = usuario.getCpf().replaceAll("\\.", "").replace("-", "");
//		usuario.setCpf(cpfSemMascara);
//		System.out.println("CPF Sem Máscara: " + cpfSemMascara);
//
//		String telefoneSemMascara = usuario.getTelefone().replace("(", "").replace(")", "").replace(" ", "");
//		
//		usuario.setTelefone(telefoneSemMascara);
//		String ctpsSemMascara = usuario.getCtps().replace("\\/", "");
//		usuario.setCtps(ctpsSemMascara);
//	}

	private void validarCamposObrigatorios(Usuario usuario) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoNome(usuario.getNome(), "nome");
		mensagemValidacao += validarCampoString(usuario.getCpf(), "cpf");
		mensagemValidacao += validarCampoString(usuario.getTelefone(), "telefone");
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
		int anoAtual = LocalDateTime.now().getYear();

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
