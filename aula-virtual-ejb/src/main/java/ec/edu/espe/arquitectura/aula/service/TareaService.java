/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.service;

import ec.edu.espe.arquitectura.aula.model.Tarea;
import ec.edu.espe.arquitectura.nosql.mongo.MongoPersistence;
import es.edu.espe.arquitectura.aula.dao.TareaDAO;
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
public class TareaService {
    
    @EJB
    private MongoPersistence mp;
    private TareaDAO TareaDao;
    
    @PostConstruct
    public void init() {
        this.TareaDao = new TareaDAO(Tarea.class, mp.context());
    }

    public List<Tarea> obtenerTodos() {
        return this.TareaDao.find().asList();
    }
    
    public List<Tarea> obtenerTareaCurso(String curso) {
        return this.TareaDao.findbyCurso(curso);
    }
    
    public Tarea obtenerTarea(Integer codigo) {
        return this.TareaDao.findOne("codigo", codigo);
    }
    
    public void crear(Tarea tarea) {
        List<Tarea> aux = this.TareaDao.find().asList();
        Integer codigo;
        if (aux.isEmpty()) {
            codigo = 1;
        } else {
            Integer count = aux.size();
            Tarea last = aux.get(count - 1);
            codigo = last.getCodigo() + 1;
        }
        tarea.setCodigo(codigo);
        this.TareaDao.save(tarea);
    }
    
    public void crear1(Tarea Tarea) {
        this.TareaDao.save(Tarea);
    }

    public void modificar(Tarea Tarea) {
        Tarea aux = this.TareaDao.findOne("codigo", Tarea.getCodigo());
        Tarea.setId(aux.getId());
        this.TareaDao.save(Tarea);
    }
    
    public void eliminar(Integer codigo) {
        Tarea Tarea = this.TareaDao.findOne("codigo", codigo);
        this.TareaDao.delete(Tarea);
    }
}
