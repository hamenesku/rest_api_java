package com.aleksandar.api.demo.service;

import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.aleksandar.api.demo.dao.ClientDao;
import com.aleksandar.api.demo.entity.Client;

@Service
public class ClientServiceImplement implements ClientService{

	@Autowired
	private ClientDao repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Client> showAll() {
		return (List<Client>) repository.findAll();
		
	}

	@Override
	@Transactional(readOnly = true)
	public Client searchPortId(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
//	@Transactional
	public Client saveClient(Client client) {
		return repository.save(client);
	}

	@Override
	public Client updateClient(Client client) {
		return repository.save(client);
	}

	@Override
	public Client deleteClient(long id) {
		Client deletedClient = searchPortId(id);
		repository.deleteById(id);
		
		return deletedClient;
	}
	
	
	
	

	
	
}
