package com.zoo;

import com.annotation.Attribute;
import com.annotation.ObjectType;
import com.zoo.Animal;

@ObjectType(2)
public class Cat extends Animal {

    /*
    * уникальный атрибут кошки
    */

    @Attribute(6)
    private String kind = "Cat"; //род кошки

    /*
    * переопределенные методы игры и кормёжки
    */

    @Override
    public void feed(){ //покормить кошку
        System.out.println("Кот покормлен");
    }

    @Override
    public void playWithAnimal(){ // поиграть с кошкой
        System.out.println("Вы поиграли с котом");
    }

    @Override
    public String toString() {
        return "Род " + kind + " " + super.toString();
    }
}
