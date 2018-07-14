/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.service;

import ec.edu.espe.arquitectura.aula.model.EntregaTarea;
import ec.edu.espe.arquitectura.nosql.mongo.MongoPersistence;
import es.edu.espe.arquitectura.aula.dao.EntregaTareaDAO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author js_cm
 */
@Stateless
@LocalBean
public class EntregaTareaService {

    @EJB
    private MongoPersistence mp;
    private EntregaTareaDAO EntregaTareaDao;

    @PostConstruct
    public void init() {
        this.EntregaTareaDao = new EntregaTareaDAO(EntregaTarea.class, mp.context());
    }

    public List<EntregaTarea> obtenerTodos() {
        return this.EntregaTareaDao.find().asList();
    }

    public List<EntregaTarea> obtenerPorCursoTarea(String curso, Integer tarea) {
        return this.EntregaTareaDao.findbyCursoTarea(curso, tarea);
    }

    public void crear(EntregaTarea EntregaTarea) {
        List<EntregaTarea> aux = this.EntregaTareaDao.find().asList();
        Integer codigo;
        if (aux.isEmpty()) {
            codigo = 1;
        } else {
            Integer count = aux.size();
            EntregaTarea last = aux.get(count - 1);
            codigo = last.getCodigo() + 1;
        }
        EntregaTarea.setCodigo(codigo);
        this.EntregaTareaDao.save(EntregaTarea);
    }

    public void crear1(EntregaTarea EntregaTarea) {
        this.EntregaTareaDao.save(EntregaTarea);
    }

    public EntregaTarea modificarCalificacion(EntregaTarea EntregaTareaCalificacion) {
        EntregaTarea aux = this.EntregaTareaDao.findOne("codigo", EntregaTareaCalificacion.getCodigo());
        aux.setCalificacion(EntregaTareaCalificacion.getCalificacion());
        this.EntregaTareaDao.save(aux);
        return aux;
    }

    public void modificar(EntregaTarea EntregaTarea) {
        EntregaTarea aux = this.EntregaTareaDao.findOne("codigo", EntregaTarea.getCodigo());
        EntregaTarea.setId(aux.getId());
        this.EntregaTareaDao.save(EntregaTarea);
    }

    public void eliminar(Integer codigo) {
        EntregaTarea EntregaTarea = this.EntregaTareaDao.findOne("codigo", codigo);
        this.EntregaTareaDao.delete(EntregaTarea);
    }
}
