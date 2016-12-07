/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animals;

/**
 *
 * @author User
 */
public class Dog extends Animal{
    
    public Dog(String name, int age, double weight, String breed) {
        super(name, age, weight, breed);
    }

    @Override
    public String getSpecies() {
        return "Dog";
    }
}
