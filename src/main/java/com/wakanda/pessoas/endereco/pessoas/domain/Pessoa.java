package com.wakanda.pessoas.endereco.pessoas.domain;

import com.wakanda.pessoas.endereco.pessoas.application.api.AlteraPessoaRequest;
import com.wakanda.pessoas.endereco.pessoas.application.api.PessoaRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
    private UUID idPessoa;
    @NotBlank
    private String nomeCompleto;
    @NotNull
    private LocalDate dataNascimento;

    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public Pessoa(PessoaRequest pessoaRequest) {
        this.nomeCompleto = pessoaRequest.getNomeCompleto();
        this.dataNascimento = pessoaRequest.getDataNascimento();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }

    public void altera(AlteraPessoaRequest alteraPessoaRequest) {
        this.nomeCompleto = alteraPessoaRequest.getNomeCompleto();
        this.dataNascimento = alteraPessoaRequest.getDataNascimento();
        this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
    }
}
