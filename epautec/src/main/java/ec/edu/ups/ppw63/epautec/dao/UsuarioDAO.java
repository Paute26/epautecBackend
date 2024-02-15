package ec.edu.ups.ppw63.epautec.dao;

import java.util.List;

import ec.edu.ups.ppw63.epautec.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Stateless
public class UsuarioDAO {
	

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Usuario usuario) {
		em.persist(usuario);
	}
	
	public void update(Usuario usuario) {
		em.merge(usuario);
	}
	
	public void remove(int codigo) {
		Usuario usuario = em.find(Usuario.class, codigo);
		em.refresh(usuario);
	}
	
	public Usuario read(int codigo) {
		Usuario usuario = em.find(Usuario.class, codigo);
		return usuario;
	}
	
	public List<Usuario> getAll(){
		String jpql = "SELECT u FROM Usuario u";
		Query q = em.createQuery(jpql, Usuario.class);
		return q.getResultList();
	}
	public Usuario getUsuarioPorMail(String mail) {
		String jpql = "SELECT u FROM Usuario u WHERE u.correo= :mail";
		Query q = em.createQuery(jpql, Usuario.class);
		q.setParameter("mail", mail);
		List<Usuario> user= q.getResultList();
		if(user.size()>0)
			return user.get(0);
		return null;
	}
	/*Adicion*/
	public Usuario getUsuarioByNombreAndPassword(String mail, String password) {
	    String jpql = "SELECT u FROM Usuario u WHERE u.correo = :correo AND u.password = :password";
	    Query q = em.createQuery(jpql, Usuario.class);
	    q.setParameter("correo", mail);
	    q.setParameter("password", password);
	    List<Usuario> usuarios = q.getResultList();
	    if(usuarios.size()>0)
			return usuarios.get(0);
		return null;
	}


}
