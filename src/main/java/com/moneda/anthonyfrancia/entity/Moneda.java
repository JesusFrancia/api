package com.moneda.anthonyfrancia.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="moneda")
@Data
public class Moneda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double monto;
	@ManyToOne
	@JoinColumn(name = "origen")
	private Tipo origen;
	@ManyToOne
	@JoinColumn(name = "destino")
	private Tipo destino;
}
