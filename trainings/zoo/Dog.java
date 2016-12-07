package ru.javabegin.trening.fastjava2;

public class Dog extends Animal {
    Dog() {
        name = "Bob";
        age = 99;
        System.out.println(name +" "+ age);
    }
    @Override
    public void voice() {
        super.voice();
        System.out.println("Гав-гав");
    }

    @Override
    public void eat() {
        super.eat();

    }
}
