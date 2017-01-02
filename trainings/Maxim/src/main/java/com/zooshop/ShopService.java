package com.zooshop;

import com.DAO.DAO;

public class ShopService  {

    private DAO dao;

    public ShopService() {
        dao = new DAO();
    }

    private final static int PAR_ID_CAT = 1;
    private final static int PAR_ID_DOG = 1;
    private final static int OBJ_TYPE_ID_CAT = 2;
    private final static int OBJ_TYPE_ID_DOG = 3;

    public void buyAnimal(int objId){
        dao.deleteAnimal(objId); //TODO использовать id вместо имени
    }

    public void sellCat(int objId, String name){
       // dao.saveAnimal(objId, PAR_ID_CAT, OBJ_TYPE_ID_CAT, name);
    }

    public void sellDog(int objId, String name){
       // dao.saveAnimal(objId, PAR_ID_DOG, OBJ_TYPE_ID_DOG, name);
    }

    public void showAllAnimal(){
        dao.getAllObjects();
        System.out.println();
    }
    public void closeShop(){
        dao.closeConnection();
    }

}
