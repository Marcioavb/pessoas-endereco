package com.wakanda.pessoas.endereco.pessoas.application.api;

import com.wakanda.pessoas.endereco.pessoas.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Log4j2
@RestController
@RequiredArgsConstructor
public class PessoasController implements PessoasAPI {

    private final PessoaService pessoaService;

    @Override
    public PessoaResponse criaPessoa(PessoaRequest pessoaRequest) {
        log.info("[inicia] PessoaController - criaPessoa");
        PessoaResponse pessoaCriada = pessoaService.criaPessoa(pessoaRequest);
        log.info("[finaliza] PessoaController - criaPessoa");
        return pessoaCriada;
    }

    @Override
    public List<ListaPessoasResponse> listaPessoas() {
        log.info("[inicia] PessoaController - listarPessoas");
        List<ListaPessoasResponse> pessoas = pessoaService.listaPessoas();
        log.info("[finaliza] PessoaController - listarPessoas");
        return pessoas;
    }

    @Override
    public ConsultaPessoaResponse consultaPessoaAtravesId(UUID idPessoa) {
        log.info("[inicia] PessoaController - consultaPessoaAtravesId");
        log.info("[idPessoa] {}", idPessoa);
        ConsultaPessoaResponse cpnsultaPessoa = pessoaService.consultaPessoaAtravesId(idPessoa);
        log.info("[finaliza] PessoaController - consultaPessoaAtravesId");
        return cpnsultaPessoa;
    }

    @Override
    public void alteraPessoa(UUID idPessoa, AlteraPessoaRequest alteraPessoaRequest) {
        log.info("[inicia] PessoaController - editaPessoa");
        log.info("[idPessoa] {}", idPessoa);
        pessoaService.editaPessoa(idPessoa, alteraPessoaRequest);
        log.info("[finaliza] PessoaController - editaPessoa");

    }
}
