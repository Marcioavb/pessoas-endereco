package com.wakanda.pessoas.endereco.pessoas.application.service;

import com.wakanda.pessoas.endereco.pessoas.application.api.ListaPessoasResponse;
import com.wakanda.pessoas.endereco.pessoas.application.api.PessoaRequest;
import com.wakanda.pessoas.endereco.pessoas.application.api.PessoaResponse;
import com.wakanda.pessoas.endereco.pessoas.application.repository.PessoaRepository;
import com.wakanda.pessoas.endereco.pessoas.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService {

    private final PessoaRepository pessoaRepository;

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
}
