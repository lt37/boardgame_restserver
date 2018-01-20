package fr.univtln.m2dapm.boardgame.restserver.resources.bridgedices;

import fr.univtln.m2dapm.boardgame.business.bridgedices.Bridge;
import fr.univtln.m2dapm.boardgame.business.bridgedices.SpecialWeapon;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/specialWeapons")
public class SpecialWeaponEJB {

    @Inject
    SpecialWeapon specialWeapon;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Path("/create/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createSpecialWeapon() {
        System.out.println("POST specialWeapon: " + specialWeapon);
        em.persist(specialWeapon);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SpecialWeapon getSpecialWeaponById(@PathParam("id") int id) {
        System.out.println("GET specialWeapon by id: " + id);
        SpecialWeapon specialWeapon = em.find(SpecialWeapon.class, id);
        return specialWeapon;
    }
}
