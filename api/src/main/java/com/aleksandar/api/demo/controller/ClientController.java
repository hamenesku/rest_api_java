package com.aleksandar.api.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleksandar.api.demo.entity.Client;
import com.aleksandar.api.demo.service.ClientService;

@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@RequestMapping("/clients")
	public List<Client> showAll(){
		return service.showAll();	
	}
	
	@RequestMapping("/clients/{id}")
	public Client searchById (@PathVariable long id) {
		return service.searchPortId(id);
		
	}
	
	@PostMapping("/clients")
	public Client saveClient (@RequestBody Client client) {
		
		return service.saveClient(client);
	}
	
	@PutMapping("/client/{id}")
	public Client updateClient ( @RequestBody Client client,@PathVariable long id ) {
//		return service.saveClient(service.searchPortId(id));
		
		Client cl = service.searchPortId(id);
		cl.setCreatedAt(client.getCreatedAt());
		cl.setEmail(client.getEmail());
		cl.setLastName(client.getLastName());
		cl.setName(client.getName());
		cl.setNumber(client.getNumber());
		
		return service.saveClient(cl);
	}
	
	@DeleteMapping("/client/{id}")
	public Client deleteClient (@PathVariable long id) {
		
		return service.deleteClient(id);

	}

}
