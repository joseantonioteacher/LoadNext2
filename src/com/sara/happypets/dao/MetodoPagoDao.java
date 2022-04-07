package com.sara.happypets.dao;

import java.util.List;

import com.sara.happypets.model.MetodoPago;

public interface MetodoPagoDao {
public MetodoPago findByid(Long idCuentaBancaria);
public  MetodoPago findByidPropietario (Long idCuidador, Long idCliente);
}
