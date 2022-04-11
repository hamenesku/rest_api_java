package com.example.demo.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario2 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "desabilitado")
    private Boolean desabilitado;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "usuario2")
    private Set<BlogPost> blogPosts = new HashSet<>(0);


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Boolean getDesabilitado() {
		return desabilitado;
	}

	public void setDesabilitado(Boolean desabilitado) {
		this.desabilitado = desabilitado;
	}

    // getters and setters

}

