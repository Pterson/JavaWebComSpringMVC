package com.ptech.com.cadastroPessoa.controller;

import com.ptech.com.cadastroPessoa.model.PessoaCadastro;
import com.ptech.com.cadastroPessoa.repository.PessoaCadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaCadastroController {

    @Autowired
    PessoaCadastroRepository pessoaCadastroRepository;

    @GetMapping("/recebeDadosApi")
    public String exibirMinhaApi() {

        return "Im Working Mister Peterson";
    }
    @PostMapping("/enviaDadosApi")
    public String enviarParaApi(@RequestBody PessoaCadastro pessoaCadastroPost) {

        pessoaCadastroRepository.save(pessoaCadastroPost);

        return "Ok, Mister Peterson, o usuário:" + pessoaCadastroPost.getNome() + " foi cadastrado";
    }

}
