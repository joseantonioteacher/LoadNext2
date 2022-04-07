package com.jal.training.dao;

import com.jal.training.model.Usuario;

public interface UsuarioDAO {

	public Usuario findById(Long id) throws Exception;
	public Usuario findByEmail(String email) throws Exception;
	
	public Long create(Usuario u) throws Exception;
	public void update(Usuario u) throws Exception;
	public boolean delete(Long id) throws Exception;
	
	
}

