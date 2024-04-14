package com.ptech.com.cadastroPessoa.repository;

import com.ptech.com.cadastroPessoa.model.PessoaCadastro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PessoaCadastroRepository extends CrudRepository<PessoaCadastro, String> {

}