/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.services;


import ec.edu.espe.arquitectura.aula.model.Anuncio;
import ec.edu.espe.arquitectura.aula.model.Foro;
import ec.edu.espe.arquitectura.aula.model.Tarea;
import ec.edu.espe.arquitectura.aula.service.AnuncioService;
import ec.edu.espe.arquitectura.aula.service.ForosService;
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
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author CORE I7
 */
@Path("Foros")
@RequestScoped
public class ForosResource {

    @Context
    private UriInfo context;
    @Inject
    private ForosService service;
    /**
     * Creates a new instance of AnunciosResource
     */
    public ForosResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path (value="{curso}")
    public Response getJson(@PathParam(value="curso")String curso) {
            List<Foro> lista_foros=this.service.obtenerForoCurso(curso);
            GenericEntity<List<Foro>> gn=new GenericEntity<List<Foro>>(lista_foros){};
            return Response.ok(gn).header("Access-Control-Allow-Methods", "GET").build();
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(Foro request) {
        this.service.modificar(request);
        return Response.ok(request)
                .header("Access-Control-Allow-Methods", "POST").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putJson(Foro request) {
        this.service.crear(request);
        System.out.println(request.getFechaInicio());
        return Response.ok(request)
                .header("Access-Control-Allow-Methods", "PUT").build();
    }
    
    @DELETE
    @Path(value = "{foro}")
    public Response deleteJson(@PathParam(value = "foro") Integer foro) {
        this.service.eliminar(foro);
        return Response.ok().header("Access-Control-Allow-Methods", "DELETE").build();
    }
}
