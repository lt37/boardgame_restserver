package fr.univtln.m2dapm.boardgame.restserver.resources.board;

import fr.univtln.m2dapm.boardgame.business.board.Board;
import fr.univtln.m2dapm.boardgame.business.board.Square;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/squares")
public class SquareEJB {

    @Inject
    Square square;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createSquare(Square square) {
        System.out.println("POST square: " + square);
        em.persist(square);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateSquare(Square square) {
        System.out.println("PUT square: " + square);
        em.merge(square);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Square getSquareById(@PathParam("id") int id) {
        System.out.println("GET square by id: " + id);
        square = em.find(Square.class, id);
        return square;
    }
}
