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
    private AnuncioDAO camionDao;
    
    @PostConstruct
    public void init() {
        this.camionDao = new AnuncioDAO(Anuncio.class, mp.context());
    }

    public List<Anuncio> obtenerTodos() {
        return this.camionDao.find().asList();
    }
    
    
    public void crear(Anuncio camion) {
        List<Anuncio> aux = this.camionDao.find().asList();
        Integer codigo;
        if (aux.isEmpty()) {
            codigo = 1;
        } else {
            Integer count = aux.size();
            Anuncio last = aux.get(count - 1);
            codigo = last.getCodigo() + 1;
        }
        camion.setCodigo(codigo);
        this.camionDao.save(camion);
    }
    public void crear1(Anuncio camion) {
        this.camionDao.save(camion);
    }

    public void modificar(Anuncio camion) {
        Anuncio aux = this.camionDao.findOne("codigo", camion.getCodigo());
        camion.setCodigo(aux.getCodigo());
        this.camionDao.save(camion);
    }
    
    public void eliminar(Integer codigo) {
        Anuncio camion = this.camionDao.findOne("codigo", codigo);
        this.camionDao.delete(camion);
    }
}
