package com.wakanda.pessoas.endereco.pessoas.application.api;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Value;
@Value
public class AlteraPessoaRequest {
    @NotBlank
    private String nomeCompleto;
    @NotNull
    private LocalDate dataNascimento;
}