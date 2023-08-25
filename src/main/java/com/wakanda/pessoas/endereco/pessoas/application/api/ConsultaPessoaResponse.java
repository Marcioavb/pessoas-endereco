package com.wakanda.pessoas.endereco.pessoas.application.api;

import com.wakanda.pessoas.endereco.endereco.domain.Endereco;
import com.wakanda.pessoas.endereco.pessoas.domain.Pessoa;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class ConsultaPessoaResponse {

    private UUID idPessoa;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    //private Endereco enderecoPrincipal;

    public ConsultaPessoaResponse(Pessoa pessoa) {
        this.idPessoa = pessoa.getIdPessoa();
        this.nomeCompleto = pessoa.getNomeCompleto();
        this.dataNascimento = pessoa.getDataNascimento();
        //this.enderecoPrincipal = enderecoPrincipal;
    }

}
