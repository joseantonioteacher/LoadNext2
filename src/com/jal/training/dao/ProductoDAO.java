package com.jal.training.dao;

import java.util.List;

import com.jal.training.model.Producto;

public interface ProductoDAO {

	public Producto findById(int id) throws Exception;
	public List<Producto> findBy(Long idCategoria, 
								String nombre,								
								Double precioDesde, Double precioHasta)
								throws Exception;
	
	
}
