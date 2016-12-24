package com.zooshop;

import org.postgresql.util.PSQLException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

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
                    System.out.println("What is id of animal?");
                    Scanner bc = new Scanner(System.in);
                    serv.buyAnimal(bc.nextInt());
                    break;
                case "6":
                    System.out.println("What is id of animal?");
                    Scanner bd = new Scanner(System.in);
                    serv.buyAnimal(bd.nextInt());
                    break;
                case "7":
                    Scanner sellCat = new Scanner(System.in);
                    serv.sellCat(sellCat.nextInt(), "cat");
                    break;
                case "8":
                    Scanner sellDog = new Scanner(System.in);
                    serv.sellDog(sellDog.nextInt(), "dog");
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
