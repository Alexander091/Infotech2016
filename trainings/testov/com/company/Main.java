package com.company;

import com.company.zoo.Animal;
import com.company.zoo.Shop;
import com.company.zoo.AnimalShop;
import com.company.zoo.Animals.*;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Class> typesOfAnimals = new ArrayList<>();
        typesOfAnimals.add(Cat.class);
        typesOfAnimals.add(Dog.class);
        Shop animalShop = new AnimalShop(typesOfAnimals);

        addAnimals(animalShop);


        try {
            Animal cat = animalShop.sellAnimal(Cat.class, Animal.Color.White, 10, 40);
            Animal dog =animalShop.sellAnimal(Dog.class, Animal.Color.Red, 6, 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {//вот тут точно упадет ошибка
            Animal something = animalShop.sellAnimal(Shop.class, Animal.Color.White, 10, 40);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public static void addAnimals(Shop shop) {

        shop.addAnimal(new Cat(Animal.Color.Black, 2, 100, "Котовские дела"));
        shop.addAnimal(new Cat(Animal.Color.White, 10, 50, "Котовские дела"));
        shop.addAnimal(new Dog(Animal.Color.Black, 2, 100, 10.0f));
        shop.addAnimal(new Dog(Animal.Color.Black, 2, 100, 10.0f));

        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat(Animal.Color.Black, 2, 100, "Котовские дела"));
        animals.add(new Cat(Animal.Color.White, 10, 50, "Котовские дела"));
        animals.add(new Dog(Animal.Color.Black, 2, 100, 10.0f));
        animals.add(new Dog(Animal.Color.Black, 2, 100, 10.0f));
        shop.addAnimals(animals);
    }
}