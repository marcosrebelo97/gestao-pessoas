package com.gestaopessoa.enderco.Repository;

import com.gestaopessoa.enderco.Entities.PessoaEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Long> {
}
