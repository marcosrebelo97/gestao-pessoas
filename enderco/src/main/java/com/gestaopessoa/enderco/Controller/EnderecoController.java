package com.gestaopessoa.enderco.Controller;

import com.gestaopessoa.enderco.Services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnderecoController {

    @Autowired
    private PessoaService pessoaService;



}
