/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.edu.espe.arquitectura.aula.dao;

import ec.edu.espe.arquitectura.aula.model.ForoAlumno;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author js_cm
 */
public class ForoAlumnoDAO  extends BasicDAO<ForoAlumno, ObjectId>  {
    public ForoAlumnoDAO(Class<ForoAlumno> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
    public List<ForoAlumno> findbyForo (Integer foro){
        Query<ForoAlumno> q = getDatastore().createQuery(ForoAlumno.class);
        q.criteria("foro").equal(foro);
        return q.asList();
    }
}