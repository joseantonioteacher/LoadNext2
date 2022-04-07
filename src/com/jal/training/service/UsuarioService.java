package com.jal.training.service;

import com.jal.training.model.Usuario;

public interface UsuarioService {
	
	public Usuario login(String email, String password);

}
