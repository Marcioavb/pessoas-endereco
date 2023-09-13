package com.wakanda.pessoas.endereco.endereco.application.service;

import com.wakanda.pessoas.endereco.endereco.application.api.EnderecoRequest;
import com.wakanda.pessoas.endereco.endereco.application.api.EnderecoResponse;
import com.wakanda.pessoas.endereco.endereco.application.api.ListaEnderecosResponse;

import java.util.List;
import java.util.UUID;

public interface EnderecoService {
    EnderecoResponse criaEndereco(UUID idPessoa, EnderecoRequest enderecoRequest);
    List<ListaEnderecosResponse> listaEnderecosDaPessoa(UUID idPessoa);
}
