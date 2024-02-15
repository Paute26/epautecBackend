package ec.edu.ups.ppw63.epautec.business;

import java.util.List;

import ec.edu.ups.ppw63.epautec.dao.ProductoDAO;
import ec.edu.ups.ppw63.epautec.dao.UsuarioDAO;
import ec.edu.ups.ppw63.epautec.model.Producto;
import ec.edu.ups.ppw63.epautec.model.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup

public class GestionDatos {
	
	@Inject
	private UsuarioDAO daoUsuario;
	@Inject
	private ProductoDAO daoProducto;
	
	@PostConstruct
	public void init() {
		System.out.println("### Iniciando ###");
		
		/*
		Usuario usuario = new Usuario();
		usuario.setCodigo(100);
		usuario.setNombre("Atlas");
		usuario.setCorreo("Test@correo.com");
		usuario.setPassword("123.321");
		
		daoUsuario.insert(usuario);
		*/
		System.out.println("###--PRODUCTOS--###");
		/*
		Producto producto = new Producto();
		producto.setId(100);
		producto.setNombre("Mouse");
		producto.setDescripcion("Gamer");
		producto.setPrecio("15");
		
		daoProducto.insert(producto);
		*/
		
		
		System.out.println("\n------------- Usuarios II");
		List<Usuario> list2 = daoUsuario.getAll();
		for (Usuario usu: list2) {
			System.out.println(usu);
		}
	}	
}
