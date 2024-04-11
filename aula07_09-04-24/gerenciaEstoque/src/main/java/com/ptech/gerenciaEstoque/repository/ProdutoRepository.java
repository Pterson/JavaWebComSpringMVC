package com.ptech.gerenciaEstoque.repository;

import org.springframework.data.repository.CrudRepository;

import com.ptech.gerenciaEstoque.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, String>{
	
	Produto findById(long id);

}
