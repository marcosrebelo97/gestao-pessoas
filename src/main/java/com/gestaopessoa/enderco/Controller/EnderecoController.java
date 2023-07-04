package com.gestaopessoa.enderco.Controller;

import com.gestaopessoa.enderco.DTO.EnderecoDTO;
import com.gestaopessoa.enderco.Entities.Endereco;
import com.gestaopessoa.enderco.Services.EnderecoService;
import com.gestaopessoa.enderco.Services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    /*@PostMapping(value = "/cadastrarEndereco")
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody @Validated EnderecoDTO enderecoDTO){
        return new ResponseEntity<Endereco>(enderecoService.cadastrarEndereco(enderecoDTO), HttpStatus.CREATED);
    }*/


}
