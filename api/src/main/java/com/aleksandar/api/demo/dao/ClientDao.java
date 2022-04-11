package com.aleksandar.api.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aleksandar.api.demo.entity.Client;

@Repository
public interface ClientDao extends CrudRepository<Client, Long>{

}
