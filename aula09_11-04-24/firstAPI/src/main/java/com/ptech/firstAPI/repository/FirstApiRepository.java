package com.ptech.firstAPI.repository;

import com.ptech.firstAPI.model.FirstApiPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstApiRepository extends CrudRepository<FirstApiPost, String> {

}
