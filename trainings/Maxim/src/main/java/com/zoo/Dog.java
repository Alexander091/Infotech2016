package com.zoo;

import com.annotation.Attribute;
import com.annotation.ObjectType;
import com.zoo.Animal;

/*
* все комментарии для Cat
* справедливы и для этого класса
*/

@ObjectType(3)
public class Dog extends Animal {

    @Attribute(6)
    private String kind = "Wolf"; // род волки

    @Override
    public void feed(){ //покормить животное
        System.out.println("You feed dog!");
    }

    @Override
    public void playWithAnimal(){ // поиграть с животным
        System.out.println("You play with dog!");
    }
}
