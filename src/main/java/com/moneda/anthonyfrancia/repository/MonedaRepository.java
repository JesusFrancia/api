package com.moneda.anthonyfrancia.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moneda.anthonyfrancia.entity.Moneda;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Integer>{
	@Query(value = "select m.monto,(m.monto * d.tipo_cambio)monto_cambio,o.nombre_moneda origen,d.nombre_moneda destino,d.tipo_cambio "
			     + "from moneda m "
				 + "inner join tipo o "
				 + "on o.id = m.origen "
				 + "inner join tipo d "
				 + "on d.id = m.destino "
				 + "where m.id = :id_moneda", nativeQuery = true)
	List<Map<String, ?>> listarInfoMontofinal(Integer id_moneda);
	
}
