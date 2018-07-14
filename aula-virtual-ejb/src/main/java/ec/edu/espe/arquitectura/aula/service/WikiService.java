/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.service;

import ec.edu.espe.arquitectura.aula.model.Wiki;
import ec.edu.espe.arquitectura.nosql.mongo.MongoPersistence;
import es.edu.espe.arquitectura.aula.dao.WikiDAO;
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
public class WikiService {
    
    @EJB
    private MongoPersistence mp;
    private WikiDAO wikiDao;
    
    @PostConstruct
    public void init() {
        this.wikiDao = new WikiDAO(Wiki.class, mp.context());
    }

    public List<Wiki> obtenerTodos() {
        return this.wikiDao.find().asList();
    }
    
    public List<Wiki> obtenerWikiPorCurso(String curso) {
        return this.wikiDao.findbyCurso(curso);
    }
    
    public Wiki obtenerWiki(String codigo) {
        return this.wikiDao.findOne("codigo", codigo);
    }
    
    public void crear(Wiki Wiki) {
        this.wikiDao.save(Wiki);
    }

    public void modificar(Wiki Wiki) {
        Wiki aux = this.wikiDao.findOne("codigo", Wiki.getCodigo());
        Wiki.setId(aux.getId());
        this.wikiDao.save(Wiki);
    }
    
    public void eliminar(String codigo) {
        Wiki Wiki = this.wikiDao.findOne("codigo", codigo);
        this.wikiDao.delete(Wiki);
    }
}
