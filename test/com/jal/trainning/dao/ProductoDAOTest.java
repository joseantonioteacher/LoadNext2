package com.jal.trainning.dao;

import java.util.List;

import com.jal.training.dao.ProductoDAO;
import com.jal.training.dao.jdbc.ProductoDAOImpl;
import com.jal.training.model.Producto;

public class ProductoDAOTest {
	private ProductoDAO productoDAO = null;
	
	
	public ProductoDAOTest() {
		productoDAO = new ProductoDAOImpl();
	}
	
	public  void testFindId() {
		try {
			Producto p = productoDAO.findById(1);
			if (p==null) {
				System.out.println("No encontrado :(");
			} else {
				System.out.println(p.getNombre()+" a "+p.getPrecio());
			}
		} catch (Exception e) {
			System.out.println("No se ha encontrado");
			e.printStackTrace();
			
		}
	}
	
	public void testFindBy() {
		try {
			List<Producto> results = productoDAO.findBy(185l, null, null, null);
			System.out.println("Encontrados "+results.size());
			for (Producto p: results) {
				System.out.println(p.getNombre()+": "+p.getPrecio()+"€");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static final void main(String args[]) {
		ProductoDAOTest test = new ProductoDAOTest();
		test.testFindId();
		
		test.testFindBy();
	}
}
