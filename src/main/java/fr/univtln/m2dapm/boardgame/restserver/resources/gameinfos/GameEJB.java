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
    @Path("/create/{name}_{pwd}_{prv}_{maxPJ}_{maxACV}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createGame(@PathParam("name") String name,
                             @PathParam("pwd") String pwd,
                             @PathParam("prv") Boolean prv,
                             @PathParam("maxPJ") int maxPJ,
                             @PathParam("maxACV") int maxACV) {
        System.out.println("POST game: " + game);
        game.setName(name);
        game.setPassword(pwd);
        game.setaPrivate(prv);
        game.setMaxPlayers(maxPJ);
        game.setMaxArmyClassValue(maxACV);
        em.persist(game);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Game getGameById(@PathParam("id") int id) {
        System.out.println("GET game by id: " + id);
        Game game = em.find(Game.class, id);
        return game;
    }

    @GET
    @Path("/{maxPJ}")
    @Produces(MediaType.APPLICATION_JSON)
    public Game getGameByMaxPJ(@PathParam("maxPJ") int maxPJ) {
        System.out.println("GET game by maxPJ: " + maxPJ);
        TypedQuery<Game> query = em.createQuery("SELECT g from Game as g where g.maxPlayers = :maxPJ", Game.class);
        query.setParameter("maxPJ", maxPJ);
        Game game = query.getSingleResult();
        return game;
    }
}
