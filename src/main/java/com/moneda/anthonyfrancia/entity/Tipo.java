package com.moneda.anthonyfrancia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tipo")
@Data
@Getter
@Setter
public class Tipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombreMoneda;
	private Double tipoCambio;
	
   public Tipo(Integer id, String nombreMoneda, Double tipoCambio){
        this.id = id;
        this.nombreMoneda = nombreMoneda;
        this.tipoCambio = tipoCambio;
    }
}
