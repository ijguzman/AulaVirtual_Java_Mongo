/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.services;

import ec.edu.espe.arquitectura.aula.model.CambioWiki;
import ec.edu.espe.arquitectura.aula.service.CambioWikiService;
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
@Path("CambioCambioWiki")
@RequestScoped
public class CambioWikiResource {

    @Context
    private UriInfo context;
    @Inject CambioWikiService service;
    
    public CambioWikiResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "{wiki}")
    public Response getJson(@PathParam(value = "cambioWiki") String wiki) {
        List<CambioWiki> lista_cambioWikis = this.service.obtenerPorWiki(wiki);
        GenericEntity<List<CambioWiki>> gn = new GenericEntity<List<CambioWiki>>(lista_cambioWikis) {
        };
        return Response.ok(gn).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putJson(CambioWiki request) {
        this.service.crear(request);
        return Response.ok(request)
                .header("Access-Control-Allow-Methods", "POST").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(CambioWiki request) {
        this.service.modificar(request);
        return Response.ok(request)
                .header("Access-Control-Allow-Methods", "PUT").build();
    }
    
    @DELETE
    @Path(value = "{cambioWiki}")
    public Response deleteJson(@PathParam(value = "cambioWiki") String cambioWiki) {
        this.service.eliminar(cambioWiki);
        return Response.ok().build();
    }
}
