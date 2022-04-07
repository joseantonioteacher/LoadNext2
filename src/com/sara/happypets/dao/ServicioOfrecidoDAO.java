package com.sara.happypets.dao;

import java.util.List;

import com.sara.happypets.model.ServicioOfrecido;

public interface ServicioOfrecidoDAO {
		public List<ServicioOfrecido> findByCuidador(Long idCuidador) ;
		public void create(ServicioOfrecido s) throws Exception;
		public boolean update(ServicioOfrecido s) throws Exception;
		public boolean deleteByIdCuidador(Long idCuidador)throws Exception; 
		//public boolean deleteByIdServicio(Long idServicio) throws Exception;
}
