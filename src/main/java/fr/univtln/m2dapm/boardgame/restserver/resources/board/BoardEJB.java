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
    @Path("/create/{name}_{lines}_{columns}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createBoard(@PathParam("name") String name,
                             @PathParam("lines") int lines,
                             @PathParam("columns") int columns) {
        System.out.println("POST board: " + board);
        board.setName(name);
        board.setLines(lines);
        board.setColumn(columns);
        em.persist(board);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Board getBoardById(@PathParam("id") int id) {
        System.out.println("GET board by id: " + id);
        Board board = em.find(Board.class, id);
        return board;
    }
}
