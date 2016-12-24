package com.zooshop;

public class ShopService  {

    private DAO dao;

    public ShopService() {
        dao = new DAO();
    }

    private final static int PAR_ID_CAT = 1;
    private final static int PAR_ID_DOG = 1;
    private final static int OBJ_TYPE_ID_CAT = 2;
    private final static int OBJ_TYPE_ID_DOG = 3;

    public void buyAnimal(int obj_id){
        dao.deleteAnimal(obj_id); //TODO использовать id вместо имени
    }

    public void sellCat(int obj_id, String name){
        dao.saveAnimal(obj_id, PAR_ID_CAT, OBJ_TYPE_ID_CAT, name);
    }

    public void sellDog(int obj_id, String name){
        dao.saveAnimal(obj_id, PAR_ID_DOG, OBJ_TYPE_ID_DOG, name);
    }

    public void showAllAnimal(){
        dao.getAllObjects();
        System.out.println(dao.getAllObjects());
    }
    public void closeShop(){
        dao.closeConnection();
    }

}
