/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.aula.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author CORE I7
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ec.edu.espe.arquitectura.aula.filter.ResponseCorsFilter.class);
        resources.add(ec.edu.espe.arquitectura.aula.services.AnunciosResource.class);
        resources.add(ec.edu.espe.arquitectura.aula.services.CalificacionResource.class);
        resources.add(ec.edu.espe.arquitectura.aula.services.CambioWikiResource.class);
        resources.add(ec.edu.espe.arquitectura.aula.services.CursosDocenteResource.class);
        resources.add(ec.edu.espe.arquitectura.aula.services.EntregaTareaResource.class);
        resources.add(ec.edu.espe.arquitectura.aula.services.ForoAlumnoResource.class);
        resources.add(ec.edu.espe.arquitectura.aula.services.ForosResource.class);
        resources.add(ec.edu.espe.arquitectura.aula.services.PaginaWikiResource.class);
        resources.add(ec.edu.espe.arquitectura.aula.services.TareaResource.class);
        resources.add(ec.edu.espe.arquitectura.aula.services.WikiResource.class);
    }
    
}
