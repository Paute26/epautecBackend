package ec.edu.ups.ppw63.epautec.dao;

import java.util.List;

import ec.edu.ups.ppw63.epautec.model.EncabezadoFactura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class EncabezadoFacturaDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(EncabezadoFactura encabezadoFactura) {
        em.persist(encabezadoFactura);
    }

    public void update(EncabezadoFactura encabezadoFactura) {
        em.merge(encabezadoFactura);
    }

    public void remove(int id) {
        EncabezadoFactura encabezadoFactura = em.find(EncabezadoFactura.class, id);
        if (encabezadoFactura != null) {
            em.remove(encabezadoFactura);
        }
    }

    public EncabezadoFactura read(int id) {
        return em.find(EncabezadoFactura.class, id);
    }

    public List<EncabezadoFactura> getAll() {
        String jpql = "SELECT e FROM EncabezadoFactura e";
        Query q = em.createQuery(jpql, EncabezadoFactura.class);
        return q.getResultList();
    }
}