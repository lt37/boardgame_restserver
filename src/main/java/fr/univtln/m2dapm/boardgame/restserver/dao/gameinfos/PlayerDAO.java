package fr.univtln.m2dapm.boardgame.restserver.dao.gameinfos;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;
import fr.univtln.m2dapm.boardgame.restserver.crud.CrudServiceBean;

public class PlayerDAO {

    private CrudServiceBean crudServiceBean = CrudServiceBean.getInstance();


    /**
     * Inserts a Player into the database.
     * @param player: player to insert.
     * @return Player: the inserted player.
     */
    public Player createPlayer(Player player) {
        Player createdPlayer = (Player)crudServiceBean.create(player);
        return createdPlayer;
    }


    /**
     * Updates a Player in the database.
     * @param player: the Player to update.
     * @return Player: the updated Player.
     */
    public Player updatePlayer(Player player) {
        Player updatedPlayer = (Player)crudServiceBean.update(player);
        return updatedPlayer;
    }


    /**
     * Deletes a Player from the database.
     * @param id: the Player's id.
     * @return Player: the deleted Player.
     */
    public Player deletePlayer(int id) {
        Player deletedPlayer = (Player)crudServiceBean.delete(Player.class, id);
        return deletedPlayer;
    }


    /**
     * Finds a Player from the database according to the id given in parameters.
     * @param id: the Player's id.
     * @return Player: the Player.
     */
    public Player findPlayerById(int id) {
        return (Player)crudServiceBean.find(Player.class, id);
    }
}
