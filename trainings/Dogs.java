package animalshop;

import java.util.Random;

public class Dogs implements Animals{

    @Override
    public void animalLength() {
       Random rnd = new Random(System.currentTimeMillis());
       double l = 0.2 + rnd.nextInt(2);
       System.out.println("Length dog " + l + " m");
    }

    @Override
    public void animalName(String s) {
       System.out.println("Name dog " + s); 
    }

    @Override
    public void animalHeigth() {
       Random rnd = new Random(System.currentTimeMillis());
       double h = 0.15 + rnd.nextInt(1);
       System.out.println("Heigth dog " + h + " m");
    }

    @Override
    public void animalAge() {
       Random rnd = new Random(System.currentTimeMillis());
       int A = rnd.nextInt(15);
       System.out.println("Age dog " + A + " years");
    }
    
}