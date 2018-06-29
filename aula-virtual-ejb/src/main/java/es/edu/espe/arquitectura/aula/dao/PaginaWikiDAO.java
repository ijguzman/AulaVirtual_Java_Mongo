/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.edu.espe.arquitectura.aula.dao;

import ec.edu.espe.arquitectura.aula.model.PaginaWiki;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author js_cm
 */
public class PaginaWikiDAO  extends BasicDAO<PaginaWiki, ObjectId>  {
    public PaginaWikiDAO(Class<PaginaWiki> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
}
