package com.sistemaRegistroVerificacao.service.servicoPrestado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.servicoPrestado.ServicoPrestado;
import com.sistemaRegistroVerificacao.model.repository.servicoPrestado.ServicoPrestadoRepository;
import com.sistemaRegistroVerificacao.seletor.servicoPrestado.ServicoPrestadoSeletor;
import com.sistemaRegistroVerificacao.specification.servicoPrestado.ServicoPrestadoSpecification;

public class ServicoPrestadoService {

    @Autowired
    private ServicoPrestadoRepository servicoPrestadoRepository;

    public ServicoPrestado inserir(ServicoPrestado novoServicoPrestado) {
        return servicoPrestadoRepository.save(novoServicoPrestado);
    }

    public ServicoPrestado atualizar(ServicoPrestado servicoPrestadoParaAtualizar) {
        return servicoPrestadoRepository.save(servicoPrestadoParaAtualizar);
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
