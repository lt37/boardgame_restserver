package fr.univtln.m2dapm.boardgame.restserver.resources.gameinfos;

import com.google.gson.Gson;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;
import fr.univtln.m2dapm.boardgame.restserver.crud.CrudServiceBean;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/players")
public class PlayerResource {

    CrudServiceBean<Player> crudServiceBean = new CrudServiceBean<>();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPlayer(Player player) {
        System.out.println("POST player: " + player);
        crudServiceBean.create(player);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePlayer(Player player) {
        System.out.println("PUT player: " + player);
        crudServiceBean.update(player);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPlayerById(@PathParam("id") int id) {
        System.out.println("GET player by id: " + id);
        Player player = crudServiceBean.find(Player.class, id);
        Gson gson = new Gson();
        return gson.toJson(player);
    }


    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePlayerById(@PathParam("id") int id) {
        System.out.println("DELETE player with id: " + id);
        crudServiceBean.delete(Player.class, id);
    }
}
