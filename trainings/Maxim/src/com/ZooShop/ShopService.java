package com.company;

import java.util.ArrayList;

public class ShopService {

    private ArrayList<Animal> pet = new ArrayList<Animal>();

    public void buyAnimal(Animal a){

        if(pet.size() > 0){
            pet.remove(a);
        }
        else{
            System.out.println("Sorry, but all pets are selled!");
        }
    }
    public void sellAnimal(Animal a){
        pet.add(a);
    }

    public int showLeftAnimals(){
        return pet.size();
    }
}
