package com.wakanda.pessoas.endereco.pessoas.application.repository;

import com.wakanda.pessoas.endereco.pessoas.application.api.ListaPessoasResponse;
import com.wakanda.pessoas.endereco.pessoas.domain.Pessoa;

import java.util.List;
import java.util.UUID;

public interface PessoaRepository {
    Pessoa salva(Pessoa pessoa);

    List<Pessoa> listaPessoas();

    Pessoa consultaPessoaAtravezId(UUID idPessoa);
}
