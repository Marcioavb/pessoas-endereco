package com.wakanda.pessoas.endereco.endereco.application.service;

import com.wakanda.pessoas.endereco.endereco.application.api.EnderecoRequest;
import com.wakanda.pessoas.endereco.endereco.application.api.EnderecoResponse;
import com.wakanda.pessoas.endereco.endereco.application.repository.EnderecoRepository;
import com.wakanda.pessoas.endereco.endereco.domain.Endereco;
import com.wakanda.pessoas.endereco.pessoas.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class EnderecoApplicationService implements EnderecoService {
    private final PessoaService pessoaService;
    private final EnderecoRepository enderecoRepository;
    @Override
    public EnderecoResponse criaEndereco(UUID idPessoa, EnderecoRequest enderecoRequest) {
        log.info("[inicia] EnderecoApplicationService - criaEndereco");
        pessoaService.consultaPessoaAtravesId(idPessoa);
        Endereco endereco = enderecoRepository
                .salvaEndereco(new Endereco(idPessoa, enderecoRequest));
        log.info("[finaliza] EnderecoApplicationService - criaEndereco");
        return new EnderecoResponse(endereco.getIdEndereco());
    }
}
