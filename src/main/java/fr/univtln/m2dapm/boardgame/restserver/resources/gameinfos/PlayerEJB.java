package fr.univtln.m2dapm.boardgame.restserver.resources.gameinfos;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Named
@Stateless
@Path("/players")
public class PlayerEJB {

    @Inject
    Player player;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPlayer(Player player) {
        System.out.println("POST player: " + player);
        em.persist(player);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePlayer(Player player) {
        System.out.println("PUT player: " + player);
        em.merge(player);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Player getPlayerById(@PathParam("id") int id) {
        System.out.println("GET player by id: " + id);
        player = em.find(Player.class, id);
        return player;
    }

    @GET
    @Path("/login/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public Player getPlayerByLogin(@PathParam("login") String login) {
        System.out.println("GET player by loginName: " + login);
        TypedQuery<Player> query = em.createQuery("SELECT p from Player as p where p.loginName = :login", Player.class);
        query.setParameter("login", login);
        player = query.getSingleResult();
        return player;
    }

    @GET
    @Path("/mail/{mail}")
    @Produces(MediaType.APPLICATION_JSON)
    public Player getPlayerByMail(@PathParam("mail") String mail) {
        System.out.println("GET player by email: " + mail);
        TypedQuery<Player> query = em.createQuery("SELECT p from Player as p where p.email = :mail", Player.class);
        query.setParameter("mail", mail);
        player = query.getSingleResult();
        return player;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getAllPlayers() {
        System.out.println("GET all players");
        return em.createQuery("SELECT p FROM Player AS p", Player.class).getResultList();
    }
}
