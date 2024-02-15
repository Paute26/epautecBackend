package ec.edu.ups.ppw63.epautec.business;

import java.util.List;

import ec.edu.ups.ppw63.epautec.dao.UsuarioDAO;
import ec.edu.ups.ppw63.epautec.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionUsuarios {
	
	@Inject
	private UsuarioDAO daoUsuario;
	
	public void guardarUsuarios(Usuario user) {
		Usuario cli = daoUsuario.read(user.getCodigo());
		if(cli != null) {
			daoUsuario.update(user);
		} else {
			daoUsuario.insert(user); 
		}
	}
	
	public void actualizarUsuario(Usuario user) throws Exception {
		Usuario cli = daoUsuario.read(user.getCodigo());
		if (cli != null){
			daoUsuario.update(user);
		}else {
			throw new Exception("Usuario no existe");
		}
	}
	
	public Usuario getUsuarioPorMail(String mail) throws Exception {
		if(mail.length() < 0) 
			throw new Exception("Campo Vacio");
		return daoUsuario.getUsuarioPorMail(mail);
	}
	
	public Usuario getUsuarioByNombreAndPassword(String mail, String password) {
        return daoUsuario.getUsuarioByNombreAndPassword(mail, password);
    }
	
	public void borrarUsuario(int codigo) {
		daoUsuario.remove(codigo); 
	}
	
	public List<Usuario> getUsuarios() {
		return daoUsuario.getAll();
	}

}