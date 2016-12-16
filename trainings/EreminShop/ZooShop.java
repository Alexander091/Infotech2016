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
    
    public Animal getPet(int index){
        return pets.get(index);
    }
    
    public void AddPet(Animal pet){
        pets.add(pet);
    }
    
    public void RemovePet(int number){
        pets.remove(number);
    }

    public List<Animal> getPets() {
        return pets;
    }
}
