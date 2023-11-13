package com.moneda.anthonyfrancia.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneda.anthonyfrancia.MonedaService;
import com.moneda.anthonyfrancia.TipoService;
import com.moneda.anthonyfrancia.entity.Moneda;
import com.moneda.anthonyfrancia.entity.Tipo;

@RestController
@RequestMapping("api/moneda")
public class apiController {
	
	@Autowired
	private MonedaService monedaService;
	
	@Autowired
	private TipoService tipoService;
	
	//@PostMapping("/insertarMonto")
	//public Moneda insertar(@RequestBody Moneda moneda) {
		//return monedaService.insertar(moneda);
	//}
	
	public Moneda insertar(Moneda moneda) {
		return monedaService.insertar(moneda);
	}
	
	@GetMapping("/listarTodoMonto")
	public List<Moneda> listarTodoMoneda(){
		return monedaService.listarTodo();
	}
	
	@PostMapping("/insertarMonto")
	public ResponseEntity<List<Map<String, ?>>> insertarMontoMoneda(@RequestBody Moneda moneda){
		Moneda moneda1 = insertar(moneda);
		List<Map<String, ?>> lista = monedaService.listarInfoMontofinal(moneda1);
		return new ResponseEntity<List<Map<String, ?>>>(lista, HttpStatus.OK);
	}
	
	//@PostMapping("/insertarTipo")
	//public Tipo insertarTipo(@RequestBody Tipo tipo) {
		//return tipoService.insertar(tipo);
	//}
	
	
	public Tipo insertarTipo2(Tipo tipo) {
		return tipoService.insertar(tipo);
	}
	
	@PostMapping("/insertarTipo")
	public List<Tipo> insertarTipo(@RequestBody List<Tipo> tipo) {
		
		List<Tipo> tipoLista = new ArrayList<>();
		
		for (Tipo lista : tipo) {
			Tipo tipoObj = new Tipo(lista.getId(),lista.getNombreMoneda(),lista.getTipoCambio());
			tipoLista.add(insertarTipo2(tipoObj));
		}
		
		return tipoLista;
	}
	
	@GetMapping("/listarTodoTipo")
	public List<Tipo> listarTodoTipo(){
		return tipoService.listarTodo();
	}
	
}
