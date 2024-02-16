package ec.edu.ups.ppw63.epautec.services;

import java.util.List;

import ec.edu.ups.ppw63.epautec.business.GestionProductos;
import ec.edu.ups.ppw63.epautec.model.Producto;
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

@Path("productos")
public class ProductoServices {

    @Inject
    private GestionProductos gestionProductos;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Producto producto) {
        try {
            gestionProductos.guardarProducto(producto);
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
    public Response actualizar(Producto producto) {
        try {
            gestionProductos.actualizarProducto(producto);
            return Response.ok(producto).build();
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
            gestionProductos.borrarProducto(id);
            return "Ok";
        } catch (Exception e) {
            return "Error";
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarProductoPorNombre(@QueryParam("nombre") String nombre) {
        try {
            Producto producto = gestionProductos.getProductoPorNombre(nombre);
            return Response.ok(producto).build();
        } catch (Exception e) {
            ErrorMessage error = new ErrorMessage(4, "Producto no encontrado");
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(error)
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public Response listarProductos() {
        List<Producto> productos = gestionProductos.listarProductos();
        if (productos.size() > 0)
            return Response.ok(productos).build();

        ErrorMessage error = new ErrorMessage(6, "No se registran productos");
        return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
    }

}
