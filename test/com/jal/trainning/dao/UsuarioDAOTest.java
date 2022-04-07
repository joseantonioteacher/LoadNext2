package com.jal.trainning.dao;

import com.jal.training.dao.UsuarioDAO;
import com.jal.training.dao.jdbc.UsuarioDAOImpl;
import com.jal.training.model.Usuario;

public class UsuarioDAOTest {
	
	private UsuarioDAO dao = null;
	
	public UsuarioDAOTest() {
		dao = new UsuarioDAOImpl();
	}

	public void testFindByEmail() {
		Usuario u = dao.findByEmail("alvaro@gmail.com");
		if (u!=null) {
			System.out.println("KK");
		}
	}
	
	
	public void testCreate() {
		Usuario u2 = new Usuario();
		u2.setEmail("lucas@gmail.com");
		u2.setNombre("Lucas");
		
		dao.create(u2);
		System.out.println("Usuario creado con id: "+u2.getId());
	}
	
	public static final void main(String args[]) {
		
		UsuarioDAOTest test = new UsuarioDAOTest();
		test.testFindByEmail();
		test.testCreate();
		
	}
}
