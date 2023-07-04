package com.gestaopessoa.enderco.Services;

import com.gestaopessoa.enderco.DTO.EnderecoDTO;
import com.gestaopessoa.enderco.Entities.Pessoa;
import com.gestaopessoa.enderco.Repository.EnderecoRepository;
import com.gestaopessoa.enderco.Repository.PessoaRepository;
import com.gestaopessoa.enderco.Entities.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;




}
