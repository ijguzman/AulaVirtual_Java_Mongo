/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.service;

import es.edu.espe.arquitectura.aula.dao.ForoAlumnoDAO;
import ec.edu.espe.arquitectura.nosql.mongo.MongoPersistence;
import ec.edu.espe.arquitectura.aula.model.ForoAlumno;
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
public class ForoAlumnoService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
    private MongoPersistence mp;
    private ForoAlumnoDAO foroAlumnoDao;
    
    @PostConstruct
    public void init() {
        this.foroAlumnoDao = new ForoAlumnoDAO(ForoAlumno.class, mp.context());
    }

    public List<ForoAlumno> obtenerTodos() {
        return this.foroAlumnoDao.find().asList();
    }
    public List<ForoAlumno> obtenerForoAlumnoCurso(Integer foro) {
        return this.foroAlumnoDao.findbyForo(foro);
    }
    
    public void crear(ForoAlumno foroAlumno) {
        List<ForoAlumno> aux = this.foroAlumnoDao.find().asList();
        Integer codigo;
        if (aux.isEmpty()) {
            codigo = 1;
        } else {
            Integer count = aux.size();
            ForoAlumno last = aux.get(count - 1);
            codigo = last.getCodigo() + 1;
        }
        foroAlumno.setCodigo(codigo);
        this.foroAlumnoDao.save(foroAlumno);
    }
    public void crear1(ForoAlumno foroAlumno) {
        this.foroAlumnoDao.save(foroAlumno);
    }

    public void modificar(ForoAlumno foroAlumno) {
        ForoAlumno aux = this.foroAlumnoDao.findOne("codigo", foroAlumno.getCodigo());
        foroAlumno.setId(aux.getId());
        this.foroAlumnoDao.save(foroAlumno);
    }
    
    public void eliminar(Integer codigo) {
        ForoAlumno foroAlumno = this.foroAlumnoDao.findOne("codigo", codigo);
        this.foroAlumnoDao.delete(foroAlumno);
    }
}
