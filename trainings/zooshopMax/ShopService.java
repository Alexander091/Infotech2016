package zooshop;

import java.util.ArrayList;

public class ShopService {
    
    private int numberOfAnimals = 20;
    
    ArrayList<Animal> pet = new ArrayList<>(); 
    
    public void buyAnimal(Animal a){   
        pet.remove(a);
        if(numberOfAnimals > 0){
            numberOfAnimals--;
        }
        else{
            System.out.println("Sorry, but all pets are selled!");
        }
    }
    public void sellAnimal(Animal a){   
        pet.add(a);
        numberOfAnimals++;
    }
    
    public int showLeftAnimals(){
        return numberOfAnimals;
    }  
}
