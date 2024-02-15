package ec.edu.ups.ppw63.epautec.dao;

import java.util.List;

import ec.edu.ups.ppw63.epautec.model.Producto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ProductoDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Producto producto) {
        em.persist(producto);
    }

    public void update(Producto producto) {
        em.merge(producto);
    }

    public void remove(int id) {
        Producto producto = em.find(Producto.class, id);
        if (producto != null) {
            em.remove(producto);
        }
    }

    public Producto read(int id) {
        return em.find(Producto.class, id);
    }

    public List<Producto> getAll() {
        String jpql = "SELECT p FROM Producto p";
        Query q = em.createQuery(jpql, Producto.class);
        return q.getResultList();
    }
}
