/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.service;

import ec.edu.espe.arquitectura.aula.model.CambioWiki;
import ec.edu.espe.arquitectura.nosql.mongo.MongoPersistence;
import es.edu.espe.arquitectura.aula.dao.CambioWikiDAO;
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
public class CambioWikiService {
    
    @EJB
    private MongoPersistence mp;
    private CambioWikiDAO cambioWikiDao;
    
    @PostConstruct
    public void init() {
        this.cambioWikiDao = new CambioWikiDAO(CambioWiki.class, mp.context());
    }

    public List<CambioWiki> obtenerTodos() {
        return this.cambioWikiDao.find().asList();
    }
    
    public List<CambioWiki> obtenerPorWiki(String curso) {
        return this.cambioWikiDao.findbyWiki(curso);
    }
    
    public CambioWiki obtenerCambioWiki(String codigo) {
        return this.cambioWikiDao.findOne("codigo", codigo);
    }
    
    public void crear(CambioWiki CambioWiki) {
        this.cambioWikiDao.save(CambioWiki);
    }

    public void modificar(CambioWiki CambioWiki) {
        CambioWiki aux = this.cambioWikiDao.findOne("codigo", CambioWiki.getCodigo());
        CambioWiki.setId(aux.getId());
        this.cambioWikiDao.save(CambioWiki);
    }
    
    public void eliminar(String codigo) {
        CambioWiki CambioWiki = this.cambioWikiDao.findOne("codigo", codigo);
        this.cambioWikiDao.delete(CambioWiki);
    }
}
