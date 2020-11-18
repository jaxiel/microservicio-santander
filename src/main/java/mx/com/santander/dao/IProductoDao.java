package mx.com.santander.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mx.com.santander.model.entity.Producto;


public interface IProductoDao extends CrudRepository<Producto, Long> {


		public Producto findByMarca(@Param("marca") String marca);
		
		
	
}
