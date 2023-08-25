package com.wakanda.pessoas.endereco.pessoas.infra;

import com.wakanda.pessoas.endereco.pessoas.application.api.ListaPessoasResponse;
import com.wakanda.pessoas.endereco.pessoas.application.repository.PessoaRepository;
import com.wakanda.pessoas.endereco.pessoas.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

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


}
