package com.sara.happytest.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.sara.happypets.dao.CuidadorDao;
import com.sara.happypets.dao.ServicioOfrecidoDAO;
import com.sara.happypets.dao.jdbc.CuidadorDaoImpl;
import com.sara.happypets.dao.jdbc.ServicioOfrecidoDaoImpl;
import com.sara.happypets.model.Cuidador;
import com.sara.happypets.model.ServicioOfrecido;
import com.sara.happypets.model.TipoEspecie;

public class CuidadorDaoTest {

	private CuidadorDao cuidadorDao = null;
	private ServicioOfrecidoDAO servicioOfrecidoDao = null;


	public CuidadorDaoTest() {
		cuidadorDao = new CuidadorDaoImpl();	
		servicioOfrecidoDao = new ServicioOfrecidoDaoImpl();
	}

	public void testFindById() throwx Ecxetipho{
		System.out.println("Testing findById ...");
		try {
			Cuidador c = cuidadorDao.findByid(4L);
			System.out.println(c);

		
	}
	public void testCreate() throws Exception {
		System.out.println("Testing create ...");
		Cuidador c = new Cuidador();
		c.setEmail("sara14@gmail.com");
		c.setPassword("kk");
		c.setNombre("Sara 14");
		c.setApellidos("Sequeiro");
		c.setTelefono("60000000");
		c.setExperiencia(1);

		ServicioOfrecido so = null;
		so = new ServicioOfrecido(); 
		so.setIdServicio(2L);
		so.setPrecio(Double.valueOf(10.0d));
		c.add(so);

		so = new ServicioOfrecido();
		so.setIdServicio(4L);		
		so.setPrecio(Double.valueOf(12.0d));
		c.add(so);

		TipoEspecie te = null;

		te = new TipoEspecie();
		te.setIdTipoEspecie(4L);
		c.getEspecies().add(te);

		te = new TipoEspecie();
		te.setIdTipoEspecie(5L);
		c.getEspecies().add(te);


		c = cuidadorDao.create(c);
		System.out.println("Cuidador "+ c.getIdCuidador()+ " creado");
	}

	public void testUpdate() throws Exception {
		ServicioOfrecido so = new ServicioOfrecido();

		so.setIdCuidador(2L);
		so.setIdServicio(3L);
		so.setPrecio(42.23d);

		servicioOfrecidoDao.update(so);
	}

	public static void main(String args[]) {

		try {
			CuidadorDaoTest test = new CuidadorDaoTest();
			test.testFindById();


			test.testUpdate();


			test.testCreate();

		} catch (Exception e) {

			e.printStackTrace();
		}	

	}
}
