package com.zooshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shop {

    public static void main(String[] args) throws IOException {
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
                    Cat pitomec = new Cat("Lord","Orange",5,1.2,4.1);
                    serv.buyAnimal(pitomec);
                    System.out.println(pitomec);
                    break;
                case "6":
                    Dog pitomec2 = new Dog("Sharic","Black",4,2.0,7.0);
                    serv.buyAnimal(pitomec2);
                    System.out.println(pitomec2);
                    break;
                case "7":
                    serv.sellAnimal(cat);
                    break;
                case "8":
                    serv.sellAnimal(dog);
                    break;
                case "9":
                    System.out.println("The ZooShop has " + serv.showLeftAnimals() + " pets");
                    break;
            }
            if(!string.equals(end)){
                info.sayAnythingElse();
            }
            if(string.equals(end)){
                info.sayGoodbye();
            }
        }while(!string.equals(end));

    }
}
