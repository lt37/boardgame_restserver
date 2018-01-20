package fr.univtln.m2dapm.boardgame.restserver.resources.tokens;

import fr.univtln.m2dapm.boardgame.business.tokens.Field;
import fr.univtln.m2dapm.boardgame.business.tokens.Ship;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/ships")
public class ShipEJB {

    @Inject
    Ship ship;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Path("/create/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createShip() {
        System.out.println("POST ship: " + ship);
        em.persist(ship);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ship getShipById(@PathParam("id") int id) {
        System.out.println("GET ship by id: " + id);
        Ship ship = em.find(Ship.class, id);
        return ship;
    }
}
