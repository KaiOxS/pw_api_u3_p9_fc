package uce.edu.web.api.matricula.application;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.web.api.matricula.domain.Materia;
import uce.edu.web.api.matricula.infraestructure.MateriaRepository;

@ApplicationScoped
public class MateriaService {

    @Inject
    private MateriaRepository materiaRepository;

    public List<Materia> ListarTodos() {
        return this.materiaRepository.listAll();
    }

    public Materia consultarPorId(Integer id) {
        return this.materiaRepository.findById(id.longValue());
    }

    @Transactional
    public void crear(Materia mate) {
        this.materiaRepository.persist(mate);
    }

    @Transactional
    public void actualizar(Integer id, Materia mat) {
        Materia mate = this.consultarPorId(id);
        mate.setNombreMateria(mat.getNombreMateria());
        mate.setCodigo(mat.getCodigo());
        mate.setDescripcion(mat.getDescripcion());
        mate.setFechaCreada(mat.getFechaCreada());
    }

    @Transactional
    public void actualizarParcial(Integer id, Materia mat) {
        Materia mate = this.consultarPorId(id);

        if (mat.getNombreMateria() != null) {
            mate.setNombreMateria(mat.getNombreMateria());
        }

        if (mat.getCodigo() != null) {
            mate.setCodigo(mat.getCodigo());
        }

        if (mat.getDescripcion() != null) {
            mate.setDescripcion(mat.getDescripcion());
        }

        if (mat.getFechaCreada() != null) {
            mate.setFechaCreada(mat.getFechaCreada());
        }

    }

    @Transactional
    public void eliminar(Integer id) {
        this.materiaRepository.deleteById(id.longValue());
    }

    public List<Materia> buscarPorNombre(String nombre) {
        return this.materiaRepository
                .find("SELECT a FROM Materia a WHERE a.nombreMateria = ?1", nombre)
                .list();
    }

    public List<Materia> buscarPorCodigoMayor(Long codigoMinimo) {
        return this.materiaRepository
                .find("SELECT a FROM Materia a WHERE a.codigo > ?1", codigoMinimo)
                .list();
    }

}
