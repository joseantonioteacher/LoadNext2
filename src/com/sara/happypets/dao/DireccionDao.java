package com.sara.happypets.dao;

import java.util.List;


import com.sara.happypets.model.Direccion;
import com.sara.happypets.model.DireccionDTO;


public interface DireccionDao {
public Direccion findByid (Long idDireccion) throws Exception;
public Direccion findByDireccionDTO(DireccionDTO direccionDTO) throws Exception;
public Long create (Direccion dir)throws Exception; 
public Long update (Direccion dir)throws Exception; 
public boolean deleteByCliente(Long idCliente)throws Exception;
public boolean deleteByidCuidador(Long idCuidador)throws Exception;
}
