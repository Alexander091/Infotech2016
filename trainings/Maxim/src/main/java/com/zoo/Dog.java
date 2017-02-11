package com.zoo;

import com.annotation.Attribute;
import com.annotation.ObjectType;

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
        System.out.println("Собака покормлена");
    }

    @Override
    public void playWithAnimal(){ // поиграть с животным
        System.out.println("Вы поиграли с собакой");
    }

    @Override
    public String toString() {
        return "Род " + kind + " " + super.toString();
    }
}
