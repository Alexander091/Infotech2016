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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inLine = new Scanner(System.in);
        ZooShop zs = new ZooShop();
        InitZooShop(zs);
        boolean work = true;
        double foodWeight = 0.1;
        
        while(work){
            Menu(0);
            String g = inLine.nextLine();
            
            switch(Integer.parseInt(g)){
                case 1: 
                    zs.PrintAllPets();
                    Menu(1);
                    g = inLine.nextLine();
                    switch(Integer.parseInt(g)){
                        case 1:
                            Menu(11);
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

    private static void Menu(int mode) {
        if(mode == 0){
            System.out.println("1: Показать всех животных");
            System.out.println("2: Выход");
        }
        if(mode == 1){
            System.out.println("1: Покормить животное");
            System.out.println("2: Назад");
        }
        if(mode == 11){
            System.out.print("Введите номер животного: ");
        }
    }
    
    private static void InitZooShop(ZooShop zs){
        Cat cat = new Cat("Barsik", 3, 4.5, "Siamese");
        zs.AddPet(cat);
        Dog dog = new Dog("Bobik", 7, 35, "Doberman");
        zs.AddPet(dog);
        cat = new Cat("Markiz", 9, 4, "American Bobtail");
        zs.AddPet(cat);
        dog = new Dog("Zhulik", 16, 9.7, "Pooch");
        zs.AddPet(dog);
    }
}
