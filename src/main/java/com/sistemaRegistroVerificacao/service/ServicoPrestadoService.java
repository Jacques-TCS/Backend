package com.sistemaRegistroVerificacao.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.sistemaRegistroVerificacao.exception.CampoInvalidoException;
import com.sistemaRegistroVerificacao.model.entity.Atividade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.ServicoPrestado;
import com.sistemaRegistroVerificacao.model.repository.ServicoPrestadoRepository;
import com.sistemaRegistroVerificacao.model.seletor.ServicoPrestadoSeletor;
import com.sistemaRegistroVerificacao.model.specification.ServicoPrestadoSpecification;

@Service
public class ServicoPrestadoService {

	@Autowired
	private ServicoPrestadoRepository servicoPrestadoRepository;

	public ServicoPrestado inserir(ServicoPrestado novoServicoPrestado) throws CampoInvalidoException {
		novoServicoPrestado.setDataHoraInicio(LocalDateTime.now());
		validarCamposObrigatorios(novoServicoPrestado);
		return servicoPrestadoRepository.save(novoServicoPrestado);
	}

	private void validarCamposObrigatorios(ServicoPrestado servicoPrestado) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoData(servicoPrestado.getDataHoraInicio(), "data e hora inicio",
				servicoPrestado.getDataHoraFim(), "data e hora fim");
		mensagemValidacao += validarCampoList(servicoPrestado.getAtividades(), "atividades");

		if (!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCampoData(LocalDateTime dataHoraInicio, String nomeCampo, LocalDateTime dataHoraFim,
			String nomeCampoFim) {
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		int diaAtual = dataHoraAtual.getDayOfMonth();
		int diaInicio = dataHoraInicio.getDayOfMonth();
		int diaFim = dataHoraFim.getDayOfMonth();

		if (dataHoraInicio == null || dataHoraFim == null) {
			return "Informe as datas de inicio e fim do serviço\n";
		}
		// A data de inicio do serviço só pode ser o dia atual
		if (diaInicio != diaAtual) {
			return "A data do serviço deve ser o dia corrente";
		}
		if (diaFim != diaInicio) {
			return "O serviço deve ser iniciado e finalizado no mesmo dia \n";
		}
		return "";
	}

	private String validarCampoList(Set<Atividade> atividades, String nomeCampo) {
		if (atividades == null || atividades.isEmpty()) {
			return "Informe ao menos 1 atividade \n";
		}
		return "";
	}

	public ServicoPrestado consultarPorId(Integer id) {
		return servicoPrestadoRepository.findById(id).get();
	}

	@Transactional
	public List<ServicoPrestado> listarTodos() {
		return servicoPrestadoRepository.findAll();
	}

	public List<ServicoPrestado> listarComSeletor(ServicoPrestadoSeletor seletor) {
		Specification<ServicoPrestado> specification = ServicoPrestadoSpecification.comFiltros(seletor);
		return servicoPrestadoRepository.findAll(specification);
	}

	public boolean excluir(Integer id) {
		servicoPrestadoRepository.deleteById(id);
		return true;
	}
}
