package com.aleksandar.api.demo.service;

import java.util.List;

import com.aleksandar.api.demo.entity.Client;

public interface ClientService {

	public List<Client> showAll();

	public Client searchPortId (long id);
	
	public Client saveClient(Client client);
	
	public Client updateClient ( Client client );
	
	public Client deleteClient ( long id );

}
