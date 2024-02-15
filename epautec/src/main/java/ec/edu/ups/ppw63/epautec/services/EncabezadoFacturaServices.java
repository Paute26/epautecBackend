package ec.edu.ups.ppw63.epautec.services;

import java.util.List;

import ec.edu.ups.ppw63.epautec.business.GestionEncabezadoFacturas;
import ec.edu.ups.ppw63.epautec.model.EncabezadoFactura;
import ec.edu.ups.ppw63.epautec.model.Usuario;
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

@Path("Facturas")
public class EncabezadoFacturaServices {

    @Inject
    private GestionEncabezadoFacturas gestionEncabezadoFacturas;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(EncabezadoFactura encabezadoFactura) {
        try {
            gestionEncabezadoFacturas.guardarEncabezadoFactura(encabezadoFactura);
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
    public Response actualizar(EncabezadoFactura encabezadoFactura) {
        try {
            gestionEncabezadoFacturas.actualizarEncabezadoFactura(encabezadoFactura);
            return Response.ok(encabezadoFactura).build();
        } catch (Exception e) {
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(error)
                    .build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String borrar(@PathParam("id") int id) {
        try {
            gestionEncabezadoFacturas.borrarEncabezadoFactura(id);
            return "Ok";
        } catch (Exception e) {
            return "Error";
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public Response listarEncabezadosFactura() {
        List<EncabezadoFactura> encabezadosFactura = gestionEncabezadoFacturas.listarEncabezadosFactura();
        if (!encabezadosFactura.isEmpty())
            return Response.ok(encabezadosFactura).build();

        ErrorMessage error = new ErrorMessage(6, "No se registran encabezados de factura");
        return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
    }
    @GET
    @Path("tamaño")
    public int obtenerTamañoEcabezados() {
        List<EncabezadoFactura> encabezados = gestionEncabezadoFacturas.listarEncabezadosFactura();
        System.out.println(encabezados.size());
        return encabezados.size();
    }
}
