package com.wakanda.pessoas.endereco.endereco.application.repository;

import com.wakanda.pessoas.endereco.endereco.domain.Endereco;
import com.wakanda.pessoas.endereco.endereco.domain.enums.TipoEndereco;

import java.util.List;
import java.util.UUID;

public interface EnderecoRepository {
    Endereco salvaEndereco(Endereco endereco);
    Endereco findEnderecoPrincipal(UUID idPessoa, TipoEndereco principal);
    List<Endereco> listaEnderecosDaPessoa(UUID idPessoa);
}
