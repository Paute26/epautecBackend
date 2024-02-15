package ec.edu.ups.ppw63.epautec.dao;

import ec.edu.ups.ppw63.epautec.model.DetalleFactura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class DetalleFacturaDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(DetalleFactura detalleFactura) {
        em.persist(detalleFactura);
    }

    public void update(DetalleFactura detalleFactura) {
        em.merge(detalleFactura);
    }

    public void remove(int id) {
        DetalleFactura detalleFactura = em.find(DetalleFactura.class, id);
        if (detalleFactura != null) {
            em.remove(detalleFactura);
        }
    }

    public DetalleFactura read(int id) {
        return em.find(DetalleFactura.class, id);
    }

    public List<DetalleFactura> getAll() {
        String jpql = "SELECT d FROM DetalleFactura d";
        return em.createQuery(jpql, DetalleFactura.class).getResultList();
    }
    
    public List<DetalleFactura> getByEncabezadoId(int idEncabezado) {
        String jpql = "SELECT d FROM DetalleFactura d WHERE d.encabezadoFactura.id = :idEncabezado";
        TypedQuery<DetalleFactura> query = em.createQuery(jpql, DetalleFactura.class);
        query.setParameter("idEncabezado", idEncabezado);
        return query.getResultList();
    }
}

