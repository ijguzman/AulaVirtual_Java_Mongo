/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.edu.espe.arquitectura.aula.dao;

import ec.edu.espe.arquitectura.aula.model.Wiki;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author js_cm
 */
public class WikiDAO  extends BasicDAO<Wiki, ObjectId>  {
    public WikiDAO(Class<Wiki> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
}