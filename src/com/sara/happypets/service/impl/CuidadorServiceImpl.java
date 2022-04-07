package com.sara.happypets.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.jasypt.util.password.StrongPasswordEncryptor;

import com.sara.happypets.dao.CuidadorDao;
import com.sara.happypets.dao.jdbc.CuidadorDaoImpl;
import com.sara.happypets.dao.util.JDBCUtils;
import com.sara.happypets.model.Cuidador;
import com.sara.happypets.service.CuidadorService;
import com.sara.happypets.service.DataException;
import com.sara.happypets.service.IncorrectPasswordException;
import com.sara.happypets.service.MailService;
import com.sara.happypets.service.ServiceException;
import com.sara.happypets.service.UserNotFoundException;
import com.sara.happypets.util.DBUtils;

public class CuidadorServiceImpl implements CuidadorService {


	private static final StrongPasswordEncryptor ENCRYPTOR = new StrongPasswordEncryptor();

	private MailService mailService = null; 
	private CuidadorDao cuidadorDao = null;


	public CuidadorServiceImpl() {	
		cuidadorDao = new CuidadorDaoImpl();
		mailService = new MailServiceImpl();
	}

	@Override
	public Cuidador registrar(Cuidador cuidador) throws DataException, ServiceException {
		System.out.println("Registrando usuario "+cuidador.getEmail());

		String encryptedPassword = ENCRYPTOR.encryptPassword(cuidador.getPassword());
		cuidador.setPassword(encryptedPassword);

		Connection connection = DBUtils.getConnection();
		boolean commit = false;
		try {

			connection.setAutoCommit(false); 
			cuidador = cuidadorDao.create(connection, cuidador);
			System.out.println("Usuario creado");
			
			// Llamadas a otros datos...
			
			//
			mailService.sendEmail("Bienvenido a HappyPets", cuidador.getEmail(), "Vamos a ayudarte a cuidar a tus mascotas. ...");
			
			// Buff... si llego aqui, es que todo parece haber ido bien
			commit = true;			

			System.out.println("Usuario "+cuidador.getEmail()+" registrado");
		} catch (SQLException se) {
			se.printStackTrace();
			throw new DataException(se);
		} finally {
        	JDBCUtils.closeConnection(connection, commit);

		}
		return cuidador;
	}

	@Override
	public Cuidador login(String email, String password) throws UserNotFoundException, IncorrectPasswordException, DataException, ServiceException {
		Cuidador cuidador = null;// cuidadorDao.findByEmail(email);
		if (cuidador!=null) {
			// el cuidador no existe
			throw new UserNotFoundException(email);
		} else {
			// el cuidador existe			
			String encryptedPassword = ENCRYPTOR.encryptPassword(password);
			if (cuidador.getPassword().equals(encryptedPassword)) {
				return cuidador;				
			} else {
				throw new IncorrectPasswordException();
			}
		}		
	}

}
