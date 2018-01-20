package fr.univtln.m2dapm.boardgame.restserver.resources.gameinfos;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;
import fr.univtln.m2dapm.boardgame.restserver.crud.CrudServiceBean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/players")
public class PlayerEJB {

    @Inject
    Player player;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPlayer(Player player) {
        System.out.println("POST player: " + player);
        em.persist(player);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Player getPlayerById(@PathParam("id") int id) {
        System.out.println("GET player by id: " + id);
        Player player = em.find(Player.class, id);
        return player;
    }
}
