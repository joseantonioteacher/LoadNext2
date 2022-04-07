package com.sara.happytest.dao;

import java.util.List;

import com.sara.happypets.dao.PuntuacionDao;
import com.sara.happypets.dao.jdbc.PuntuacionDaoImpl;
import com.sara.happypets.model.Puntuacion;

public class PuntuacionDaoTest {

	private PuntuacionDao dao = null;
	
	public PuntuacionDaoTest() {
		dao = new PuntuacionDaoImpl();
	}
	
	public void testFindByCliente() throws Exception  {
		
		List<Puntuacion> puntuaciones = dao.findByCliente(10L);
		for (Puntuacion p: puntuaciones) {
			System.out.println(p.getIdCuidador() + ": "+p.getPuntuacion()+" "+p.getComentario());
		}
	}
	
	
	
	public static void main(String[] args) {
		try {
			PuntuacionDaoTest test = new PuntuacionDaoTest();
			test.testFindByCliente();

			
			Long idCuidador = 4L;
			Double media = dao.findMediaCuidador(idCuidador);
			System.out.println("Media de "+idCuidador + " = "+media);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
