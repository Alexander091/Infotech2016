package com.zooshop;

import org.postgresql.util.PSQLException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Shop {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Cat cat = new Cat();
        Dog dog = new Dog();
        ShopService serv = new ShopService();
        Dialogue info = new Dialogue();
        String string = "";
        String end = "Goodbye";

        info.sayWelcome();
        do{
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            string = buff.readLine();
            switch (string){
                case "1":
                    cat.playWithAnimal();
                    break;
                case "2":
                    dog.playWithAnimal();
                    break;
                case "3":
                    cat.feed();
                    break;
                case "4":
                    dog.feed();
                    break;
                case "5":
                    System.out.println("What is name of animal?");
                    String name = buff.readLine();
                    serv.buyAnimal(name);
                    break;
                case "6":
                    System.out.println("What is name of animal?");
                    String name2 = buff.readLine();
                    serv.buyAnimal(name2);
                    break;
                case "7":
                    serv.sellCat(4,"cat4");
                    break;
                case "8":
                    serv.sellDog(5,"dog2");
                    break;
                case "9":
                    serv.showAllAnimal();
                    break;
            }
            if(!string.equals(end)){
                info.sayAnythingElse();
            }
            if(string.equals(end)){
                info.sayGoodbye();
                serv.closeShop();
            }
        }while(!string.equals(end));

    }
}
