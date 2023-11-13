package com.moneda.anthonyfrancia;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneda.anthonyfrancia.entity.Moneda;
import com.moneda.anthonyfrancia.repository.MonedaRepository;

@Service
public class MonedaService {
	
	@Autowired
	private MonedaRepository monedaRepository;
	
	public Moneda insertar(Moneda moneda) {
		return monedaRepository.save(moneda);
	}
	
	public List<Moneda> listarTodo(){
		return monedaRepository.findAll();
	}
	
	public List<Map<String, ?>> listarInfoMontofinal(Moneda moneda){
		return monedaRepository.listarInfoMontofinal(moneda.getId());
	}
}
