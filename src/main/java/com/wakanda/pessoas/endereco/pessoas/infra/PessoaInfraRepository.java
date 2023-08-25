package com.wakanda.pessoas.endereco.pessoas.infra;

import com.wakanda.pessoas.endereco.handler.APIException;
import com.wakanda.pessoas.endereco.pessoas.application.api.ListaPessoasResponse;
import com.wakanda.pessoas.endereco.pessoas.application.repository.PessoaRepository;
import com.wakanda.pessoas.endereco.pessoas.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PessoaInfraRepository implements PessoaRepository {
    private final PessoaSpringDataJPARepository pessoaSpringDataJPARepository;

    @Override
    public Pessoa salva(Pessoa pessoa) {
        log.info("[inicia] PessoaInfraRepository - salva");
        pessoaSpringDataJPARepository.save(pessoa);
        log.info("[finaliza] PessoaInfraRepository - salva");
        return pessoa;
    }

    @Override
    public List<Pessoa> listaPessoas() {
        log.info("[inicia] PessoaInfraRepository - listaPessoas");
        List<Pessoa> todasPessoas = pessoaSpringDataJPARepository.findAll();
        log.info("[finaliza] PessoaInfraRepository - listaPessoas");
        return todasPessoas;
    }

    @Override
    public Pessoa consultaPessoaAtravezId(UUID idPessoa) {
        log.info("[inicia] PessoaInfraRepository - consultaPessoaAtravezId");
        Pessoa pessoa = pessoaSpringDataJPARepository.findById(idPessoa)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pessoa não encontrado"));
        log.info("[finaliza] PessoaInfraRepository - consultaPessoaAtravezId");
        return pessoa;
    }


}
