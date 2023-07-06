package com.gestaopessoa.enderco.controller;

import com.gestaopessoa.enderco.dto.EnderecoDTO;
import com.gestaopessoa.enderco.dto.EnderecoPrincipalDTO;
import com.gestaopessoa.enderco.dto.PessoaDTO;
import com.gestaopessoa.enderco.dto.PessoaEnderecoDTO;
import com.gestaopessoa.enderco.entities.Pessoa;
import com.gestaopessoa.enderco.services.EnderecoService;
import com.gestaopessoa.enderco.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> listarPessoas() {
        List<PessoaDTO> pessoaDTOList = pessoaService.buscarPessoas();
        return ResponseEntity.ok().body(pessoaDTOList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> buscarPessoasId(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.buscarPessoaId(id);
        return ResponseEntity.ok().body(pessoa);
    }
    @GetMapping(value = "/{id}/enderecos")
    public ResponseEntity<PessoaEnderecoDTO> listarEnderecosPessoa(@PathVariable Long id) {
        PessoaEnderecoDTO pessoaEnderecoDTO = pessoaService.pessoaEnderecoDTO(id);
        return ResponseEntity.ok().body(pessoaEnderecoDTO);
    }
    @PostMapping
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody @Validated PessoaDTO pessoaDTO) {
        return new ResponseEntity<Pessoa>(pessoaService.cadastrarPessoa(pessoaDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pessoa> editarPessoa (@PathVariable Long id, @RequestBody @Validated PessoaDTO pessoaDTO){
        return new ResponseEntity<Pessoa>(pessoaService.editarPessoa(pessoaDTO, id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/endereco")
    public ResponseEntity<EnderecoPrincipalDTO> consultarEnderecoPrincipal(@PathVariable Long id){
        EnderecoPrincipalDTO enderecoPrincipalDTO = pessoaService.consultarEnderecoPrincipal(id);
        return ResponseEntity.ok().body(enderecoPrincipalDTO);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<EnderecoDTO> cadastrarEndereco(@PathVariable Pessoa id, @RequestBody EnderecoDTO enderecoDTO){
        try {
            enderecoDTO.setPessoa(id);
            EnderecoDTO enderecoCadastrado = pessoaService.cadastrarEndereco(enderecoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(enderecoCadastrado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
