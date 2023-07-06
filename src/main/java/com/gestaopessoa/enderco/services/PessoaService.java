package com.gestaopessoa.enderco.services;

import com.gestaopessoa.enderco.dto.EnderecoDTO;
import com.gestaopessoa.enderco.dto.EnderecoPrincipalDTO;
import com.gestaopessoa.enderco.dto.PessoaDTO;
import com.gestaopessoa.enderco.dto.PessoaEnderecoDTO;
import com.gestaopessoa.enderco.entities.Pessoa;
import com.gestaopessoa.enderco.entities.Endereco;
import com.gestaopessoa.enderco.exceptionhandler.ProductNotFoundException;
import com.gestaopessoa.enderco.repository.EnderecoRepository;
import com.gestaopessoa.enderco.repository.PessoaRepository;
import com.gestaopessoa.enderco.projections.PessoaEnderecoPrincipalProjections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public List<PessoaDTO> buscarPessoas() {
        return pessoaRepository.findAll().stream().map(pessoa -> new PessoaDTO(pessoa)).toList();
    }

    @Transactional(readOnly = true)
    public Pessoa buscarPessoaId(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        //PessoaDTO pessoaDTO = new PessoaDTO(pessoa);
        return pessoa.orElseThrow(() -> new ProductNotFoundException());
    }

    public PessoaEnderecoDTO pessoaEnderecoDTO(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        PessoaEnderecoDTO pessoaEnderecoDTO = new PessoaEnderecoDTO(pessoa);
        return pessoaEnderecoDTO;
    }

    @Transactional
    public Pessoa cadastrarPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa(pessoaDTO);
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public Pessoa editarPessoa(PessoaDTO pessoaDTO, Long id){
        Pessoa pessoa = pessoaRepository.findById(id).orElse(null);
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDataNascimento(pessoa.getDataNascimento());
        pessoaRepository.save(pessoa);
        return pessoa;
    }

    public EnderecoPrincipalDTO consultarEnderecoPrincipal(Long id){
        PessoaEnderecoPrincipalProjections consultar = pessoaRepository.retornarConsulta(id);
        return new EnderecoPrincipalDTO(consultar);
    }

    @Transactional
    public EnderecoDTO cadastrarEndereco(EnderecoDTO enderecoDTO){
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(enderecoDTO.getPessoa().getId());
        if(pessoaOptional.isPresent()){
            Pessoa pessoa = pessoaOptional.get();
            Endereco novoEndereco = new Endereco();
            novoEndereco.setCep(enderecoDTO.getCep());
            novoEndereco.setCidade(enderecoDTO.getCidade());
            novoEndereco.setLogradouro(enderecoDTO.getLogradouro());
            novoEndereco.setNumero(enderecoDTO.getNumero());

            enderecoRepository.save(novoEndereco);
            return enderecoDTO;
        }else{
            throw new IllegalArgumentException("Pessoa não encontrada");
        }

    }


 }
