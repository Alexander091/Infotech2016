package com.company.zoo.Animals;

import com.company.zoo.Animal;

/**
 * Created by bote0814 on 08.12.2016.
 */
public class Cat extends Animal {

    private String catsSpecialField;

    public Cat(Animal.Color color, int age, int price,String catsSpecialField){
        super(color,age,price);
        this.catsSpecialField =catsSpecialField;
    }

    @Override
    public String voice() {
        return "Miu";
    }

    public String getCatsSpecialField(){
        return catsSpecialField;
    }
}
