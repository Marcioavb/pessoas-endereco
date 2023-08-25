package com.wakanda.pessoas.endereco.pessoas.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/pessoa")
public interface PessoasAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PessoaResponse criaPessoa(@Valid @RequestBody PessoaRequest pessoaRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ListaPessoasResponse> listaPessoas();

    @GetMapping(value = "/{idPessoa}")
    @ResponseStatus(code = HttpStatus.OK)
    ConsultaPessoaResponse consultaPessoaAtravesId(@PathVariable UUID idPessoa);

    @PatchMapping(value = "/{idPessoa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraPessoa(@PathVariable UUID idPessoa,
                      @Valid @RequestBody AlteraPessoaRequest alteraPessoaRequest);

}
