package com.sara.happypets.dao;

import java.util.List;

import com.sara.happypets.model.Cliente;
import com.sara.happypets.model.Direccion;
import com.sara.happypets.model.Promocion;

public interface ClienteDao {
public Cliente findByid(Long idCliente)throws Exception;
public Cliente findByEmail (String email)throws Exception;
public Long create (Cliente cl)throws Exception;
public Cliente update (Cliente cl)throws Exception;
public boolean delete (Long id)throws Exception;
}
