package com.moneda.anthonyfrancia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneda.anthonyfrancia.entity.Tipo;
import com.moneda.anthonyfrancia.repository.TipoRepository;

@Service
public class TipoService {
	
	@Autowired
	private TipoRepository tipoRepository;
	
	public Tipo insertar(Tipo tipo) {
		return tipoRepository.save(tipo);
	}
	
	public List<Tipo> listarTodo(){
		return tipoRepository.findAll();
	}
}
