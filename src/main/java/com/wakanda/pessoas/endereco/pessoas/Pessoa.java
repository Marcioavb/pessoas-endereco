package com.wakanda.pessoas.endereco.pessoas;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
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

    public Pessoa(String nomeCompleto, LocalDate dataNascimento) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.dataHoraDoCadastro = LocalDateTime.now();
    }
}
