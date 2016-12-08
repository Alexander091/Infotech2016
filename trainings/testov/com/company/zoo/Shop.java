package com.company.zoo;

import java.util.List;

/**
 * Created by bote0814 on 08.12.2016.
 */
public interface Shop {
    void addAnimal(Animal animal);
    Animal sellAnimal(Class c, Animal.Color color, int age, int maxPrice) throws Exception;
    void addAnimals(List<Animal> animals);

}
