package com.zooshop;

import com.DAO.DAO;
import com.zoo.Animal;
import com.zoo.Cat;

import java.sql.SQLException;

public class ShopService  {

    private DAO dao;

    public ShopService() {
        dao = new DAO();
    }

    public void buyAnimal(int objId){
        dao.delete(objId);
    }

    public <T extends Animal> void sellAnimal(T obj) throws IllegalAccessException {
        dao.save(obj);
    }

    public void showAllAnimal(long id) throws SQLException {
        try {
          Cat cat =  dao.getObject(Cat.class,id);
            System.out.println(cat.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    public void closeShop(){
        dao.closeConnection();
    }

}
