package mx.com.santander.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mx.com.santander.model.entity.Producto;
import mx.com.santander.service.IProductoService;




@RestController
@RequestMapping("/producto")
public class ProductoController {


	@Autowired
	private IProductoService productoService;
	
	
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {
		return productoService.save(producto);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editar(@RequestBody Producto producto, @PathVariable Long id) {
		Producto productoDb = productoService.findById(id);
		
		productoDb.setNombre(producto.getNombre());
		productoDb.setPrecio(producto.getPrecio());
		productoDb.setMarca(producto.getMarca());

		return productoService.save(productoDb);
	}
	

	@GetMapping("/ver/{marca}")
	public Producto detallePorMarca(@PathVariable String marca,HttpServletResponse response, HttpServletRequest request){
		// response.addHeader("ID_CLIENT_SESSION", "78965088");
		 Producto producto =  productoService.findByMarca(marca);;
			
			if(request.getHeader("ID_CLIENT_SESSION").toString().equals("78965088")) {
			 productoService.findByMarca(marca);
			 
		 }else {
		 System.out.println("Sesion no valida   "+request.getHeader("ID_CLIENT_SESSION"));
	
		 producto = new Producto();
		 }
		 return producto;
	}
	
	
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.findAll().stream().map(producto -> {
			
//			RequestHeader
		return producto;
		
		}).collect(Collectors.toList());
	}
	
//	
//	@GetMapping("/ver/{id}")
//	public Producto detalle(@PathVariable Long id){
//		Producto producto = productoService.findById(id);
//	
//		return producto;
//		
//	}
//	

//	
//	@DeleteMapping("/eliminar/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void eliminar(@PathVariable Long id) {
//		productoService.deleteById(id);
//	}
	
	
	
}
