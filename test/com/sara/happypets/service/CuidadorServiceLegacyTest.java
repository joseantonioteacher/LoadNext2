package com.sara.happypets.service;

import java.util.ArrayList;
import java.util.List;

import com.sara.happypets.model.Cuidador;
import com.sara.happypets.model.TipoEspecie;
import com.sara.happypets.service.impl.CuidadorServiceImpl;

public class CuidadorServiceLegacyTest {

	private CuidadorService cuidadorService = null;
	
	public CuidadorServiceLegacyTest() {		
		cuidadorService = new CuidadorServiceImpl();
	}
	
	
	public void testRegistrar() {
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
		
		try {
			cuidadorService.registrar(c);
		} catch (DataException de) {
			de.printStackTrace();
		} catch (ServiceException se) {
			se.printStackTrace();
		}
		
	}
	
	public void testLogin() {
		System.out.println("Testing login...");
		try {
			// Cuando el login no existe
			Cuidador c = cuidadorService.login("mecagoenelprofe@gmail.com", "1235");
			System.out.println("User not found login test FAILURE ");
		} catch (UserNotFoundException e) {
			System.out.println("User not found login test OK");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("User not found login test FAILURE ");
		}

		try {
			// Cuando el usuario existe y la contraseña está mal 
			Cuidador c = cuidadorService.login("sara7@gmail.com", "asdfasd");
			System.out.println("Incorrect password login test FAILURE ");
		} catch (IncorrectPasswordException e) {
			System.out.println("Incorrect password login test OK");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Incorrect password test FAILURE ");
		}
		
		try {
			// Cuando el usuario y la password están bien
			Cuidador c = cuidadorService.login("sara7@gmail.com", "123asfd4");
			System.out.println("Login with valid data OK");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Login with valid data FAILURE");
		}
	}
	
	public static void main(String args[]) {
		CuidadorServiceLegacyTest test = new CuidadorServiceLegacyTest();
		//test.testLogin();
		test.testRegistrar();
	}
}
