package com.wakanda.pessoas.endereco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")

public class PessoasEnderecoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoasEnderecoApplication.class, args);
	}
}
