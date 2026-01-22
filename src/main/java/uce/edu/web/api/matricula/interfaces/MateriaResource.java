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
import jakarta.ws.rs.QueryParam;
import uce.edu.web.api.matricula.application.MateriaService;
import uce.edu.web.api.matricula.domain.Materia;

@Path("/Materias")
public class MateriaResource {

    @Inject
    private MateriaService materiaService;

    @GET
    @Path("")
    public List<Materia> ListarTodos() {
        return this.materiaService.ListarTodos();
    }

    @GET
    @Path("/{id}")
    public Materia consultarPorId(@PathParam("id") Integer iden) {
        return this.materiaService.consultarPorId(iden);
    }

    @POST
    @Path("")
    public void guardar(Materia mate) {
        this.materiaService.crear(mate);
    }

    @PUT
    @Path("/{id}")
    public void actualizar(@PathParam("id") Integer id, Materia mate) {
        this.materiaService.actualizar(id, mate);
    }

    @PATCH
    @Path("/{id}")
    public void actualizarParcial(@PathParam("id") Integer id, Materia mate) {
        this.materiaService.actualizarParcial(id, mate);
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
