package fr.univtln.m2dapm.boardgame.restserver.resources.board;

import fr.univtln.m2dapm.boardgame.business.board.Board;
import fr.univtln.m2dapm.boardgame.business.board.PlaceableBehavior;

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
@Path("/placeableBehaviors")
public class PlaceableBehaviorEJB {

    @EJB
    PlaceableBehavior placeableBehavior;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPlaceableBehavior(PlaceableBehavior placeableBehavior) {
        System.out.println("POST placeableBehavior: " + placeableBehavior);
        em.persist(placeableBehavior);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePlaceableBehavior(PlaceableBehavior placeableBehavior) {
        System.out.println("PUT placeableBehavior: " + placeableBehavior);
        em.merge(placeableBehavior);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PlaceableBehavior getPlaceableBehaviorById(@PathParam("id") int id) {
        System.out.println("GET placeableBehavior by id: " + id);
        placeableBehavior = em.find(PlaceableBehavior.class, id);
        return placeableBehavior;
    }
}
