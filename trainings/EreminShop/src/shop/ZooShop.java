/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import Animals.Animal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ZooShop {
    private List<Animal> pets = new ArrayList<Animal>();
    
    public void AddPet(Animal pet){
        pets.add(pet);
    }
    
    public void RemovePet(int number){
        pets.remove(number);
    }
    
    public void PrintAllPets(){
        for (int i = 0; i < pets.size(); i++) {
            System.out.println("#"+(i+1));
            pets.get(i).PrintInfo();
            System.out.println();
        }
    }

    public List<Animal> getPets() {
        return pets;
    }
}
