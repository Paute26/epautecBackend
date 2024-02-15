package ec.edu.ups.ppw63.epautec.business;

import java.util.List;

import ec.edu.ups.ppw63.epautec.dao.DetalleFacturaDAO;
import ec.edu.ups.ppw63.epautec.model.DetalleFactura;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionDetalleFacturas {
	
	@Inject
	private DetalleFacturaDAO daoDetalleFactura;
	
	public void guardarDetalleFactura(DetalleFactura detalleFactura) {
		DetalleFactura detalle = daoDetalleFactura.read(detalleFactura.getId());
		if(detalle != null) {
			daoDetalleFactura.update(detalleFactura);
		} else {
			daoDetalleFactura.insert(detalleFactura); 
		}
	}
	
	public void actualizarDetalleFactura(DetalleFactura detalleFactura) throws Exception {
		DetalleFactura detalle = daoDetalleFactura.read(detalleFactura.getId());
		if (detalle != null){
			daoDetalleFactura.update(detalleFactura);
		}else {
			throw new Exception("Detalle de factura no existe");
		}
	}
	
	public DetalleFactura buscarDetalleFactura(int id) throws Exception {
		if(id <= 0) 
			throw new Exception("ID inválido");
		return daoDetalleFactura.read(id);
	}
	
	public void borrarDetalleFactura(int id) {
		daoDetalleFactura.remove(id); 
	}
	
	public List<DetalleFactura> listarDetalleFacturas() {
		return daoDetalleFactura.getAll();
	}
	public List<DetalleFactura> listarDetalleFacturasPorEncabezado(int idEncabezado) {
	    // Implementa la lógica para listar los detalles de factura por el ID del encabezado aquí
	    return daoDetalleFactura.getByEncabezadoId(idEncabezado);
	}


}
