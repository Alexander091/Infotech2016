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
    private final String breed;
    
    public Dog(String name, int age, double weight, String breed) {
        this.setName(name);
        this.setAge(age);
        this.setWeight(weight);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void PrintInfo() {
        System.out.println("Species: " + this.GetSpecies());
        super.PrintInfo();
        System.out.println("Breed: " + breed);
    }

    @Override
    public String GetSpecies() {
        return "Dog";
    }
}
