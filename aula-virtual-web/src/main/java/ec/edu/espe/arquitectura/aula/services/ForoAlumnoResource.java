/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.services;

import ec.edu.espe.arquitectura.aula.model.ForoAlumno;
import ec.edu.espe.arquitectura.aula.service.ForoAlumnoService;

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
@Path("ForoAlumno")
@RequestScoped
public class ForoAlumnoResource {

    @Context
    private UriInfo context;
    @Inject
    private ForoAlumnoService service;
    /**
     * Creates a new instance of ForoAlumnoResource
     */
    public ForoAlumnoResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.arquitectura.aula.services.ForoAlumnoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path (value="{curso}")
    public Response getJson(@PathParam(value="curso")Integer foro) {
            List<ForoAlumno> lista_foros=this.service.obtenerForoAlumnoCurso(foro);
            GenericEntity<List<ForoAlumno>> gn=new GenericEntity<List<ForoAlumno>>(lista_foros){};
            return Response.ok(gn).header("Access-Control-Allow-Methods", "GET").build();
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(ForoAlumno request) {
        this.service.modificar(request);
        return Response.ok(request)
                .header("Access-Control-Allow-Methods", "POST").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putJson(ForoAlumno request) {
        this.service.crear(request);
        return Response.ok(request)
                .header("Access-Control-Allow-Methods", "PUT").build();
    }
    
    @DELETE
    @Path(value = "{foro_alumno}")
    public Response deleteJson(@PathParam(value = "foro_alumno") Integer foro_alumno) {
        this.service.eliminar(foro_alumno);
        return Response.ok().header("Access-Control-Allow-Methods", "DELETE").build();
    }
}
