package com.sara.happypets.dao.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sara.happypets.service.DataException;
import com.sara.happypets.service.MailServiceTest;

public class JDBCUtils {

	private static Logger logger = LogManager.getLogger(JDBCUtils.class);
	
	public static final void close(ResultSet rs) {
		try {
			if (rs!=null) {
				rs.close();
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	public static final void close(Statement st) {
		try {
			if (st!=null) {
				st.close();
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	public static final void close(ResultSet rs, Statement st) {
		close(rs);
		close(st);
	}
	
	
	/**
	 * Cierra la conexion.
	 * 
	 * Metodo de cierre <b>para el caso de sentencias con autocommit = true</b>.
	 * 
	 * En caso de autocommit = false deber�a usarse: 
	 * {@link #closeConnection(Connection, Boolean)} 
	 * para que ejecute previamente commit() o rollback() 
	 * previamente al cierre.
	 * 
	 * @param connection Conexion a cerrar.

	 */
	public static void closeConnection(Connection connection)
			throws DataException {
		
		if (connection != null) {
			try {
				// Previene un mal uso 
				if (!connection.getAutoCommit()) {
					throw new DataException("Autocommit disabled. Commit or Rollback should be done explicitly.");
				}			
				
				connection.close();
			} catch (SQLException e) {
				throw new DataException(e);
			}
		}
	}
	
//	public static void disableAutoCommit(Connection connection)  
//		throws DataException {
//		try {
//			connection.setAutoCommit(false);
//		} catch (SQLException se) {
//			throw new DataException(se);
//		}
//	}
//	
	
	/**
	 * Metodo de finalizacion de transaccionn <b>para el caso de autocommit = false</b>
	 * y de cierre de conexion.
	 *  
	 * Ejecuta commit() o rollback() y a continuacion cierra la conexi�n.
	 *  
	 * @param connection Conexion a cerrar.
	 * @param commitOrRollback Si es true ejecuta commit() y en caso contrario ejecuta rollback().
	 */
	public static void closeConnection(Connection connection, boolean commitOrRollback)
			throws DataException {
		if (connection != null) {
			try {
				
				if (commitOrRollback) {
					connection.commit();
				} else {
					connection.rollback();                        
				}
			} catch (SQLException e) { 
				throw new DataException(e);
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new DataException(e);
				}
			}
		}
	}	
}
