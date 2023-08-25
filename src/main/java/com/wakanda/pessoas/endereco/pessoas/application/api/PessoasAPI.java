package com.wakanda.pessoas.endereco.pessoas.application.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/pessoa")
public interface PessoasAPI {

    PessoaResponse criaPessoa(@Valid @RequestBody PessoaRequest pessoaRequest);
}
