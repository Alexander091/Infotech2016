package com.company.zoo;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bote0814 on 08.12.2016.
 */
public class AnimalShop implements Shop {

    private Map<Class,List<Animal>> animals;

    public AnimalShop(List<Class> typesOfAnimals){
        animals = new HashMap<>();
        for(Class c : typesOfAnimals){
            animals.put(c,new ArrayList<Animal>());
        }
    }


    @Override
    public void addAnimal(Animal animal) {
        animals.get(animal.getClass()).add(animal);
    }

    @Override
    public void addAnimals(List<Animal> animals) {
        for(Animal a : animals){
            addAnimal(a);
        }
    }

    @Override
    @Nullable
    public Animal sellAnimal(Class clazz, Animal.Color color, int age, int maxPrice) throws Exception {
        if(Animal.class != clazz) throw new Exception("clazz должен наследовать Animal");
        List<Animal> animalsForSearch = animals.get(clazz);
        for(Animal animal : animalsForSearch){
            if(animal.getAge() == age && animal.getColor() == color && animal.getPrice() < maxPrice){
                animalsForSearch.remove(animal);
                return animal;
            }
        }
        return null;
    }
}
