package com.zooshop;

import com.DAO.DAO;
import com.zoo.Animal;

import java.sql.SQLException;
import java.util.Iterator;

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

    public void showAllAnimal(int id) throws SQLException {
       System.out.println(dao.get(id));
    }

    public void closeShop(){
        dao.closeConnection();
    }

}
