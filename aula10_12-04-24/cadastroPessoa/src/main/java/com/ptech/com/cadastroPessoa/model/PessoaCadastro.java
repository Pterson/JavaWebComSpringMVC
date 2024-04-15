package com.ptech.com.cadastroPessoa.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class PessoaCadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Informa que vai gerar automático
    private long id;
    private static String nome; //colocar STATIC
    private String email;
    private String cpf;

    public static String getNome() {
        return nome;
    }
    public static void setNome(String nome) {
        PessoaCadastro.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
