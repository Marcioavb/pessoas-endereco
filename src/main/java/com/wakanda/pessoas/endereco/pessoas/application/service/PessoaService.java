package com.wakanda.pessoas.endereco.pessoas.application.service;

import com.wakanda.pessoas.endereco.pessoas.application.api.*;

import java.util.List;
import java.util.UUID;

public interface PessoaService {
    PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
    List<ListaPessoasResponse> listaPessoas();
    ConsultaPessoaResponse consultaPessoaAtravesId(UUID idPessoa);
    void editaPessoa(UUID idPessoa, AlteraPessoaRequest alteraPessoaRequest);
}
