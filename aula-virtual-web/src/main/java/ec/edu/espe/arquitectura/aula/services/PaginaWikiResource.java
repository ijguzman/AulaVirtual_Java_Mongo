/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.services;

import ec.edu.espe.arquitectura.aula.model.PaginaWiki;
import ec.edu.espe.arquitectura.aula.service.PaginaWikiService;
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
@Path("PaginaWiki")
@RequestScoped
public class PaginaWikiResource {

    @Context
    private UriInfo context;
    @Inject
    private PaginaWikiService service;

    public PaginaWikiResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "{wiki}")
    public Response getJson(@PathParam(value = "wiki") String wiki) {
        List<PaginaWiki> lista_paginaWikis = this.service.obtenerPorWiki(wiki);
        GenericEntity<List<PaginaWiki>> gn = new GenericEntity<List<PaginaWiki>>(lista_paginaWikis) {
        };
        return Response.ok(gn).header("Access-Control-Allow-Methods", "GET").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putJson(PaginaWiki request) {
        this.service.crear(request);
        return Response.ok(request)
                .header("Access-Control-Allow-Methods", "POST").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(PaginaWiki request) {
        this.service.modificar(request);
        return Response.ok(request)
                .header("Access-Control-Allow-Methods", "PUT").build();
    }
    
    @DELETE
    @Path(value = "{paginaWiki}")
    public Response deleteJson(@PathParam(value = "paginaWiki") Integer paginaWiki) {
        this.service.eliminar(paginaWiki);
        return Response.ok().header("Access-Control-Allow-Methods", "DELETE").build();
    }
}
