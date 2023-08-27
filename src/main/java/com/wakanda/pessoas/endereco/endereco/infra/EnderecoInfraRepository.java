package com.wakanda.pessoas.endereco.endereco.infra;

import com.wakanda.pessoas.endereco.endereco.application.repository.EnderecoRepository;
import com.wakanda.pessoas.endereco.endereco.domain.Endereco;
import com.wakanda.pessoas.endereco.endereco.domain.enums.TipoEndereco;
import com.wakanda.pessoas.endereco.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EnderecoInfraRepository implements EnderecoRepository {
    private final EnderecoSpringDataJPARepository enderecoSpringDataJPARepository;

    @Override
    public Endereco salvaEndereco(Endereco endereco) {
        log.info("[inicia] EnderecoInfraRepository - salvaEndereco");
        try {
            enderecoSpringDataJPARepository.save(endereco);
        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST,
                    "Endereço com esse lagradouro, já foi cadastrado", e);
        }
        log.info("[finaliza] EnderecoInfraRepository - salvaEndereco");
        return endereco;
    }

    @Override
    public List<Endereco> listaEnderecosDaPessoa(UUID idPessoa) {
        log.info("[inicia] EnderecoInfraRepository - listaEnderecosDaPessoa");
        List<Endereco> enderecos = enderecoSpringDataJPARepository.findAll();
        log.info("[finaliza] EnderecoInfraRepository - listaEnderecosDaPessoa");
        return enderecos;
    }

    @Override
    public Endereco findEnderecoPrincipal(UUID idPessoa, TipoEndereco principal) {
        log.info("[inicia] EnderecoInfraRepository - findEnderecoPrincipal");
        Endereco endereco = enderecoSpringDataJPARepository.findByIdPessoaCadastroAndTipoEndereco(idPessoa, principal);
        log.info("[finaliza] EnderecoInfraRepository - findEnderecoPrincipal");
        return endereco;
    }
}
