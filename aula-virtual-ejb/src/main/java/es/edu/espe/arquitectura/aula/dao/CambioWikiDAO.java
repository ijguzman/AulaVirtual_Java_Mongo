/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.edu.espe.arquitectura.aula.dao;

import ec.edu.espe.arquitectura.aula.model.CambioWiki;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author js_cm
 */
public class CambioWikiDAO  extends BasicDAO<CambioWiki, ObjectId>  {
    public CambioWikiDAO(Class<CambioWiki> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
    
    public List<CambioWiki> findbyWiki (String wiki){
        Query<CambioWiki> q = getDatastore().createQuery(CambioWiki.class);
        q.criteria("wiki").equal(wiki);
        return q.asList();
    }
}
