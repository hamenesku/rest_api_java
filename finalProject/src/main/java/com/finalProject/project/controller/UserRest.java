package com.finalProject.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finalProject.project.dao.RolesCRUDRepository;
import com.finalProject.project.dao.UsersCRUDRepository;
import com.finalProject.project.entity.Role;
import com.finalProject.project.entity.User;




@RestController
@RequestMapping("user")
public class UserRest {
	private RolesCRUDRepository rolesRepository;
	private UsersCRUDRepository userRepository;
	
	
//	@GetMapping
	@RequestMapping(value="/get",method=RequestMethod.GET)
//	public ResponseEntity<User> crearODB() {
	public void crearUser() {
			User usu = new User();
//			usu.setId(1);
			usu.setEnabled(1);
			usu.setPassword("testPass");
			usu.setUser("test");
			
			Role rol = new Role();
			
//			rol.setId(1);
//			rol.setRol("Administrador");
			usu.setRole(rol);
			
			rolesRepository.save(rol);
			userRepository.save(usu);
			
			
			System.out.println(usu);
//			return ResponseEntity.ok(usu);
	}

	public UsersCRUDRepository getRepository() {
		return userRepository;
	}

	@Autowired
	public void setRepository(UsersCRUDRepository repository) {
		this.userRepository = repository;
	}

	public RolesCRUDRepository getRolesRepository() {
		return rolesRepository;
	}
	
	@Autowired
	public void setRolesRepository(RolesCRUDRepository rolesRepository) {
		this.rolesRepository = rolesRepository;
	}
}