package fr.univtln.m2dapm.boardgame.restserver.resources.board;

import fr.univtln.m2dapm.boardgame.business.board.Board;
import fr.univtln.m2dapm.boardgame.business.board.PlaceableBehavior;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/placeableBehaviors")
public class PlaceableBehaviorEJB {

    @Inject
    PlaceableBehavior placeableBehavior;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Path("/create/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPlaceableBehavior() {
        System.out.println("POST placeableBehavior: " + placeableBehavior);
        em.persist(placeableBehavior);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PlaceableBehavior getPlaceableBehaviorById(@PathParam("id") int id) {
        System.out.println("GET placeableBehavior by id: " + id);
        PlaceableBehavior placeableBehavior = em.find(PlaceableBehavior.class, id);
        return placeableBehavior;
    }
}
