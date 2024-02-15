package ec.edu.ups.ppw63.epautec.services;

import java.util.List;

import ec.edu.ups.ppw63.epautec.business.GestionDetalleFacturas;
import ec.edu.ups.ppw63.epautec.model.DetalleFactura;
import ec.edu.ups.ppw63.epautec.model.EncabezadoFactura;
import ec.edu.ups.ppw63.epautec.services.ErrorMessage;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("detallefacturas")
public class DetalleFacturaServices {

    @Inject
    private GestionDetalleFacturas gestionDetalleFacturas;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(DetalleFactura detalleFactura) {
        try {
            gestionDetalleFacturas.guardarDetalleFactura(detalleFactura);
            ErrorMessage error = new ErrorMessage(1, "Ok");
            return Response.status(Response.Status.CREATED)
                    .entity(error).build();
        } catch (Exception e) {
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(error)
                    .build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(DetalleFactura detalleFactura) {
        try {
            gestionDetalleFacturas.actualizarDetalleFactura(detalleFactura);
            return Response.ok(detalleFactura).build();
        } catch (Exception e) {
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(error)
                    .build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String borrar(@QueryParam("id") int id) {
        try {
            gestionDetalleFacturas.borrarDetalleFactura(id);
            return "Ok";
        } catch (Exception e) {
            return "Error";
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarDetallesPorEncabezado(@QueryParam("idEncabezado") int idEncabezado) {
        try {
            List<DetalleFactura> detallesFactura = gestionDetalleFacturas.listarDetalleFacturasPorEncabezado(idEncabezado);
            return Response.ok(detallesFactura).build();
        } catch (Exception e) {
            ErrorMessage error = new ErrorMessage(4, "Error al obtener los detalles de factura");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(error)
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public Response listarDetalleFacturas() {
        List<DetalleFactura> detallesFactura = gestionDetalleFacturas.listarDetalleFacturas();
        if (detallesFactura.size() > 0)
            return Response.ok(detallesFactura).build();

        ErrorMessage error = new ErrorMessage(6, "No se registran detalles de factura");
        return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
    }
    
    @GET
    @Path("tamaño")
    public int obtenerTamañoDetalles() {
        List<DetalleFactura> detalles = gestionDetalleFacturas.listarDetalleFacturas();
        System.out.println(detalles.size());
        return detalles.size();
    }

}
