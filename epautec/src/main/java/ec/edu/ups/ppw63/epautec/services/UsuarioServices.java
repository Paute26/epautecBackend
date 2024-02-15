package ec.edu.ups.ppw63.epautec.services;

import java.util.List;

import ec.edu.ups.ppw63.epautec.business.GestionUsuarios;
import ec.edu.ups.ppw63.epautec.model.Usuario;
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

@Path("usuarios")
public class UsuarioServices {
	
	@Inject
	private GestionUsuarios gUsuarios;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Usuario user) {
		try {
			gUsuarios.guardarUsuarios(user);
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
	public Response actualizar(Usuario user) {
		try {
			gUsuarios.actualizarUsuario(user);
			return Response.ok(user).build();
		} catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String borrar(@QueryParam("id") int codigo) {
		try {
			gUsuarios.borrarUsuario(codigo);
			return "Ok";
		} catch (Exception e) {
			return "Error";
		}
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getClientes(){
		List<Usuario> users = gUsuarios.getUsuarios();
		if(users.size()>0)
			return Response.ok(users).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran users");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	/*ADicional*/
	@GET
    @Path("tamaño")
    public int obtenerTamañoUsuarios() {
        List<Usuario> usuarios = gUsuarios.getUsuarios();
        return usuarios.size();
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerUsuarioPorNombreYPassword(@QueryParam("correo") String mail, @QueryParam("password") String password) {
        try {
			System.out.println("Correo: " + mail+"|Pass:"+password);	
            Usuario usuario = gUsuarios.getUsuarioByNombreAndPassword(mail, password);
            if (usuario != null) {
                return Response.ok(usuario).build();
            } else {
                ErrorMessage error = new ErrorMessage(4, "Correo o contraseña incorrecto");
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(error)
                        .build();
            }
        } catch (Exception e) {
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(error)
                    .build();
        }
    }
	
	
	
}
