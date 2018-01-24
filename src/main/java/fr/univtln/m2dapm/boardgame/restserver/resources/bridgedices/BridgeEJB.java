package fr.univtln.m2dapm.boardgame.restserver.resources.bridgedices;

import fr.univtln.m2dapm.boardgame.business.bridgedices.Bridge;
import fr.univtln.m2dapm.boardgame.business.dices.Dice;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@ApplicationScoped
@Path("/bridges")
public class BridgeEJB {

    @EJB
    Bridge bridge;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createBridge(Bridge bridge) {
        System.out.println("POST bridge: " + bridge);
        em.persist(bridge);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateBridge(Bridge bridge) {
        System.out.println("PUT bridge: " + bridge);
        em.merge(bridge);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bridge getBridgeById(@PathParam("id") int id) {
        System.out.println("GET bridge by id: " + id);
        bridge = em.find(Bridge.class, id);
        return bridge;
    }
}
