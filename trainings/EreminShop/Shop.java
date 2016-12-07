/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import Animals.Cat;
import Animals.Dog;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Shop {
    private static final int MENU_MODE_SHOW_MAIN_MENU = 1;
    private static final int MENU_MODE_SHOW_ALL_ANIMALS = 11;
    private static final int MENU_MODE_CHOOSE_NUMBER_OF_ANIMAL = 111;

    public static void main(String[] args) {
        Scanner inLine = new Scanner(System.in);
        ZooShop zs = new ZooShop();
        initZooShop(zs);
        boolean work = true;
        double foodWeight = 0.1;
        
        while(work){
            menu(MENU_MODE_SHOW_MAIN_MENU);
            String g = inLine.nextLine();
            
            switch(Integer.parseInt(g)){
                case 1: 
                    printAllPets(zs);
                    menu(MENU_MODE_SHOW_ALL_ANIMALS);
                    g = inLine.nextLine();
                    
                    switch(Integer.parseInt(g)){
                        case 1:
                            menu(MENU_MODE_CHOOSE_NUMBER_OF_ANIMAL);
                            int numOfPet = Integer.parseInt(inLine.nextLine())-1;
                            zs.getPets().get(numOfPet).setWeight(zs.getPets().get(numOfPet).getWeight()+foodWeight);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    work = false;
                    break;
            }
                
            
            System.out.println();
        }
    }

    private static void menu(int mode) {
        if(mode == MENU_MODE_SHOW_MAIN_MENU){
            System.out.println("1: Показать всех животных");
            System.out.println("2: Выход");
        }
        if(mode == MENU_MODE_SHOW_ALL_ANIMALS){
            System.out.println("1: Покормить животное");
            System.out.println("2: Назад");
        }
        if(mode == MENU_MODE_CHOOSE_NUMBER_OF_ANIMAL){
            System.out.print("Введите номер животного: ");
        }
    }
    
    private static void initZooShop(ZooShop zs){
        Cat cat = new Cat("Barsik", 3, 4.5, "Siamese");
        zs.AddPet(cat);
        Dog dog = new Dog("Bobik", 7, 35, "Doberman");
        zs.AddPet(dog);
        cat = new Cat("Markiz", 9, 4, "American Bobtail");
        zs.AddPet(cat);
        dog = new Dog("Zhulik", 16, 9.7, "Pooch");
        zs.AddPet(dog);
    }

    private static void printAllPets(ZooShop zs) {
        for (int i = 0; i < zs.getPets().size(); i++) {
            System.out.println("#"+(i+1));
            System.out.println(zs.getPets().get(i).getSpecies());
            System.out.println(zs.getPets().get(i).getName());
            System.out.println(zs.getPets().get(i).getAge());
            System.out.println(zs.getPets().get(i).getWeight());
            System.out.println(zs.getPets().get(i).getBreed());
            System.out.println();
        }
    }
}
