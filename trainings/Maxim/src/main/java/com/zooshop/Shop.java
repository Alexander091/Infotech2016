package com.zooshop;

import com.DAO.DAO;
import com.zoo.Animal;
import com.zoo.Cat;
import com.zoo.Dog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class Shop {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException, SQLException {

        Animal cat = new Cat();
        Animal dog = new Dog();                  //TODO Dependency Injecion
        ShopService sh = new ShopService();     //TODO добавить инициализацию, в DAO и ShopService,
        Dialogue info = new Dialogue();         //TODO сделать спринговские бины
        String string;
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
                    System.out.println("What id");
                    Scanner idCat = new Scanner(System.in);
                    sh.buyAnimal(idCat.nextInt());
                    break;
                case "6":
                    System.out.println("What id");
                    Scanner idDog = new Scanner(System.in);
                    sh.buyAnimal(idDog.nextInt());
                    break;
                case "7":
                    System.out.println("Please, put data about cat, which you want buy");
                    System.out.println("Enter name");
                    Scanner name = new Scanner(System.in);
                    cat.setName(name.next());
                    System.out.println("Enter weight");
                    Scanner weight = new Scanner(System.in);
                    cat.setWeight(weight.nextDouble());
                    System.out.println("Enter length");
                    Scanner length = new Scanner(System.in);
                    cat.setLength(length.nextDouble());
                    System.out.println("Enter age");
                    Scanner age = new Scanner(System.in);
                    cat.setAge(age.nextInt());
                    System.out.println("Enter colour");
                    Scanner colour = new Scanner(System.in);
                    cat.setColour(colour.next());
                    sh.sellAnimal(cat);
                    break;
                case "8":
                    System.out.println("Please, put data about dog, which you want sell");
                    System.out.println("Enter name");
                    Scanner name1 = new Scanner(System.in);
                    dog.setName(name1.next());
                    System.out.println("Enter weight");
                    Scanner weight1 = new Scanner(System.in);
                    dog.setWeight(weight1.nextInt());
                    System.out.println("Enter length");
                    Scanner length1 = new Scanner(System.in);
                    dog.setLength(length1.nextInt());
                    System.out.println("Enter age");
                    Scanner age1 = new Scanner(System.in);
                    dog.setAge(age1.nextInt());
                    System.out.println("Enter colour");
                    Scanner colour1 = new Scanner(System.in);
                    dog.setColour(colour1.next());
                    sh.sellAnimal(dog);
                    break;
                case "9":
                    System.out.println("Enter id");
                    Scanner id = new Scanner(System.in);
                    //sh.showAllAnimal(id.nextInt());
                    break;
            }
            if(!string.equals(end)){
                info.sayAnythingElse();
            }
            if(string.equals(end)){
                info.sayGoodbye();
                sh.closeShop();
            }
        }while(!string.equals(end));

    }
}
