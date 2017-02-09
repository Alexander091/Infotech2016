package com.zooshop;

import com.config.ShopConfig;
import com.zoo.Animal;
import com.zoo.Cat;
import com.zoo.Dog;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class Shop {

    private static Logger LOG = Logger.getLogger(Shop.class); /*подключил логирование*/
    /**
     * создал контекст для IoC
     */
    private static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ShopConfig.class);

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException, SQLException {

        LOG.info("Приложение работает.....");
        /*
          получил бины из контейнера
         */
        Animal cat = applicationContext.getBean(Cat.class);
        Animal dog = applicationContext.getBean(Dog.class);
        ShopService sh = applicationContext.getBean(ShopService.class);

        String string;
        String end = "exit";

        applicationContext.getBean(Dialogue.class).sayWelcome();
        applicationContext.getBean(Dialogue.class).sayService();

        LOG.info("Начало цикла взаимодействия с пользователем");

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
                    Scanner animalId = new Scanner(System.in);
                    sh.buyAnimal(animalId.nextInt());
                    break;
                case "6":
                    System.out.println("Пожалуйста уточните характеристики");
                    System.out.println("Введите имя");
                    Scanner name = new Scanner(System.in);
                    cat.setName(name.next());
                    System.out.println("Введите вес");
                    Scanner weight = new Scanner(System.in);
                    cat.setWeight(weight.nextDouble());
                    System.out.println("Введите длину");
                    Scanner length = new Scanner(System.in);
                    cat.setLength(length.nextDouble());
                    System.out.println("Введите возраст");
                    Scanner age = new Scanner(System.in);
                    cat.setAge(age.nextInt());
                    System.out.println("Введите цвет");
                    Scanner colour = new Scanner(System.in);
                    cat.setColour(colour.next());
                    sh.sellAnimal(cat);
                    break;
                case "7":
                    System.out.println("Пожалуйста уточните характеристики");
                    System.out.println("Введите имя");
                    Scanner name1 = new Scanner(System.in);
                    dog.setName(name1.next());
                    System.out.println("Введите вес");
                    Scanner weight1 = new Scanner(System.in);
                    dog.setWeight(weight1.nextInt());
                    System.out.println("Введите длину");
                    Scanner length1 = new Scanner(System.in);
                    dog.setLength(length1.nextInt());
                    System.out.println("Введите возраст");
                    Scanner age1 = new Scanner(System.in);
                    dog.setAge(age1.nextInt());
                    System.out.println("Введите цвет");
                    Scanner colour1 = new Scanner(System.in);
                    dog.setColour(colour1.next());
                    sh.sellAnimal(dog);
                    break;
                case "8":
                    System.out.println("Введите id");
                    Scanner idCat = new Scanner(System.in);
                    sh.showAnimal(cat, idCat.nextInt());
                    break;
                case "9":
                    System.out.println("Введите id");
                    Scanner idDog = new Scanner(System.in);
                    sh.showAnimal(dog, idDog.nextInt());
                    break;
            }
            if(!string.equals(end)){
                applicationContext.getBean(Dialogue.class).sayAnythingElse();
            }
            if(string.equals(end)){
                applicationContext.getBean(Dialogue.class).sayExit();
                try {
                    LOG.info("Возможен exception, если магазин не был открыт");
                    sh.closeShop();
                } catch (Exception e) {
                    LOG.info("Магазин не был открыт");
                    System.out.println("Магазин ещё работает");
                }
            }
        }while(!string.equals(end));

        LOG.info("Приложение завершило работу....");
    }
}
