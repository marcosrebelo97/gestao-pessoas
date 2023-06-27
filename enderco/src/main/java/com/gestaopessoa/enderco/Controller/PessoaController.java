package com.gestaopessoa.enderco.Controller;

import com.gestaopessoa.enderco.DTO.PessoaDTO;
import com.gestaopessoa.enderco.DTO.PessoaEnderecoDTO;
import com.gestaopessoa.enderco.Entities.Pessoa;
import com.gestaopessoa.enderco.Repository.PessoaRepository;
import com.gestaopessoa.enderco.Services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> listarPessoas() {
        List<PessoaDTO> pessoaDTOList = pessoaService.buscarPessoas();
        return ResponseEntity.ok().body(pessoaDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> buscarPessoasId(@PathVariable Long id){
        PessoaDTO pessoaDTO = pessoaService.buscarPessoaId(id);
        return ResponseEntity.ok().body(pessoaDTO);
    }

    @GetMapping(value = "/{id}/enderecos")
    public ResponseEntity<PessoaEnderecoDTO> listarEnderecosPessoa(@PathVariable Long id) {
        PessoaEnderecoDTO pessoaEnderecoDTO = pessoaService.pessoaEnderecoDTO(id);
        return ResponseEntity.ok().body(pessoaEnderecoDTO);

    }
}
