package com.wakanda.pessoas.endereco.pessoas.infra;

import com.wakanda.pessoas.endereco.pessoas.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaSpringDataJPARepository extends JpaRepository<Pessoa, UUID> {
}
