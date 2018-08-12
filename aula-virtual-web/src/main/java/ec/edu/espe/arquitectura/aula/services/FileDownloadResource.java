/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.services;

import java.io.File;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * REST Web Service
 *
 * @author js_cm
 */
@Path("Download")
@RequestScoped
public class FileDownloadResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FileDownloadResource
     */
    public FileDownloadResource() {
    }

    @GET
    @Path(value = "/{path}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadFile(@PathParam(value = "path") String path) {
        File file = new File("C:/uploadedFiles/"+path);
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment;filename="+path);
        return response.build();
    }
}
