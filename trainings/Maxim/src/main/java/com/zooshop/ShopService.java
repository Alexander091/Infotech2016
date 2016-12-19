package com.zooshop;

import java.util.ArrayList;

public class ShopService  {

    private final static int PAR_ID_CAT = 1;
    private final static int PAR_ID_DOG = 1;
    private final static int OBJ_TYPE_ID_CAT = 2;
    private final static int OBJ_TYPE_ID_DOG = 3;
    private DAO dao;

    public ShopService() {
        dao = new DAO();
    }

    public void buyAnimal(String name){
        dao.deleteAnimal(name);
    }

    public void sellCat(int obj_id,String name){
        dao.saveAnimal(obj_id, PAR_ID_CAT, OBJ_TYPE_ID_CAT, name);
    }

    public void sellDog(int obj_id,String name){
        dao.saveAnimal(obj_id, PAR_ID_DOG, OBJ_TYPE_ID_DOG, name);
    }

    public void showAllAnimal(){
        dao.printAllObjects();
    }
    public void closeShop(){
        dao.closeConnection();
    }

}
