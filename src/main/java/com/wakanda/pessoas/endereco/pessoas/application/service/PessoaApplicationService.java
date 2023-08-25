package com.wakanda.pessoas.endereco.pessoas.application.service;

import com.wakanda.pessoas.endereco.endereco.application.repository.EnderecoRepository;
import com.wakanda.pessoas.endereco.endereco.domain.Endereco;
import com.wakanda.pessoas.endereco.endereco.domain.enums.TipoEndereco;
import com.wakanda.pessoas.endereco.pessoas.application.api.*;
import com.wakanda.pessoas.endereco.pessoas.application.repository.PessoaRepository;
import com.wakanda.pessoas.endereco.pessoas.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;

    @Override
    public PessoaResponse criaPessoa(PessoaRequest pessoaRequest) {
        log.info("[inicia] PessoaApplicationService - criaPessoa");
        Pessoa pessoa = pessoaRepository.salva(new Pessoa(pessoaRequest));
        log.info("[finaliza] PessoaApplicationService - criaPessoa");
        return PessoaResponse.builder()
                .idPessoa(pessoa.getIdPessoa())
                .build();
    }

    @Override
    public List<ListaPessoasResponse> listaPessoas() {
        log.info("[inicia] PessoaApplicationService - listaPessoas");
        List<Pessoa> pessoas = pessoaRepository.listaPessoas();
        log.info("[finaliza] PessoaApplicationService - listaPessoas");
        return ListaPessoasResponse.converte(pessoas);
    }

    @Override
    public ConsultaPessoaResponse consultaPessoaAtravesId(UUID idPessoa) {
        log.info("[inicia] PessoaApplicationService - consultaPessoaAtravesId");
        Pessoa pessoa = pessoaRepository.consultaPessoaAtravezId(idPessoa);
        Endereco enderecoPrincipal = enderecoRepository.findEnderecoPrincipal(idPessoa, TipoEndereco.PRINCIPAL);
        log.info("[finaliza] PessoaApplicationService - consultaPessoaAtravesId");
        return new ConsultaPessoaResponse(pessoa, enderecoPrincipal);
    }

    @Override
    public void editaPessoa(UUID idPessoa, AlteraPessoaRequest alteraPessoaRequest) {
        log.info("[inicia] PessoaApplicationService - editaPessoa");
        Pessoa pessoa = pessoaRepository.consultaPessoaAtravezId(idPessoa);
        pessoa.altera(alteraPessoaRequest);
        pessoaRepository.salva(pessoa);
        log.info("[finaliza] PessoaApplicationService - editaPessoa");
    }
}
