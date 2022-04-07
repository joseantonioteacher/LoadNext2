package com.sara.happypets.dao;

import java.util.List;

import com.sara.happypets.model.Contrato;

public interface ContratoDao {
	public Contrato findByid (Long idContrato)throws Exception;
	public List<Contrato> findByHistorialCuidador(Long idCuidador)throws Exception;
	public List<Contrato> findByHistorialCliente(Long idCliente)throws Exception;
	
	public Long create (Contrato c)throws Exception;
	public Contrato updateEstado(Long idContrato, char estado) throws Exception;
	public boolean delete (Long id)throws Exception;
	public boolean deleteByIdCliente(Long idCliente)throws Exception;
	public boolean deleteByIdCuidador(Long idCuidador)throws Exception;
	public boolean deleteByIdMascota(Long idMascota)throws Exception;
	public boolean deleteByIdServicio(Long idServicio)throws Exception;
	public boolean deleteByIdEstado(char idEstado)throws Exception;

}
