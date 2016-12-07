package ru.javabegin.trening.fastjava2;


import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;

public class Cat extends Animal {

    Cat() {
        name = "Барсик";
        age =5;
        System.out.println(name +" "+ age);
    }

    @Override
    public void voice() {
        super.voice();
        System.out.println("Мяу-мяу");
    }




}
