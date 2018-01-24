package fr.univtln.m2dapm.boardgame.restserver.resources.tokens;

import fr.univtln.m2dapm.boardgame.business.tokens.Field;
import fr.univtln.m2dapm.boardgame.business.tokens.Ship;

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
@Path("/ships")
public class ShipEJB {

    @EJB
    Ship ship;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createShip(Ship ship) {
        System.out.println("POST ship: " + ship);
        em.persist(ship);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateShip(Ship ship) {
        System.out.println("PUT ship: " + ship);
        em.merge(ship);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ship getShipById(@PathParam("id") int id) {
        System.out.println("GET ship by id: " + id);
        ship = em.find(Ship.class, id);
        return ship;
    }
}
