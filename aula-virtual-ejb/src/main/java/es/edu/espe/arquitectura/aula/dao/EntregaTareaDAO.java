/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.edu.espe.arquitectura.aula.dao;

import ec.edu.espe.arquitectura.aula.model.EntregaTarea;
import ec.edu.espe.arquitectura.aula.model.Tarea;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author js_cm
 */
public class EntregaTareaDAO  extends BasicDAO<EntregaTarea, ObjectId>  {
    public EntregaTareaDAO(Class<EntregaTarea> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
    
    public List<EntregaTarea> findbyAlumno (String alumno){
        Query<EntregaTarea> q = getDatastore().createQuery(EntregaTarea.class);
        q.criteria("alumno").equal(alumno);
        return q.asList();
    }
    
    public List<EntregaTarea> findbyTarea (Tarea tarea){
        Query<EntregaTarea> q = getDatastore().createQuery(EntregaTarea.class);
        q.criteria("Tarea").equal(tarea);
        return q.asList();
    }
}
