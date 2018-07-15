/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.services;

import ec.edu.espe.arquitectura.aula.model.Tarea;
import ec.edu.espe.arquitectura.aula.service.TareaService;
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
 * @author js_cm
 */
@Path("Tarea")
@RequestScoped
public class TareaResource {

    @Context
    private UriInfo context;
    @Inject
    private TareaService service;

    /**
     * Creates a new instance of TareaResource
     */
    public TareaResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "{curso}")
    public Response getJson(@PathParam(value = "curso") String curso) {
        List<Tarea> lista_tareas = this.service.obtenerTareaCurso(curso);
        GenericEntity<List<Tarea>> gn = new GenericEntity<List<Tarea>>(lista_tareas) {
        };
        return Response.ok(gn).header("Access-Control-Allow-Methods", "GET").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putJson(Tarea request) {
        this.service.crear(request);
        return Response.ok(request)
                .header("Access-Control-Allow-Methods", "POST").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(Tarea request) {
        this.service.modificar(request);
        return Response.ok(request)
                .header("Access-Control-Allow-Methods", "PUT").build();
    }
    
    @DELETE
    @Path(value = "{tarea}")
    public Response deleteJson(@PathParam(value = "tarea") Integer tarea) {
        this.service.eliminar(tarea);
        return Response.ok().header("Access-Control-Allow-Methods", "DELETE").build();
    }
}
