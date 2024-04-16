package com.ptech.com.cadastroPessoa.controller;

import com.ptech.com.cadastroPessoa.exception.ResourceNotFoundException;
import com.ptech.com.cadastroPessoa.model.PessoaCadastro;
import com.ptech.com.cadastroPessoa.repository.PessoaCadastroRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaControllerTest {

    @Mock
    private PessoaCadastroRepository pessoaCadastroRepository;

    @InjectMocks
    private PessoaCadastroController pessoaCadastroController;

    @Test
    public void buscarCadastroPessoaByIdTest_seExist() throws ResourceNotFoundException{

        long idTeste = 103;

        PessoaCadastro pessoaCadastroTest = new PessoaCadastro();
        pessoaCadastroTest.setNome("UsuarioTeste");
        pessoaCadastroTest.setEmail("UsuarioTeste@gmail.com");
        pessoaCadastroTest.setCpf("999.999.999-99");
        pessoaCadastroTest.setId(999);

        when(pessoaCadastroRepository.findById(idTeste)).thenReturn(Optional.of(pessoaCadastroTest));

        ResponseEntity<PessoaCadastro> response = pessoaCadastroController.getUsersById(idTeste);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(pessoaCadastroTest, response.getBody());

    }

    @Test
    public void buscarCadastroPessoaByIdTest_naoExist() throws ResourceNotFoundException{

        long idTeste = 999999;

        when(pessoaCadastroRepository.findById(idTeste)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            pessoaCadastroController.getUsersById(idTeste);
        });

        assertEquals("Não existe pessoa com o ID: " + idTeste, exception.getLocalizedMessage());

    }
}
