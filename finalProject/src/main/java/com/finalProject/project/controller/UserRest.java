package com.finalProject.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.finalProject.project.controller.staticObjects.LoginForm;
import com.finalProject.project.dao.RolesCRUDRepository;
import com.finalProject.project.dao.UsersCRUDRepository;
import com.finalProject.project.entity.Role;
import com.finalProject.project.entity.User;




@RestController
@RequestMapping("user")
public class UserRest {
	private RolesCRUDRepository rolesRepository;
	private UsersCRUDRepository userRepository;
	
	
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
//	public ResponseEntity<User> crearUser() {
	public void crearUser() {
			User usu = new User();
//			usu.setId(1);
			usu.setEnabled(1);
			usu.setPassword("testPass");
			usu.setUser("test");
			
			Role rol = new Role();
			rol.setId(3);
			
			usu.setRole(rol);

			//No guardo el rol para que no sobreescriba la tabla
//			rolesRepository.save(rol);
			
			userRepository.save(usu);		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/access", method = RequestMethod.POST)
//	public ModelAndView access(@RequestParam LoginForm usu) {
	public ModelAndView access(
			@RequestParam("user") String userName,
			@RequestParam("pass") String userPass) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		
		modelAndView.addObject("userName", userName);
		modelAndView.addObject("login", userRepository.getLogin(userName, userPass));
		System.out.println(userRepository.getLogin(userName, userPass));
		User usr = userRepository.getLogin(userName, userPass);
		
		if (usr != null) {
			System.out.println(usr.getId());
			
			modelAndView.setViewName("home");
		} else {
			return new ModelAndView("redirect:/myURL");
//			modelAndView.setViewName("login");
		}
//		System.out.println(usr.getId());;
		
		return modelAndView;
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
