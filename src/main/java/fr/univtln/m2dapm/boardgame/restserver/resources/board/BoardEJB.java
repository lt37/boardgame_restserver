package fr.univtln.m2dapm.boardgame.restserver.resources.board;

import fr.univtln.m2dapm.boardgame.business.board.Board;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Game;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/boards")
public class BoardEJB {

    @Inject
    Board board;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createBoard(Board board) {
        System.out.println("POST board: " + board);
        em.persist(board);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateBoard(Board board) {
        System.out.println("PUT board: " + board);
        em.merge(board);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Board getBoardById(@PathParam("id") int id) {
        System.out.println("GET board by id: " + id);
        board = em.find(Board.class, id);
        return board;
    }
}
