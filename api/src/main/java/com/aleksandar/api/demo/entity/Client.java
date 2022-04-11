package com.aleksandar.api.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="client")
public class Client implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String email;
	private int number;
	
	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;

//	public Client(long id, String name, String lastName, String email, int number, Date createdAt) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.lastName = lastName;
//		this.email = email;
//		this.number = number;
//		this.createdAt = createdAt;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
