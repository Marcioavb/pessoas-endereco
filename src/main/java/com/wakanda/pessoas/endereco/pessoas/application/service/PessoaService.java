package com.wakanda.pessoas.endereco.pessoas.application.service;

import com.wakanda.pessoas.endereco.pessoas.application.api.ListaPessoasResponse;
import com.wakanda.pessoas.endereco.pessoas.application.api.PessoaRequest;
import com.wakanda.pessoas.endereco.pessoas.application.api.PessoaResponse;

import java.util.List;

public interface PessoaService {
    PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
    List<ListaPessoasResponse> listaPessoas();
}
