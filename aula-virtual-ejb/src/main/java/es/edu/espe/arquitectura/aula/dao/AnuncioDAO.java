/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.edu.espe.arquitectura.aula.dao;

import ec.edu.espe.arquitectura.aula.model.Anuncio;
import ec.edu.espe.arquitectura.aula.model.Foro;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author js_cm
 */
public class AnuncioDAO  extends BasicDAO<Anuncio, ObjectId>  {
    public AnuncioDAO(Class<Anuncio> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
    public List<Anuncio> findbyCurso (String curso){
        Query<Anuncio> q = getDatastore().createQuery(Anuncio.class);
        q.criteria("curso").equal(curso);
        return q.asList();
    }
}
