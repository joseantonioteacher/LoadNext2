package com.sara.happypets.service.impl;

import org.jasypt.util.password.StrongPasswordEncryptor;

import com.sara.happypets.model.Cuidador;
import com.sara.happypets.service.CuidadorService;
import com.sara.happypets.service.DataException;
import com.sara.happypets.service.IncorrectPasswordException;
import com.sara.happypets.service.ServiceException;
import com.sara.happypets.service.UserNotFoundException;

public class CuidadorServiceMockImpl 
	implements CuidadorService {

	//private static final String MOCK_ENCRYPTED_PASSWORD = 
	
	
	public CuidadorServiceMockImpl() {
		
	}
	@Override
	public Cuidador registrar(Cuidador c) throws DataException, ServiceException {
		return null;
	}

	@Override
	public Cuidador login(String email, String password) throws DataException, ServiceException {
		if (email==null) {
			throw new UserNotFoundException(null);
		} else if (!email.equalsIgnoreCase("sara7@gmail.com")) {
			throw new UserNotFoundException(email);			
		} else {
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			String encryptedPassword = passwordEncryptor.encryptPassword(password);
						
			if (!passwordEncryptor.checkPassword("1234", encryptedPassword)) {
				throw new IncorrectPasswordException();
			}
		}
		Cuidador c = new Cuidador();
		c.setEmail("sara7@gmail.com");
		c.setApellidos("Sequeiro");
		// ...
		return c;
	}

}
