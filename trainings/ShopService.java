/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalshop;

/**
 *
 * @author PROGRAMMER3000
 */
import java.util.ArrayList;
 
 public class ShopService {
     
  
     static ArrayList<Cat> cats = new ArrayList<>();
     static ArrayList<Dog> dogs = new ArrayList<>();   
     static ArrayList<Dog> parrots = new ArrayList<>(); 
     
     public void sellCat(Cat x){   
          cats.remove(x);
         if(cats.size() <= 0){
         
             System.out.println("Cats have ended");
         }
     }
     public void buyCats(Cat x){   
         cats.add(x);
             System.out.println("The store " + cats.size() + " cats");
         }
     
     public void feedcats(int catFood){   
          
         catFood = catFood - cats.size();
      
             System.out.println("The store " + catFood + " catFood");
         }
     }
   