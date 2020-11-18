package mx.com.santander.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.santander.dao.IProductoDao;
import mx.com.santander.model.entity.Producto;
	
@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoDao productoDao;
	
	@Override
	@Transactional
	public Producto save(Producto producto) {
		
		return productoDao.save(producto);
	}


	@Override
	@Transactional (readOnly = true)
	public Producto findByMarca(String marca) {
		return productoDao.findByMarca(marca);
	}
	
	@Override
	@Transactional (readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional (readOnly = true)
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}


	@Override
	@Transactional
	public void deleteById(Long id) {
		productoDao.deleteById(id);
		
	}

}
