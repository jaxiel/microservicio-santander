package mx.com.santander.service;

import java.util.List;

import mx.com.santander.model.entity.Producto;


public interface IProductoService {

	
	public Producto save(Producto producto);
	
	Producto findByMarca(String marca);
	
	public Producto findById(Long id);
	
	public List<Producto> findAll();

	public void deleteById(Long id);

	
}
