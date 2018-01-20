package fr.univtln.m2dapm.boardgame.restserver.resources.bridgedices;

import fr.univtln.m2dapm.boardgame.business.bridgedices.Bridge;
import fr.univtln.m2dapm.boardgame.business.dices.Dice;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/bridges")
public class BridgeEJB {

    @Inject
    Bridge bridge;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Path("/create/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createBridge() {
        System.out.println("POST bridge: " + bridge);
        em.persist(bridge);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bridge getBridgeById(@PathParam("id") int id) {
        System.out.println("GET bridge by id: " + id);
        Bridge bridge = em.find(Bridge.class, id);
        return bridge;
    }
}
