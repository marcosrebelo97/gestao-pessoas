package com.gestaopessoa.enderco.Services;

import com.gestaopessoa.enderco.DTO.PessoaDTO;
import com.gestaopessoa.enderco.DTO.PessoaEnderecoDTO;
import com.gestaopessoa.enderco.Entities.Pessoa;
import com.gestaopessoa.enderco.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public List<PessoaDTO> buscarPessoas(){
        return pessoaRepository.findAll().stream().map(pessoa->new PessoaDTO(pessoa)).toList();
    }

    @Transactional(readOnly = true)
    public PessoaDTO buscarPessoaId(Long id){
        Pessoa pessoa = pessoaRepository.findById(id).get();
        PessoaDTO pessoaDTO = new PessoaDTO(pessoa);
        return pessoaDTO;
    }

    public PessoaEnderecoDTO pessoaEnderecoDTO(Long id){
        Pessoa pessoa = pessoaRepository.findById(id).get();
        PessoaEnderecoDTO pessoaEnderecoDTO = new PessoaEnderecoDTO(pessoa);
        return pessoaEnderecoDTO;
    }
}
