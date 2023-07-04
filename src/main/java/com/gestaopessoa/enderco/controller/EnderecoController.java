package com.gestaopessoa.enderco.controller;

import com.gestaopessoa.enderco.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
