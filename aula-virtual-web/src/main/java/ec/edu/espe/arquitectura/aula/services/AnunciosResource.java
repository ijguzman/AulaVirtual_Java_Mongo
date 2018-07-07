/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.services;

import ec.edu.espe.arquitectura.aula.model.Anuncio;
import ec.edu.espe.arquitectura.aula.service.AnuncioService;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author CORE I7
 */
@Path("Anuncios")
@RequestScoped
public class AnunciosResource {

    @Context
    private UriInfo context;
    @Inject
    private AnuncioService service;
    /**
     * Creates a new instance of AnunciosResource
     */
    public AnunciosResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.arquitectura.aula.services.AnunciosResource
     * @return an instance of java.lang.String
     */
    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    *
     * PUT method for updating or creating an instance of AnunciosResource
     * @param content representation for the resource
     
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }*/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Path (value="{pk}")
    public Response getJson() {
            List<Anuncio> lista_anuncios=this.service.obtenerTodos();
            GenericEntity<List<Anuncio>> gn=new GenericEntity<List<Anuncio>>(lista_anuncios){};
            return Response.ok(gn).build();
        
    }
}
