package fr.univtln.m2dapm.boardgame.restserver.dao.tokens;

import fr.univtln.m2dapm.boardgame.business.tokens.Ship;
import fr.univtln.m2dapm.boardgame.restserver.crud.CrudServiceBean;

public class ShipDAO {

    private CrudServiceBean crudServiceBean = CrudServiceBean.getInstance();


    /**
     * Inserts a Ship into the database.
     * @param ship: ship to insert.
     * @return Ship: the inserted ship.
     */
    public Ship createShip(Ship ship) {
        Ship createdShip = (Ship)crudServiceBean.create(ship);
        return createdShip;
    }


    /**
     * Updates a Ship in the database.
     * @param ship: the Ship to update.
     * @return Ship: the updated Ship.
     */
    public Ship updateShip(Ship ship) {
        Ship updatedShip = (Ship)crudServiceBean.update(ship);
        return updatedShip;
    }


    /**
     * Deletes a Ship from the database.
     * @param id: the Ship's id.
     * @return Ship: the deleted Ship.
     */
    public Ship deleteShip(int id) {
        Ship deletedShip = (Ship)crudServiceBean.delete(Ship.class, id);
        return deletedShip;
    }


    /**
     * Finds a Ship from the database according to the id given in parameters.
     * @param id: the Ship's id.
     * @return Ship: the Ship.
     */
    public Ship findShipById(int id) {
        return (Ship)crudServiceBean.find(Ship.class, id);
    }
}
