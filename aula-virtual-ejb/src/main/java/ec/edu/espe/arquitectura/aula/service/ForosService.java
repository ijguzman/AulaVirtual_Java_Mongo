/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.service;

import es.edu.espe.arquitectura.aula.dao.ForoDAO;
import ec.edu.espe.arquitectura.nosql.mongo.MongoPersistence;
import ec.edu.espe.arquitectura.aula.model.Foro;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author CORE I7
 */
@Stateless
@LocalBean
public class ForosService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
    private MongoPersistence mp;
    private ForoDAO foroDao;
    
    @PostConstruct
    public void init() {
        this.foroDao = new ForoDAO(Foro.class, mp.context());
    }

    public List<Foro> obtenerTodos() {
        return this.foroDao.find().asList();
    }
    public List<Foro> obtenerForoCurso(String curso) {
        return this.foroDao.findbyCurso(curso);
    }
    
    public void crear(Foro foro) {
        List<Foro> aux = this.foroDao.find().asList();
        Integer codigo;
        if (aux.isEmpty()) {
            codigo = 1;
        } else {
            Integer count = aux.size();
            Foro last = aux.get(count - 1);
            codigo = last.getCodigo() + 1;
        }
        foro.setCodigo(codigo);
        this.foroDao.save(foro);
    }
    public void crear1(Foro foro) {
        this.foroDao.save(foro);
    }

    public void modificar(Foro foro) {
        Foro aux = this.foroDao.findOne("codigo", foro.getCodigo());
        foro.setId(aux.getId());
        this.foroDao.save(foro);
    }
    
    public void eliminar(Integer codigo) {
        Foro foro = this.foroDao.findOne("codigo", codigo);
        this.foroDao.delete(foro);
    }
}
