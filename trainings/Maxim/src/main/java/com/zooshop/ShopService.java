package com.zooshop;

import com.DAO.DAO;
import com.zoo.Animal;
import com.zoo.Cat;

import java.sql.SQLException;

public class ShopService  {

    public void buyAnimal(int objId){
        DAO.getDaoInstance().deleteEntityFromDatabase(objId);
    }

    public <T extends Animal> void sellAnimal(T obj) throws IllegalAccessException {
        DAO.getDaoInstance().saveEntityInDatabase(obj);
    }

    public <T extends Animal> Animal showAllAnimal(T animal, long id) throws SQLException {

        DAO.getDaoInstance().getParamsByObjectId(animal, id);
        System.out.println(animal.toString());
        return animal;
    }

    public void closeShop(){
        DAO.getDaoInstance().closeConnection();
    }

}
