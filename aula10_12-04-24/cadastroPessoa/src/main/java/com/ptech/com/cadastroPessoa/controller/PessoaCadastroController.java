package com.ptech.com.cadastroPessoa.controller;


import com.ptech.com.cadastroPessoa.exception.ResourceNotFoundException;
import com.ptech.com.cadastroPessoa.model.PessoaCadastro;
import com.ptech.com.cadastroPessoa.repository.PessoaCadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaCadastroController {

    @Autowired
    PessoaCadastroRepository pessoaCadastroRepository;
    @PostMapping("/enviarCadastroPessoa") // Mapeia o endpoint para cadastro de pessoa via POST
    public String cadastrarPessoa(@RequestBody PessoaCadastro pessoaCadastro) {
        pessoaCadastroRepository.save(pessoaCadastro);
        return "A pessoa " + pessoaCadastro.getNome() + " foi cadastrada";
    }
    @GetMapping("/exibirCadastroPessoa")
    public List<PessoaCadastro> exibirPessoa(){

        return pessoaCadastroRepository.findAll();
    }

    @GetMapping("/buscarCadastroPessoa/{id}")
    public ResponseEntity<PessoaCadastro> getUsersById(@PathVariable(value = "id") long pessoaId) // Método para buscar uma pessoa pelo ID
                 throws ResourceNotFoundException {
          PessoaCadastro pessoaCadastro = pessoaCadastroRepository // Busca a pessoa pelo ID utilizando o repositório
                 .findById(pessoaId) // Método para buscar pelo ID
                 .orElseThrow(() -> new ResourceNotFoundException("Não existe pessoa com o ID: " + pessoaId)); // Lança uma exceção caso a pessoa não seja encontrada
        return ResponseEntity.ok().body(pessoaCadastro); // Retorna a pessoa encontrada com status OK
        }

    @DeleteMapping("/excluirCadastroPessoa/{id}")
    public String excluirCadastroPessoa(@PathVariable(value = "id") long pessoaId)
                 throws ResourceNotFoundException {
          PessoaCadastro pessoaCadastro = pessoaCadastroRepository
                 .findById(pessoaId)
                 .orElseThrow(() -> new ResourceNotFoundException("Não existe pessoa com o ID: " + pessoaId));

          pessoaCadastroRepository.delete(pessoaCadastro);

        return "O usuário (a) " + pessoaCadastro.getNome() + " foi deletado com sucesso!";
    }

    @PutMapping("/atualizarCadastroPessoa/")
    public String atualizarCadastroPessoa(@RequestBody PessoaCadastro pessoaCadastroRequest)
                 throws ResourceNotFoundException {
        PessoaCadastro pessoaCadastro = pessoaCadastroRepository
                .findById(pessoaCadastroRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Não existe pessoa com o ID: " + pessoaCadastroRequest.getNome()));

          pessoaCadastroRepository.save(pessoaCadastroRequest);

        return pessoaCadastroRequest.getNome() + " foi atualizada com sucesso!";
    }


}
