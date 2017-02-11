package com.zooshop;

import com.DAO.DAO;
import com.zoo.Animal;

import java.sql.SQLException;

public class ShopService  {

    void buyAnimal(int objId){
        DAO.getDaoInstance().deleteEntityFromDatabase(objId);
    }

    <T extends Animal> void sellAnimal(T obj) throws IllegalAccessException {
        DAO.getDaoInstance().saveEntityInDatabase(obj);
    }

    <T extends Animal> Animal showAnimal(T animal, long id) throws SQLException {
        DAO.getDaoInstance().getParamsByObjectId(animal, id);
        System.out.println(animal);
        return animal;
    }

    void closeShop() throws SQLException {
        DAO.getDaoInstance().closeConnection();
    }

}
