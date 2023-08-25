package com.wakanda.pessoas.endereco.endereco.infra;

import com.wakanda.pessoas.endereco.endereco.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoSpringDataJPARepository extends JpaRepository<Endereco, UUID> {
}
