package com.wakanda.pessoas.endereco.endereco.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/endereco")
public interface EnderecoAPI {

    @PostMapping(value = "/{idPessoa}")
    @ResponseStatus(code = HttpStatus.CREATED)
    EnderecoResponse criaEndereco(@PathVariable UUID idPessoa,
                                  @Valid @RequestBody EnderecoRequest enderecoRequest);
}
