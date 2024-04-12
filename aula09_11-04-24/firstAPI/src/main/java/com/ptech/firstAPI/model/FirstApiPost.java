package com.ptech.firstAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FirstApiPost {
    private String meuTexto;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Informa que vai gerar automatico
    private long id;

    public String getMeuTexto() {
        return meuTexto;
    }

    public void setMeuTexto(String meuTexto) {
        this.meuTexto = meuTexto;
    }

}