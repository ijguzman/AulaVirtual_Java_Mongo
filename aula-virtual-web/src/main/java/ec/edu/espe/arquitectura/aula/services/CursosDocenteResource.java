/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.services;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author CORE I7
 */
@Path("CursosDocente")
@RequestScoped
public class CursosDocenteResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CursosDocenteResource
     */
    public CursosDocenteResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.arquitectura.aula.services.CursosDocenteResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path (value="{cod_docente}")
    public Response getJson(@PathParam(value="cod_docente")String pk) {
        /*if(pk.isEmpty()){
            List<Taquilla> taquillas=this.service.obtenerLocalidades();
            GenericEntity<List<Taquilla>> gn=new GenericEntity<List<Taquilla>>(taquillas){};
            return Response.ok(gn).build();
        }else{
            Taquilla taquilla=this.service.obtenerInformacionTaquilla(pk);
            if(taquilla!=null){
                return Response.ok(taquilla).build();
            }else{
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        }*/
        return Response.ok("hola").build();
    }
    /**
     * PUT method for updating or creating an instance of CursosDocenteResource
     * @param content representation for the resource
     
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }*/
}
