package com.zooshop;

import com.DAO.DAO;
import com.zoo.Cat;

import java.io.IOException;

public class Shop {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {
        Cat cat = DAO.getObject(Cat.class);
        cat.setName("Murzik");
        cat.setColour("Black");
        cat.setAge(1);
        System.out.println(cat);
        //Dog dog = DAO.getObject(Dog.class);
       /* ShopService serv = new ShopService(); //TODO добавить инициализацию, в DAO и ShopService,
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
                    System.out.println("Please, put data about cat, which you want buy");
                    Scanner sc = new Scanner(System.in);
                    while (!sc.hasNext()){
                        cat.setName(sc.next());
                        cat.setWeight(sc.nextDouble());
                        cat.setLength(sc.nextDouble());
                        cat.setAge(sc.nextInt());
                        cat.setColour(sc.next());
                    }
                    //System.out.println("What is id of animal?");
                    //Scanner bc = new Scanner(System.in);
                    //serv.buyAnimal(bc.nextInt());
                    break;
                case "6":
                    System.out.println("What is id of animal?");
                    Scanner bd = new Scanner(System.in);
                    serv.buyAnimal(bd.nextInt());
                    break;
                case "7":
                    Scanner scanner = new Scanner(System.in);
                        serv.sellCat(scanner.nextInt(), "cat");
                    break;
                case "8":
                    Scanner scanner1 = new Scanner(System.in);
                    serv.sellDog(scanner1.nextInt(), "dog");
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
        }while(!string.equals(end));*/

    }
}
