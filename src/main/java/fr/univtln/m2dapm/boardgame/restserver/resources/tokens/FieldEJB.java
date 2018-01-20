package fr.univtln.m2dapm.boardgame.restserver.resources.tokens;

import fr.univtln.m2dapm.boardgame.business.bridgedices.SpecialWeapon;
import fr.univtln.m2dapm.boardgame.business.tokens.Field;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/fields")
public class FieldEJB {

    @Inject
    Field field;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Path("/create/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createField() {
        System.out.println("POST field: " + field);
        em.persist(field);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Field getFieldById(@PathParam("id") int id) {
        System.out.println("GET field by id: " + id);
        Field field = em.find(Field.class, id);
        return field;
    }
}
