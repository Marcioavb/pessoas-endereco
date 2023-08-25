package com.wakanda.pessoas.endereco.pessoas.application.api;

import com.wakanda.pessoas.endereco.pessoas.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}
