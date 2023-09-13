package com.wakanda.pessoas.endereco.pessoas.application.api;

import com.wakanda.pessoas.endereco.pessoas.domain.Pessoa;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ListaPessoasResponse {
    private UUID idPessoa;
    private String nomeCompleto;
    private LocalDate dataNascimento;

    public static List<ListaPessoasResponse> converte(List<Pessoa> pessoas) {
        return pessoas.stream()
                .map(ListaPessoasResponse::new)
                .collect(Collectors.toList());
    }

    public ListaPessoasResponse(Pessoa pessoa) {
        this.idPessoa = pessoa.getIdPessoa();
        this.nomeCompleto = pessoa.getNomeCompleto();
        this.dataNascimento = pessoa.getDataNascimento();

    }
}
