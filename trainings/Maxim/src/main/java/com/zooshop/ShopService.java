package com.zooshop;

import com.DAO.DAO;

public class ShopService  {

    private DAO dao;

    public ShopService() {
        dao = new DAO();
    }

    public void buyAnimal(int objId){
        dao.deleteAnimal(objId);
    }

    public void sellCat(int objId, String name){
       // dao.saveAnimal(objId, PAR_ID_CAT, OBJ_TYPE_ID_CAT, name);
    }

    public void sellDog(int objId, String name){
       // dao.saveAnimal(objId, PAR_ID_DOG, OBJ_TYPE_ID_DOG, name);
    }

    public void showAllAnimal(){
        //dao.getAllObjects();
        System.out.println();
    }
    public void closeShop(){
        dao.closeConnection();
    }

}
