package com.gestaopessoa.enderco.Repository;

import com.gestaopessoa.enderco.Entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{


}
