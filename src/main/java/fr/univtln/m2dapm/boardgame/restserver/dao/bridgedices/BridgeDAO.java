package fr.univtln.m2dapm.boardgame.restserver.dao.bridgedices;

import fr.univtln.m2dapm.boardgame.business.bridgedices.Bridge;
import fr.univtln.m2dapm.boardgame.restserver.crud.CrudServiceBean;

public class BridgeDAO {

    private CrudServiceBean crudServiceBean = CrudServiceBean.getInstance();


    /**
     * Inserts a Bridge into the database.
     * @param bridge: bridge to insert.
     * @return Bridge: the inserted bridge.
     */
    public Bridge createBridge(Bridge bridge) {
        Bridge createdBridge = (Bridge)crudServiceBean.create(bridge);
        return createdBridge;
    }


    /**
     * Updates a Bridge in the database.
     * @param bridge: the Bridge to update.
     * @return Bridge: the updated Bridge.
     */
    public Bridge updateBridge(Bridge bridge) {
        Bridge updatedBridge = (Bridge)crudServiceBean.update(bridge);
        return updatedBridge;
    }


    /**
     * Deletes a Bridge from the database.
     * @param id: the Bridge's id.
     * @return Bridge: the deleted Bridge.
     */
    public Bridge deleteBridge(int id) {
        Bridge deletedBridge = (Bridge)crudServiceBean.delete(Bridge.class, id);
        return deletedBridge;
    }


    /**
     * Finds a Bridge from the database according to the id given in parameters.
     * @param id: the Bridge's id.
     * @return Bridge: the Bridge.
     */
    public Bridge findBridgeById(int id) {
        return (Bridge)crudServiceBean.find(Bridge.class, id);
    }
}
