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

import java.util.ArrayList;
import java.util.List;
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

    @Test
    public void exibirPessoaTest() throws ResourceNotFoundException{

        PessoaCadastro pessoaCadastroTest = new PessoaCadastro();

        pessoaCadastroTest.setNome("UsuarioTeste");
        pessoaCadastroTest.setEmail("UsuarioTeste@gmail.com");
        pessoaCadastroTest.setCpf("999.999.999-99");
        pessoaCadastroTest.setId(999);


        PessoaCadastro pessoaCadastroTest2 = new PessoaCadastro();

        pessoaCadastroTest2.setNome("UsuarioTeste2");
        pessoaCadastroTest2.setEmail("usuarioTeste2@gmail.com");
        pessoaCadastroTest2.setCpf("888.888.888-88");
        pessoaCadastroTest2.setId(888);


        List<PessoaCadastro> listaPessoas = new ArrayList<>();
        listaPessoas.add(pessoaCadastroTest);
        listaPessoas.add(pessoaCadastroTest2);

        when(pessoaCadastroRepository.findAll()).thenReturn(listaPessoas);

        List<PessoaCadastro> response = pessoaCadastroController.exibirPessoa();

        assertEquals(listaPessoas, response);

    }

    @Test
    public void excluirCadastroPessoaTest() throws ResourceNotFoundException{

        long idTeste = 999;

        PessoaCadastro pessoaCadastroTest = new PessoaCadastro();

        pessoaCadastroTest.setNome("UsuarioTeste");
        pessoaCadastroTest.setEmail("UsuarioTeste@gmail.com");
        pessoaCadastroTest.setCpf("999.999.999-99");
        pessoaCadastroTest.setId(999);

        when(pessoaCadastroRepository.findById(idTeste)).thenReturn(Optional.of(pessoaCadastroTest));

        String  response = pessoaCadastroController.excluirCadastroPessoa(idTeste);


        assertEquals("O usuário (a) UsuarioTeste foi deletado com sucesso!", response);

    }

    @Test
    public void atualizarCadastroPessoaTest_OK() throws ResourceNotFoundException{


        PessoaCadastro pessoaCadastroTest = new PessoaCadastro();

        pessoaCadastroTest.setId(999);
        pessoaCadastroTest.setNome("UsuarioTeste");
        pessoaCadastroTest.setEmail("UsuarioTeste@gmail.com");
        pessoaCadastroTest.setCpf("999.999.999-99");


        PessoaCadastro pessoaCadastroTest_Alterado = new PessoaCadastro();

        pessoaCadastroTest_Alterado.setId(999);
        pessoaCadastroTest_Alterado.setNome("UsuarioTeste_Alterado");
        pessoaCadastroTest_Alterado.setEmail("UsuarioTeste@gmail.com");
        pessoaCadastroTest_Alterado.setCpf("999.999.999-99");

        when(pessoaCadastroRepository.findById(pessoaCadastroTest_Alterado.getId())).thenReturn(Optional.of(pessoaCadastroTest));

        pessoaCadastroTest_Alterado.setNome("UsuarioTeste_Alterado");

        String response = pessoaCadastroController.atualizarCadastroPessoa(pessoaCadastroTest_Alterado);

        assertEquals("UsuarioTeste_Alterado foi atualizada com sucesso!", response);

    }


}

