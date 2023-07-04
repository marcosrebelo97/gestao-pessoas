package com.gestaopessoa.enderco.Services;

import com.gestaopessoa.enderco.DTO.EnderecoDTO;
import com.gestaopessoa.enderco.DTO.EnderecoPrincipalDTO;
import com.gestaopessoa.enderco.DTO.PessoaDTO;
import com.gestaopessoa.enderco.DTO.PessoaEnderecoDTO;
import com.gestaopessoa.enderco.Entities.Pessoa;
import com.gestaopessoa.enderco.Entities.Endereco;
import com.gestaopessoa.enderco.Repository.EnderecoRepository;
import com.gestaopessoa.enderco.Repository.PessoaRepository;
import com.gestaopessoa.enderco.projections.PessoaEnderecoPrincipalProjections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    public PessoaDTO buscarPessoaId(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        PessoaDTO pessoaDTO = new PessoaDTO(pessoa);
        return pessoaDTO;
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
            throw new IllegalArgumentException("Não encontrada");
        }

    }


 }
