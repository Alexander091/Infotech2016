package ru.javabegin.trening.fastjava2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // write your code here
        int catsCount = 3;
        int dogsCount = 2;

        ArrayList<Animal> animals = new ArrayList<>();

        for (int i = 0; i < catsCount; i++) {
            Cat cat = new Cat();
            animals.add(cat);
        }

        for (int i = 0; i < dogsCount; i++) {
            Dog dog = new Dog();
            animals.add(dog);
        }

        for (int i = 0; i < animals.size(); i++) {
            animals.get(i).voice();
            animals.get(i).eat();
        }
    }
}

