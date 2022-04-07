package com.sara.happypets.dao;

import java.util.List;

import com.sara.happypets.model.Experiencia;

public interface ExperienciaDao {
public Experiencia findByid(Integer idexperiencia)throws Exception;
public Integer findByidCuidador(Long idCuidador)throws Exception;
public boolean deleteByIdCuidador(Long idCuidador)throws Exception;
public Experiencia update (Experiencia exp)throws Exception;
}
