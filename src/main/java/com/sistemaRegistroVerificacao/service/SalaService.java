package com.sistemaRegistroVerificacao.service;

import java.util.List;

import com.sistemaRegistroVerificacao.exception.CampoInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sistemaRegistroVerificacao.model.entity.Sala;
import com.sistemaRegistroVerificacao.model.repository.SalaRepository;

public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public Sala inserir(Sala novaSala) throws CampoInvalidoException {
        validarCamposObrigatorios(novaSala);
        return salaRepository.save(novaSala);
    }

    public Sala atualizar(Sala salaParaAtualizar) throws CampoInvalidoException {
        validarCamposObrigatorios(salaParaAtualizar);
        return salaRepository.save(salaParaAtualizar);
    }

    private void validarCamposObrigatorios(Sala sala) throws CampoInvalidoException {
        String mensagemValidacao = "";
        mensagemValidacao += validarCampoString(sala.getNumero(), "numero");
        mensagemValidacao += validarCampoString(sala.getStatus(), "status");

        if (!mensagemValidacao.isEmpty()) {
            throw new CampoInvalidoException(mensagemValidacao);
        }
    }

    private String validarCampoString(String valorCampo, String nomeCampo) {
        if (valorCampo == null || valorCampo.trim().isEmpty()) {
            return "Informe o " + nomeCampo + " da sala\n";
        }
        return "";
    }

    public Sala consultarPorId(Integer id) {
        return salaRepository.findById(id).get();
    }

    @Transactional
    public List<Sala> listarTodas() {
        return salaRepository.findAll();
    }


    public boolean excluir(Integer id) {
        salaRepository.deleteById(id);
        return true;
    }
}
