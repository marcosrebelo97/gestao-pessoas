package com.gestaopessoa.enderco.Services;

import com.gestaopessoa.enderco.DTO.EnderecoDTO;
import com.gestaopessoa.enderco.Repository.EnderecoRepository;
import com.gestaopessoa.enderco.Repository.PessoaRepository;
import com.gestaopessoa.enderco.Entities.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco cadastrarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco(enderecoDTO);
        return enderecoRepository.save(endereco);
    }


}
