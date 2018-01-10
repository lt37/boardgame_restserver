package fr.univtln.m2dapm.boardgame.restserver.dao.specialWeapondices;

import fr.univtln.m2dapm.boardgame.business.bridgedices.SpecialWeapon;
import fr.univtln.m2dapm.boardgame.restserver.crud.CrudServiceBean;

public class SpecialWeaponDAO {

    private CrudServiceBean crudServiceBean = CrudServiceBean.getInstance();


    /**
     * Inserts a SpecialWeapon into the database.
     * @param specialWeapon: specialWeapon to insert.
     * @return SpecialWeapon: the inserted specialWeapon.
     */
    public SpecialWeapon createSpecialWeapon(SpecialWeapon specialWeapon) {
        SpecialWeapon createdSpecialWeapon = (SpecialWeapon)crudServiceBean.create(specialWeapon);
        return createdSpecialWeapon;
    }


    /**
     * Updates a SpecialWeapon in the database.
     * @param specialWeapon: the SpecialWeapon to update.
     * @return SpecialWeapon: the updated SpecialWeapon.
     */
    public SpecialWeapon updateSpecialWeapon(SpecialWeapon specialWeapon) {
        SpecialWeapon updatedSpecialWeapon = (SpecialWeapon)crudServiceBean.update(specialWeapon);
        return updatedSpecialWeapon;
    }


    /**
     * Deletes a SpecialWeapon from the database.
     * @param id: the SpecialWeapon's id.
     * @return SpecialWeapon: the deleted SpecialWeapon.
     */
    public SpecialWeapon deleteSpecialWeapon(int id) {
        SpecialWeapon deletedSpecialWeapon = (SpecialWeapon)crudServiceBean.delete(SpecialWeapon.class, id);
        return deletedSpecialWeapon;
    }


    /**
     * Finds a SpecialWeapon from the database according to the id given in parameters.
     * @param id: the SpecialWeapon's id.
     * @return SpecialWeapon: the SpecialWeapon.
     */
    public SpecialWeapon findSpecialWeaponById(int id) {
        return (SpecialWeapon)crudServiceBean.find(SpecialWeapon.class, id);
    }
}
