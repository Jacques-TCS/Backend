package com.sistemaRegistroVerificacao.exception;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.TransientPropertyValueException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

/*
 * Essa classe funciona de modo a capturar todas as exceções lançadas que são do mesmo tipo 
 * das especificadas nos métodos abaixo. 
 * Ex: todas as exceções do tipo "ConstraintViolationException", "MethodArgumentNotValidException", etc.
 * 
 * Essas exceções geralmente são lançadas quando é utilizado a annotation @Valid, do pacote de validação do Spring,
 * ou quando uma nova exceção genérica é lançada através do "throw". 
 * 
 * Outros handlers de exceção podem ser criados e adicionados nessa classe. Mas deve-se ter cuidado ao fazer isso 
 * pois a partir do momento em que é adicionar um novo método de handler, todas as exceções do tipo especificado
 * passarão por essa classe.
 */
@ControllerAdvice
public class CustomExceptionHandler {
    
    /*
     * Esse exception handler funciona de maneira a pegar todas as exceções do tipo
     * "ConstraintViolationException". Essas exceções geralmente estão ligadas a
     * violações de chaves primárias, ou chaves estrangeiras em uma entidade.
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> onConstraintViolationException(ConstraintViolationException e) {
        Map<String, String> error = new HashMap<>();
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            error.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
        return error;
    }

    /*
     * Esse exception handler funciona de maneira a pegar todas as exceções do tipo
     * "MethodArgumentNotValidException". Essas exceções geralmente estão ligadas a 
     * atributos da entidade que não foram preenchidos, ou estão incorretos.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> error = new HashMap<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            error.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return error;
    }

    /*
     * Esse exception handler funciona de maneira a pegar todas as exceções do tipo
     * "TransientPropertyValueException". Essas exceções geralmente estão ligadas a 
     * entidades que possuem relações com outras entidades, onde essas entidades relacionadas
     * podem não ter sido preenchidos da maneira correta.
     */
    @ExceptionHandler(TransientPropertyValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> onTransientPropertyValueException(TransientPropertyValueException e) {
        Map<String, String> error = new HashMap<>();
        error.put("campo inválido", e.getPropertyName());
        return error;
    }

    /*
     * Esse exception handler funciona de maneira a pegar todas as exceções do tipo
     * "DataIntegrityViolationException".Essas exceções geralmente estão ligadas a 
     * entidades que possuem relações com outras entidades, onde essas entidades relacionadas
     * não existem.
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> onDataIntegrityViolationException(DataIntegrityViolationException e) {
        Map<String, String> error = new HashMap<>();
        error.put("mensagem", "Verifique as relações entre as entidades e tente novamente");
        error.put("error", "Violação de integridade do banco de dados");
        error.put("descrição", e.getCause().getMessage());
        return error;
    }

    /*
     * Esse exception handler funciona de maneira a pegar todas as exceções do tipo
     * "CampoInvalidoException".Essa exceção personalizada está ligada a regras de negócio, que nesse
     * caso se difere das exceções criadas acima, já que aquelas estão relacionadas ás validações dos modelos
     * ou inserções no banco de dados.
     */
    @ExceptionHandler(CampoInvalidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> onCampoInvalidoException(CampoInvalidoException e) {
        Map<String, String> error = new HashMap<>();
        error.put(e.getCampo(), e.getMensagemErro());
        return error;
    }

    /*
     * Esse exception handler funciona de maneira a pegar todas as exceções do tipo
     * "HttpMessageNotReadableException". Essas exceções geralmente estão ligadas a 
     * requisições inválidas a nível de criação de objetos, por exemplo, 
     * foi enviado um valor de string onde o código esperava receber um objeto.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> onHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        Map<String, String> error = new HashMap<>();
        error.put("mensagem", e.getMessage());
        error.put("error", "Requisição não legível");
        return error;
    }

    /*
     * Esse exception handler funciona de maneira a pegar todas as exceções do tipo
     * "JpaObjectRetrievalFailureException". Essas exceções geralmente estão ligadas a 
     * atualizações de objetos, onde o objeto possui uma chave estrangeira, mas ao processar a requisição
     * a chave estrangeira não representa nenhum registro no banco de dados.
     * Ex:
     *  {
     *      nome: usuário,
     *      perfil: {
     *          id: 8778            <-- nesse caso, se essa chave estrangeira não representasse
     *      }                           nenhum registro no banco, seria lançada uma 
     *  }                               "JpaObjectRetrievalFailureException"
     */
    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> onJpaObjectRetrievalFailureException(JpaObjectRetrievalFailureException e) {
        Map<String, String> error = new HashMap<>();
        error.put("mensagem", e.getCause().toString());
        error.put("error", "Requisição não legível");
        if (e.getCause() instanceof EntityNotFoundException) {
            error.put("mensagem", "Verifique as relações entre as entidades e tente novamente");
            error.put("error", "Entidade não encontrada");
            error.put("descrição", e.getCause().getMessage());
        }
        return error;
    }

}
