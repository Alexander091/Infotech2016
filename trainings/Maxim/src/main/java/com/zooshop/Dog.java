package com.zooshop;

public class Dog extends Animal{

    public Dog (String name, String colour, int age, double length, double weight){
        super(name,colour,age,length,weight);
    }

    public Dog(){}

    @Override
    public void feed(){ //покормить животное
        System.out.println("You feed dog!");
    }

    @Override
    public void playWithAnimal(){ // поиграть с животным
        System.out.println("You play with dog!");
    }
}
