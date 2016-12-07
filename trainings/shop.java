/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package animalshop;

public class shop {
 static int catFood = 20;
     public static void main(String[] args){ 
  
         Cat cat = new Cat();
         ShopService service = new ShopService();
         
         cat.setName("Joni"); 
         cat.setAge(2); 
         cat.setWeight(3);
         cat.play();
         
         service.buyCats(cat);
         service.buyCats(cat);
         service.buyCats(cat);
         
         
         service.feedcats(catFood);
         
         
     }
     
 }