/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.service;

import es.edu.espe.arquitectura.aula.dao.AnuncioDAO;
import ec.edu.espe.arquitectura.nosql.mongo.MongoPersistence;
import ec.edu.espe.arquitectura.aula.model.Anuncio;
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
public class AnuncioService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
    private MongoPersistence mp;
    private AnuncioDAO anuncioDao;
    
    @PostConstruct
    public void init() {
        this.anuncioDao = new AnuncioDAO(Anuncio.class, mp.context());
    }

    public List<Anuncio> obtenerTodos() {
        return this.anuncioDao.find().asList();
    }
    
    public List<Anuncio> obtenerAnuncioCurso(String curso) {
        return this.anuncioDao.findbyCurso(curso);
    }
    public void crear(Anuncio anuncio) {
        List<Anuncio> aux = this.anuncioDao.find().asList();
        Integer codigo;
        if (aux.isEmpty()) {
            codigo = 1;
        } else {
            Integer count = aux.size();
            Anuncio last = aux.get(count - 1);
            codigo = last.getCodigo() + 1;
        }
        anuncio.setCodigo(codigo);
        this.anuncioDao.save(anuncio);
    }
    public void crear1(Anuncio anuncio) {
        this.anuncioDao.save(anuncio);
    }

    public void modificar(Anuncio anuncio) {
        Anuncio aux = this.anuncioDao.findOne("codigo", anuncio.getCodigo());
        anuncio.setId(aux.getId());
        this.anuncioDao.save(anuncio);
    }
    
    public void eliminar(Integer codigo) {
        Anuncio anuncio = this.anuncioDao.findOne("codigo", codigo);
        this.anuncioDao.delete(anuncio);
    }
}
