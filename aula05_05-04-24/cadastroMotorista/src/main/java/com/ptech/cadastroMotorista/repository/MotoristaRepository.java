package com.ptech.cadastroMotorista.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ptech.cadastroMotorista.model.Motorista;

@Repository
public interface MotoristaRepository extends CrudRepository<Motorista, String> {

	Motorista findById(long id);

}
