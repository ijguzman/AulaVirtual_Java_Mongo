/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.service;

import ec.edu.espe.arquitectura.aula.model.PaginaWiki;
import ec.edu.espe.arquitectura.nosql.mongo.MongoPersistence;
import es.edu.espe.arquitectura.aula.dao.PaginaWikiDAO;
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
public class PaginaWikiService {
    
    @EJB
    private MongoPersistence mp;
    private PaginaWikiDAO PaginaWikiDao;
    
    @PostConstruct
    public void init() {
        this.PaginaWikiDao = new PaginaWikiDAO(PaginaWiki.class, mp.context());
    }

    public List<PaginaWiki> obtenerTodos() {
        return this.PaginaWikiDao.find().asList();
    }
    
    public List<PaginaWiki> obtenerPorWiki(String wiki) {
        return this.PaginaWikiDao.findbyWiki(wiki);
    }
    
    public PaginaWiki obtenerPaginaWiki(Integer codigo) {
        return this.PaginaWikiDao.findOne("codigo", codigo);
    }
    
    public void crear(PaginaWiki paginaWiki) {
        List<PaginaWiki> aux = this.PaginaWikiDao.find().asList();
        Integer codigo;
        if (aux.isEmpty()) {
            codigo = 1;
        } else {
            Integer count = aux.size();
            PaginaWiki last = aux.get(count - 1);
            codigo = last.getCodigo() + 1;
        }
        paginaWiki.setCodigo(codigo);
        this.PaginaWikiDao.save(paginaWiki);
    }

    public void modificar(PaginaWiki PaginaWiki) {
        PaginaWiki aux = this.PaginaWikiDao.findOne("codigo", PaginaWiki.getCodigo());
        PaginaWiki.setId(aux.getId());
        this.PaginaWikiDao.save(PaginaWiki);
    }
    
    public void eliminar(Integer codigo) {
        PaginaWiki PaginaWiki = this.PaginaWikiDao.findOne("codigo", codigo);
        this.PaginaWikiDao.delete(PaginaWiki);
    }
}
