package com.jal.training.service.impl;

import com.jal.training.model.Usuario;
import com.jal.training.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioDAO dao = null;
	
	public UsuarioServiceImpl() {
		dao = new UsuarioDAOImpl();
	}

	@Override
	public Usuario login(String email, String password) {
		// 
	}
}
