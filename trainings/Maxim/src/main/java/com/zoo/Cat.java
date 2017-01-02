package com.zoo;

import com.annotation.Attribute;
import com.annotation.ObjectType;
import com.zoo.Animal;

@ObjectType(2)
public class Cat extends Animal {

    @Attribute(6)
    private final static String kind = "Cat"; //род кошки

    @Override
    public void feed(){ //покормить кошку
        System.out.println("You feed cat!");
    }

    @Override
    public void playWithAnimal(){ // поиграть с кошкой
        System.out.println("You play with cat!");
    }
}
