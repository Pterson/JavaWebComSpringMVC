package com.ptech.com.cadastroPessoa.repository;

import com.ptech.com.cadastroPessoa.model.PessoaCadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PessoaCadastroRepository extends JpaRepository<PessoaCadastro, Long> {

}
