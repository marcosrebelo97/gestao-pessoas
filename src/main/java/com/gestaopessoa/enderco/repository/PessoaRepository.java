package com.gestaopessoa.enderco.repository;

import com.gestaopessoa.enderco.entities.Pessoa;
import com.gestaopessoa.enderco.projections.PessoaEnderecoPrincipalProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    @Query(nativeQuery = true, value = "SELECT tb_pessoa.nome, tb_pessoa.data_nascimento as dataNascimento, tb_endereco.cep, tb_endereco.cidade, tb_endereco.logradouro, tb_endereco.numero\n" +
            "FROM tb_endereco, tb_pessoa, tb_pessoa_endereco\n" +
            "WHERE \n" +
            "tb_pessoa_endereco.id_endereco = tb_endereco.id\n" +
            "AND tb_pessoa_endereco.id_pessoa = tb_pessoa.id\n" +
            "AND tb_pessoa.id = :pessoaId")
    PessoaEnderecoPrincipalProjections retornarConsulta(Long pessoaId);
}
