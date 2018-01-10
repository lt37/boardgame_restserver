package fr.univtln.m2dapm.boardgame.restserver.dao.tokens;

import fr.univtln.m2dapm.boardgame.business.tokens.Field;
import fr.univtln.m2dapm.boardgame.restserver.crud.CrudServiceBean;

public class FieldDAO {

    private CrudServiceBean crudServiceBean = CrudServiceBean.getInstance();


    /**
     * Inserts a Field into the database.
     * @param field: field to insert.
     * @return Field: the inserted field.
     */
    public Field createField(Field field) {
        Field createdField = (Field)crudServiceBean.create(field);
        return createdField;
    }


    /**
     * Updates a Field in the database.
     * @param field: the Field to update.
     * @return Field: the updated Field.
     */
    public Field updateField(Field field) {
        Field updatedField = (Field)crudServiceBean.update(field);
        return updatedField;
    }


    /**
     * Deletes a Field from the database.
     * @param id: the Field's id.
     * @return Field: the deleted Field.
     */
    public Field deleteField(int id) {
        Field deletedField = (Field)crudServiceBean.delete(Field.class, id);
        return deletedField;
    }


    /**
     * Finds a Field from the database according to the id given in parameters.
     * @param id: the Field's id.
     * @return Field: the Field.
     */
    public Field findFieldById(int id) {
        return (Field)crudServiceBean.find(Field.class, id);
    }
}
