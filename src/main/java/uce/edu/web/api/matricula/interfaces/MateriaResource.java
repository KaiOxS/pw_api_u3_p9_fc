package uce.edu.web.api.matricula.interfaces;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.matricula.application.MateriaService;
import uce.edu.web.api.matricula.domain.Materia;

@Path("/Materias")
public class MateriaResource {

    @Inject
    private MateriaService materiaService;

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Materia> ListarTodos() {
        return this.materiaService.ListarTodos();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Materia consultarPorId(@PathParam("id") Integer iden) {
        return this.materiaService.consultarPorId(iden);
    }

    @POST
    @Path("")
    public Response guardar(Materia mate) {
        this.materiaService.crear(mate);
        return Response.status(Response.Status.CREATED).entity(mate).build();
    }

    @PUT
    @Path("/{id}")
    public void actualizar(@PathParam("id") Integer id, Materia mate) {
        this.materiaService.actualizar(id, mate);
    }

    @PATCH
    @Path("/{id}")
    public Response actualizarParcial(@PathParam("id") Integer id, Materia mate) {
        this.materiaService.actualizarParcial(id, mate);
        return Response.status(209).entity("Actualizado Parcialmente").build();
    }

    @DELETE
    @Path("/{id}")
    public void borrar(@PathParam("id") Integer id) {
        this.materiaService.eliminar(id);
    }

    @GET
    @Path("/nombre")
    public List<Materia> buscarPorNombre(@QueryParam("nombre") String nombre) {
        return this.materiaService.buscarPorNombre(nombre);
    }

    @GET
    @Path("/codigo")
    public List<Materia> buscarPorCodigoMayor(@PathParam("codigo") Long codigo) {
        return this.materiaService.buscarPorCodigoMayor(codigo);
    }

}
