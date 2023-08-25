package com.wakanda.pessoas.endereco.endereco.infra;

import com.wakanda.pessoas.endereco.endereco.domain.Endereco;
import com.wakanda.pessoas.endereco.endereco.domain.enums.TipoEndereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoSpringDataJPARepository extends JpaRepository<Endereco, UUID> {
    Endereco findByIdPessoaCadastroAndTipoEndereco(UUID idPessoa, TipoEndereco principal);
}
