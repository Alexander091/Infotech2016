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
        String string;                          // TODO сделать спринговские бины
        String end = "Goodbye";

        Dialogue.sayWelcome();
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
                    System.out.println("Какой id");
                    Scanner idCat = new Scanner(System.in);
                    sh.buyAnimal(idCat.nextInt());
                    break;
                case "6":
                    System.out.println("Какой id");
                    Scanner idDog = new Scanner(System.in);
                    sh.buyAnimal(idDog.nextInt());
                    break;
                case "7":
                    System.out.println("Пожалуйста уточните характеристики");
                    System.out.println("Введите name");
                    Scanner name = new Scanner(System.in);
                    cat.setName(name.next());
                    System.out.println("Введите weight");
                    Scanner weight = new Scanner(System.in);
                    cat.setWeight(weight.nextDouble());
                    System.out.println("Введите length");
                    Scanner length = new Scanner(System.in);
                    cat.setLength(length.nextDouble());
                    System.out.println("Введите age");
                    Scanner age = new Scanner(System.in);
                    cat.setAge(age.nextInt());
                    System.out.println("Введите colour");
                    Scanner colour = new Scanner(System.in);
                    cat.setColour(colour.next());
                    sh.sellAnimal(cat);
                    break;
                case "8":
                    System.out.println("Пожалуйста уточните характеристики");
                    System.out.println("Введите name");
                    Scanner name1 = new Scanner(System.in);
                    dog.setName(name1.next());
                    System.out.println("Введите weight");
                    Scanner weight1 = new Scanner(System.in);
                    dog.setWeight(weight1.nextInt());
                    System.out.println("Введите length");
                    Scanner length1 = new Scanner(System.in);
                    dog.setLength(length1.nextInt());
                    System.out.println("Введите age");
                    Scanner age1 = new Scanner(System.in);
                    dog.setAge(age1.nextInt());
                    System.out.println("Введите colour");
                    Scanner colour1 = new Scanner(System.in);
                    dog.setColour(colour1.next());
                    sh.sellAnimal(dog);
                    break;
                case "9":
                    System.out.println("Введите id");
                    Scanner id = new Scanner(System.in);
                    sh.showAllAnimal(cat,id.nextInt());
                    break;
            }
            if(!string.equals(end)){
                Dialogue.sayAnythingElse();
            }
            if(string.equals(end)){
                Dialogue.sayGoodbye();
                try {
                    sh.closeShop();
                } catch (Exception e) {
                    System.out.println("Магазин ещё работает");
                }
            }
        }while(!string.equals(end));

    }
}
