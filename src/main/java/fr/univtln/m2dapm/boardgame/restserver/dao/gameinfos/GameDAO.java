package fr.univtln.m2dapm.boardgame.restserver.dao.gameinfos;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Game;
import fr.univtln.m2dapm.boardgame.restserver.crud.CrudServiceBean;

public class GameDAO {

    private CrudServiceBean crudServiceBean = CrudServiceBean.getInstance();


    /**
     * Inserts a Game into the database.
     * @param game: game to insert.
     * @return Game: the inserted game.
     */
    public Game createGame(Game game) {
        Game createdGame = (Game)crudServiceBean.create(game);
        return createdGame;
    }


    /**
     * Updates a Game in the database.
     * @param game: the Game to update.
     * @return Game: the updated Game.
     */
    public Game updateGame(Game game) {
        Game updatedGame = (Game)crudServiceBean.update(game);
        return updatedGame;
    }


    /**
     * Deletes a Game from the database.
     * @param id: the Game's id.
     * @return Game: the deleted Game.
     */
    public Game deleteGame(int id) {
        Game deletedGame = (Game)crudServiceBean.delete(Game.class, id);
        return deletedGame;
    }


    /**
     * Finds a Game from the database according to the id given in parameters.
     * @param id: the Game's id.
     * @return Game: the Game.
     */
    public Game findGameById(int id) {
        return (Game)crudServiceBean.find(Game.class, id);
    }
}
