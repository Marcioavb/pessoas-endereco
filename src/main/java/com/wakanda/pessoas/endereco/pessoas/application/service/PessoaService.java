package com.wakanda.pessoas.endereco.pessoas.application.service;

import com.wakanda.pessoas.endereco.pessoas.application.api.ConsultaPessoaResponse;
import com.wakanda.pessoas.endereco.pessoas.application.api.ListaPessoasResponse;
import com.wakanda.pessoas.endereco.pessoas.application.api.PessoaRequest;
import com.wakanda.pessoas.endereco.pessoas.application.api.PessoaResponse;

import java.util.List;
import java.util.UUID;

public interface PessoaService {
    PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
    List<ListaPessoasResponse> listaPessoas();
    ConsultaPessoaResponse consultaPessoaAtravesId(UUID idPessoa);
}
