package com.wakanda.pessoas.endereco.endereco.application.service;

import com.wakanda.pessoas.endereco.endereco.application.api.EnderecoRequest;
import com.wakanda.pessoas.endereco.endereco.application.api.EnderecoResponse;

import java.util.UUID;

public interface EnderecoService {
    EnderecoResponse criaEndereco(UUID idPessoa, EnderecoRequest enderecoRequest);
}
