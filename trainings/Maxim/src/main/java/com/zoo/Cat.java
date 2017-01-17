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
        System.out.println("You feed cat!");
    }

    @Override
    public void playWithAnimal(){ // поиграть с кошкой
        System.out.println("You play with cat!");
    }

    /*
    * геттеры и сеттеры
    */

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "kind='" + kind + '\'' +
                "} " + super.toString();
    }
}
