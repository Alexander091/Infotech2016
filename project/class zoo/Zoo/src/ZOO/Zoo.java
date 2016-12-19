package ZOO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 03.12.2016.
 */

public class Zoo {

    private final static int PAR_ID = 1;
    private final static int OBJ_TYPE_ID_CAT = 2;
    private final static int OBJ_TYPE_ID_DOG = 3;
    private DAO dao;

    public Zoo(){
        dao = new DAO();
    }

    protected void buyCat(int obj_id,String name)
    {
        dao.saveAnimal(obj_id, PAR_ID, OBJ_TYPE_ID_CAT,name);
    }

    public void buyDog(int obj_id,String name){
        dao.saveAnimal(obj_id, PAR_ID, OBJ_TYPE_ID_DOG,name);
    }

    protected void sellCat(String name) {
        dao.deleteAnimal(name);
    }

    protected void sellDog(String name) {
        dao.deleteAnimal(name);
    }

    protected void printInfo() {
        dao.printAllObjects();
    }
    public void closeShop(){
        dao.closeConnection();
    }

    protected void printAnimal() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Какие животные интересуют?(cat/dog)?");
        String answer = reader.readLine();
        if(answer.equals("cat"))
            dao.allCats();
        else if(answer.equals("dog"))
            dao.allDogs();
        else
            System.out.println("Не найдено такого питомца...");
    }

}
