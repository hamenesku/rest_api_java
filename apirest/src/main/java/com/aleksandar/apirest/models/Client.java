package com.aleksandar.apirest.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {

	private long id;
	private String name;
	private String lastName;
	private String email;
	private int number;
	private Date createdAt;
}
