/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import service.EquipoDesarrollo;
import service.EquipoDesarrolloPK;

/**
 *
 * @author chali
 */
@Stateless
@Path("service.equipodesarrollo")
public class EquipoDesarrolloFacadeREST extends AbstractFacade<EquipoDesarrollo> {

    @PersistenceContext(unitName = "webservicefiaPU")
    private EntityManager em;

    private EquipoDesarrolloPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idEquipo=idEquipoValue;idGrupoDesa=idGrupoDesaValue;userCarnet=userCarnetValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        service.EquipoDesarrolloPK key = new service.EquipoDesarrolloPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idEquipo = map.get("idEquipo");
        if (idEquipo != null && !idEquipo.isEmpty()) {
            key.setIdEquipo(idEquipo.get(0));
        }
        java.util.List<String> idGrupoDesa = map.get("idGrupoDesa");
        if (idGrupoDesa != null && !idGrupoDesa.isEmpty()) {
            key.setIdGrupoDesa(idGrupoDesa.get(0));
        }
        java.util.List<String> userCarnet = map.get("userCarnet");
        if (userCarnet != null && !userCarnet.isEmpty()) {
            key.setUserCarnet(userCarnet.get(0));
        }
        return key;
    }

    public EquipoDesarrolloFacadeREST() {
        super(EquipoDesarrollo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(EquipoDesarrollo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, EquipoDesarrollo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        service.EquipoDesarrolloPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public EquipoDesarrollo find(@PathParam("id") PathSegment id) {
        service.EquipoDesarrolloPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EquipoDesarrollo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EquipoDesarrollo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
