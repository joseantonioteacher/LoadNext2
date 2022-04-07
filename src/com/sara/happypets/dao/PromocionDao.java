package com.sara.happypets.dao;

import java.util.Date;
import java.util.List;


import com.sara.happypets.model.Promocion;


public interface PromocionDao {
public Promocion findByid (Long idPromocion)throws Exception;
public Promocion findByidCliente (Long idCliente)throws Exception;
public Long create (Promocion p)throws Exception;
public void update (char idPromocion)throws Exception;
public boolean delete(char idPromocion)throws Exception;
public boolean deleteByIdCliente(Long idCliente)throws Exception;
}
