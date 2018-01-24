package fr.univtln.m2dapm.boardgame.restserver.resources.bridgedices;

import fr.univtln.m2dapm.boardgame.business.bridgedices.Bridge;
import fr.univtln.m2dapm.boardgame.business.bridgedices.SpecialWeapon;

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
@Path("/specialWeapons")
public class SpecialWeaponEJB {

    @EJB
    SpecialWeapon specialWeapon;

    @PersistenceContext(unitName = "persistence")
    EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createSpecialWeapon(SpecialWeapon specialWeapon) {
        System.out.println("POST specialWeapon: " + specialWeapon);
        em.persist(specialWeapon);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateSpecialWeapon(SpecialWeapon specialWeapon) {
        System.out.println("PUT specialWeapon: " + specialWeapon);
        em.merge(specialWeapon);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SpecialWeapon getSpecialWeaponById(@PathParam("id") int id) {
        System.out.println("GET specialWeapon by id: " + id);
        specialWeapon = em.find(SpecialWeapon.class, id);
        return specialWeapon;
    }
}
