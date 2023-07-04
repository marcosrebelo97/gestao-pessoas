package com.gestaopessoa.enderco.repository;

import com.gestaopessoa.enderco.entities.PessoaEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Long> {
}
