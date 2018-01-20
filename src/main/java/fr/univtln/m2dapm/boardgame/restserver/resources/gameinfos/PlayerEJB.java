package fr.univtln.m2dapm.boardgame.restserver.resources.gameinfos;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;
import fr.univtln.m2dapm.boardgame.restserver.crud.CrudServiceBean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
    @Path("/create/{login}_{pwd}_{mail}_{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPlayer(@PathParam("login") String login,
                             @PathParam("pwd") String pwd,
                             @PathParam("mail") String mail,
                             @PathParam("name") String name) {
        System.out.println("POST player: " + player);
        player.setLoginName(login);
        player.setDisplayedName(name);
        player.setEmail(mail);
        player.setEncryptedPassword(pwd);
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

    @GET
    @Path("/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public Player getPlayerByLogin(@PathParam("login") String login) {
        System.out.println("GET player by loginName: " + login);
        TypedQuery<Player> query = em.createQuery("SELECT p from Player as p where p.loginName = :login", Player.class);
        query.setParameter("login", login);
        Player player = query.getSingleResult();
        return player;
    }

    @GET
    @Path("/{mail}")
    @Produces(MediaType.APPLICATION_JSON)
    public Player getPlayerByMail(@PathParam("mail") String mail) {
        System.out.println("GET player by email: " + mail);
        TypedQuery<Player> query = em.createQuery("SELECT p from Player as p where p.email = :mail", Player.class);
        query.setParameter("mail", mail);
        Player player = query.getSingleResult();
        return player;
    }
}
