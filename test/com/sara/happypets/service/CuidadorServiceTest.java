package com.sara.happypets.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sara.happypets.model.Cuidador;
import com.sara.happypets.model.TipoEspecie;
import com.sara.happypets.service.impl.CuidadorServiceImpl;


public class CuidadorServiceTest  {
	
	private CuidadorService cuidadorService = null;
	
	public CuidadorServiceTest() {
	}	
	
	@Before
	public void init() {
		cuidadorService = new CuidadorServiceImpl();
	}
	
	@Test
	public void testRegistrar() throws Exception {
		Cuidador c = new Cuidador();
		c.setEmail("sarasequeironeda97@gmail.com");
		c.setNombre("Sara");
		c.setApellidos("Sequeiro Neda");
		c.setPassword("1234");
		c.setTelefono("600000000");
		c.setExperiencia(2);
		List<TipoEspecie> especies = new ArrayList<TipoEspecie>();
		especies.add(new TipoEspecie(1L, null)); // tipoEspecieDAO.findById(1L)
		especies.add(new TipoEspecie(2L, null)); // no está bien, deberia venir de BD		
		c.setEspecies(especies);
		
		
		cuidadorService.registrar(c);
		
		
	}
	
	@Test
	public void testLogin() throws Exception {
		System.out.println("Testing login...");
		try {
			// Cuando el login no existe
			Cuidador c = cuidadorService.login("mecagoeneasdfasdflprofe@gmail.com", "1235");
			assertTrue(c==null);
		} catch (UserNotFoundException e) {
			System.out.println("User not found login test OK");
		} 

		try {
			// Cuando el usuario existe y la contraseña está mal 
			Cuidador c = cuidadorService.login("sara7@gmail.com", "asdfasd");
			System.out.println("Incorrect password login test FAILURE ");
			assertTrue(c==null);
		} catch (IncorrectPasswordException e) {
			System.out.println("Incorrect password login test OK");
		} 

		// Cuando el usuario y la password están bien
		Cuidador c = cuidadorService.login("sara7@gmail.com", "123asfd4");
		System.out.println("Login with valid data OK");
		assertTrue(c!=null);
	}
	

}
