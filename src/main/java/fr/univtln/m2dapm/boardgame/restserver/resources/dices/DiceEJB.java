package fr.univtln.m2dapm.boardgame.restserver.resources.dices;

import fr.univtln.m2dapm.boardgame.business.board.Square;
import fr.univtln.m2dapm.boardgame.business.dices.Dice;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/dices")
public class DiceEJB {

    @Inject
    Dice dice;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Path("/create/{nbfaces}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createDice(@PathParam("nbfaces") int nbfaces) {
        System.out.println("POST dice: " + dice);
        dice.setNbSides(nbfaces);
        em.persist(dice);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dice getDiceById(@PathParam("id") int id) {
        System.out.println("GET dice by id: " + id);
        Dice dice = em.find(Dice.class, id);
        return dice;
    }
}
