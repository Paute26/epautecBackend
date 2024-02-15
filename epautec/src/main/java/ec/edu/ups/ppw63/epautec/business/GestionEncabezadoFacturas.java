package ec.edu.ups.ppw63.epautec.business;

import java.util.List;

import ec.edu.ups.ppw63.epautec.dao.EncabezadoFacturaDAO;
import ec.edu.ups.ppw63.epautec.model.EncabezadoFactura;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionEncabezadoFacturas {
    
    @Inject
    private EncabezadoFacturaDAO daoEncabezadoFactura;
    
    public void guardarEncabezadoFactura(EncabezadoFactura encabezadoFactura) {
        EncabezadoFactura encabezadoExistente = daoEncabezadoFactura.read(encabezadoFactura.getId());
        if (encabezadoExistente != null) {
            daoEncabezadoFactura.update(encabezadoFactura);
        } else {
            daoEncabezadoFactura.insert(encabezadoFactura);
        }
    }
    
    public void actualizarEncabezadoFactura(EncabezadoFactura encabezadoFactura) throws Exception {
        EncabezadoFactura encabezadoExistente = daoEncabezadoFactura.read(encabezadoFactura.getId());
        if (encabezadoExistente != null) {
            daoEncabezadoFactura.update(encabezadoFactura);
        } else {
            throw new Exception("El encabezado de factura no existe");
        }
    }
    
    public EncabezadoFactura buscarEncabezadoFactura(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID de encabezado de factura inválido");
        }
        return daoEncabezadoFactura.read(id);
    }
    
    public void borrarEncabezadoFactura(int id) {
        daoEncabezadoFactura.remove(id);
    }
    
    public List<EncabezadoFactura> listarEncabezadosFactura() {
        return daoEncabezadoFactura.getAll();
    }
}
