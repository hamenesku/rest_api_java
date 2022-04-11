package com.aleksandar.api.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
//	GET ERROR CONTROL
	@GetMapping("/client/{id}")
	public ResponseEntity<?> searchClient(@PathVariable long id) {
		
		Client client = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			client = service.searchPortId(id);
		} catch (Exception e) {
			response.put("Message", "Couldn't make db query");
			response.put("Error", e.getMessage()
//					.concat(": ")
//					.concat(e.getMostSpecificCause().getMessage()
							);
			
			return new ResponseEntity<Map<String, Object>>
				(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		if (client == null) {
			response.put("Message", "Client with ID: " + id + " don't exist");
			return new ResponseEntity<Map<String, Object>>
				(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Client>(client, HttpStatus.OK);
		
	}
	
	
// POST ERROR CONTROL
	@PostMapping("/client")
	public ResponseEntity<?> saveClients(@RequestBody Client client) {
		
		
		Client newClient = null;
		Map<String, Object> response = new HashMap<>();
				
		
		try {
			newClient = service.saveClient(client);
		} catch (DataAccessException e) {
			response.put("Message", "Couldn't make db insert");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String, Object>>
				(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "Client was created successfull");
		response.put("Client", newClient);
		
		return new ResponseEntity<Map<String, Object>>
			(response, HttpStatus.CREATED);
		
	}
	
	@RequestMapping("/clients")
	public List<Client> showAll(){
		return service.showAll();	
	}
	
	@RequestMapping("/clients/{id}")
	public Client searchById (@PathVariable long id) {
		return service.searchPortId(id);
		
	}
	
	@PostMapping("/client")
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
