package com.sara.happypets.service;

import com.sara.happypets.model.Cuidador;

public interface CuidadorService {

	public Cuidador registrar(Cuidador c)
		throws DataException, ServiceException;

	/**
	 * Autentica un usuario email y password.
	 * @param email 
	 * @param password
	 * @return Usuario autenticado si email y passowrd son correctos.
	 * @throws UserNotFoundException Si no se encuentra el usuario.
	 * @throws IncorrectPasswordException Si la password no es correcta.
	 * @throws DataException Si se produce un error en el acceso a datos.
	 * @throws ServiceException En otro caso diferente.
	 */
	public Cuidador login(String email, String password)
			throws DataException, ServiceException;
	
}
