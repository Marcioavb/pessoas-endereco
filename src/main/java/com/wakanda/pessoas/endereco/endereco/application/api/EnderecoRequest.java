package com.wakanda.pessoas.endereco.endereco.application.api;

import com.wakanda.pessoas.endereco.endereco.domain.enums.TipoEndereco;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
public class EnderecoRequest {
    @NotBlank
    private String lagradouro;
    @NotBlank
    private String numero;
    @NotBlank
    private String cep;
    @NotBlank
    private String cidade;
    @NotNull
    private TipoEndereco tipoEndereco = TipoEndereco.PRINCIPAL;
}
