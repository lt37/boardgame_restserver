package fr.univtln.m2dapm.boardgame.restserver.resources.tokens;

import fr.univtln.m2dapm.boardgame.business.bridgedices.SpecialWeapon;
import fr.univtln.m2dapm.boardgame.business.tokens.Field;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@ApplicationScoped
@Path("/fields")
public class FieldEJB {

    @EJB
    Field field;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createField(Field field) {
        System.out.println("POST field: " + field);
        em.persist(field);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateField(Field field) {
        System.out.println("PUT field: " + field);
        em.merge(field);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Field getFieldById(@PathParam("id") int id) {
        System.out.println("GET field by id: " + id);
        field = em.find(Field.class, id);
        return field;
    }
}
