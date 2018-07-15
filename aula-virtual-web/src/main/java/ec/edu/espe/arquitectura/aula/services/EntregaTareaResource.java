/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.services;

import ec.edu.espe.arquitectura.aula.model.EntregaTarea;
import ec.edu.espe.arquitectura.aula.model.Tarea;
import ec.edu.espe.arquitectura.aula.service.EntregaTareaService;
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
@Path("EntregaTarea")
@RequestScoped
public class EntregaTareaResource {

    @Context
    private UriInfo context;
    @Inject
    private EntregaTareaService entregaTareaService;
    @Inject
    private TareaService tareaService;

    public EntregaTareaResource() {
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/{curso}/{tarea}")
    public Response getJson(@PathParam(value = "curso") String curso, @PathParam(value = "tarea") Integer tarea) {
        List<EntregaTarea> listaEntregaTareas = this.entregaTareaService.obtenerPorCursoTarea(curso,tarea);
        GenericEntity<List<EntregaTarea>> gn = new GenericEntity<List<EntregaTarea>>(listaEntregaTareas) {
        };
        return Response.ok(gn).header("Access-Control-Allow-Methods", "GET").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putJson(EntregaTarea request) {
        this.entregaTareaService.crear(request);
        return Response.ok(request)
                .header("Access-Control-Allow-Methods", "PUT").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(EntregaTarea request) {
        this.entregaTareaService.modificar(request);
        return Response.ok(request)
                .header("Access-Control-Allow-Methods", "POST").build();
    }
    
    @DELETE
    @Path(value = "{EntregaTarea}")
    public Response deleteJson(@PathParam(value = "EntregaTarea") Integer EntregaTarea) {
        this.entregaTareaService.eliminar(EntregaTarea);
        return Response.ok().header("Access-Control-Allow-Methods", "DELETE").build();
    }
}
