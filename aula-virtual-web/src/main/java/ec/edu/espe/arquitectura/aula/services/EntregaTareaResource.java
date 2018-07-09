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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
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

    /**
     * Creates a new instance of EntregaTareaResource
     */
    public EntregaTareaResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.arquitectura.aula.services.EntregaTareaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(EntregaTarea request) {
        Tarea tareaAEntregar = this.tareaService.obtenerTarea(request.getTarea().getCodigo());
        request.setTarea(tareaAEntregar);
        this.entregaTareaService.crear(request);
        return Response.ok(request)
                .header("Access-Control-Allow-Methods", "POST").build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
