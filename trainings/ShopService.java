package zooshop;

import java.util.ArrayList;

public class ShopService {
    
    private int numberOfAnimals = 20;
    
    static ArrayList<Cat> cats = new ArrayList<>();
    static ArrayList<Dog> dogs = new ArrayList<>();   
    
    public void buyCat(Cat x){   
        cats.add(x);
        if(numberOfAnimals > 0){
            numberOfAnimals--;
        }
        else{
            System.out.println("Sorry, but all pets are selled!");
        }
    }
    public void buyDog(Dog x){   
        dogs.add(x);
        if(numberOfAnimals > 0){
            numberOfAnimals--;
        }
        else{
            System.out.println("Sorry, but all pets are selled!");
        }
    }
    
    public void showLeftAnimals(){
        System.out.println("ZooShop has "+ numberOfAnimals + " pet(s)");
    }  
}
