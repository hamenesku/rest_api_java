package com.example.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.InterfazDAO;
import com.example.entity.Usuario;

@RestController
@RequestMapping("usuario")
public class UsuarioRest {
	@Autowired
	private InterfazDAO repository;
	
//	@RequestMapping(value="/get",method=RequestMethod.GET)
	@GetMapping
	public ResponseEntity<Usuario> crearODB() {
			Usuario usu = new Usuario();
			usu.setId(1);
			usu.setNombre("no1");
			usu.setEdad(12);
			usu.setApellido("ap1");
			return ResponseEntity.ok(usu);
	}

	@RequestMapping(value="/mayor28",method=RequestMethod.GET)
	public void verMayor28() {
		Iterable<Usuario> lista = getRepository().getMayor28();
		for (Usuario usu : lista) {
			System.out.println(usu.getNombre() + ": " + usu.getEdad());
		}
	}

	
	@GetMapping("/listarUno/{id2}")
	public Optional<Usuario> listarUno(@PathVariable("id2") Integer id2)  {
	    return repository.findById(id2);
	}
	
	@GetMapping("/guardarUsuario/{id}/{apellido}/{edad}/{nombre}")
	public void guardarUsuario(
			@PathVariable("id") Integer 		id, 
			@PathVariable("apellido") String	apellido, 
			@PathVariable("edad") Integer		edad, 
			@PathVariable("nombre") String		nombre)  {
		
		Usuario usu = new Usuario();
		usu.setId(id);
		usu.setApellido(apellido);
		usu.setEdad(edad);
		usu.setNombre(nombre);

		repository.save(usu);
	}
	
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView home() {
		System.out.println("Conectado");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		List<Usuario> lista = repository.findAll();
		modelAndView.addObject("miobjetoNombre", lista.get(0).getNombre());
		return modelAndView;
	}

	
//	@RequestMapping(value = "/home/addUser",method = RequestMethod.POST)
	@RequestMapping(value="/home/addUser", method=RequestMethod.POST)
	public void guardar(@RequestBody Usuario usu) {
		repository.save(usu);
	}
	
	@RequestMapping(value="/miweb",method=RequestMethod.GET)
	public ModelAndView index() {
		System.out.println("Conectado");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		List<Usuario> lista = repository.findAll();
		modelAndView.addObject("miobjetoNombre", lista.get(0).getNombre());
		return modelAndView;
	}

	public InterfazDAO getRepository() {
		return repository;
	}

	public void setRepository(InterfazDAO repository) {
		this.repository = repository;
	}
	



}
