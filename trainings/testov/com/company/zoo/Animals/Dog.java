package com.company.zoo.Animals;

import com.company.zoo.Animal;

/**
 * Created by bote0814 on 08.12.2016.
 */
public class Dog extends Animal {

    private float dogsSpecialField;

    public Dog(Animal.Color color, int age, int price,float dogsSpecialField){
        super(color,age,price);
        this.dogsSpecialField = dogsSpecialField;
    }

    @Override
    public String voice() {
        return "Gav";
    }

    public float getDogsSpecialField(){
        return dogsSpecialField;
    }

}
