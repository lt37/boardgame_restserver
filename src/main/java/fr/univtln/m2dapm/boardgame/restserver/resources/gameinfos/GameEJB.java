package fr.univtln.m2dapm.boardgame.restserver.resources.gameinfos;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Game;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/games")
public class GameEJB {

    @Inject
    Game game;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createGame(Game game) {
        System.out.println("POST game: " + game);
        em.persist(game);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateGame(Game game) {
        System.out.println("PUT game: " + game);
        em.merge(game);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Game getGameById(@PathParam("id") int id) {
        System.out.println("GET game by id: " + id);
        game = em.find(Game.class, id);
        return game;
    }

    @GET
    @Path("/maxpj/{maxPJ}")
    @Produces(MediaType.APPLICATION_JSON)
    public Game getGameByMaxPJ(@PathParam("maxPJ") int maxPJ) {
        System.out.println("GET game by maxPJ: " + maxPJ);
        TypedQuery<Game> query = em.createQuery("SELECT g from Game as g where g.maxPlayers = :maxPJ", Game.class);
        query.setParameter("maxPJ", maxPJ);
        game = query.getSingleResult();
        return game;
    }
}
