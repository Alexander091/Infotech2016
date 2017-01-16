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

    /*public void showAllAnimal(long id) throws SQLException {
        try {
          Cat cat =  DAO.getDaoInstance().getParamsByObjectId(id);
            System.out.println(cat.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }*/

    public void closeShop(){
        DAO.getDaoInstance().closeConnection();
    }

}
