/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalshop;


import java.util.ArrayList; 
import java.util.Scanner;


 public class ShopService {
     static ArrayList<Cat> cats = new ArrayList<>();
     static ArrayList<Dog> dogs = new ArrayList<>();   
     
     
     public void byCats(Cat x){   
              cats.add(x); }
     public void byDogs(Dog x){   
              dogs.add(x); }
     
     public int menu() {
       
        Scanner in = new Scanner(System.in);
                 System.out.println("Меню");
                 System.out.println("1| Посмотреть питомцев ");
                 System.out.println("2| Преобрести питомца ");
                 System.out.println("3| Продать питомца \n4| Выйти");

int i = in.nextInt();
    if (i==1) {
            System.out.println("Look: \n1| Cat \n2| Dog ");  
            int w = in.nextInt();
            if (w==1) catlist(); else doglist();
              return 0;
                }
    if (i==2) {
          System.out.println("By: \n1| Cat \n2| Dog ");   
          int h = in.nextInt(); 
                if (h==1){ 
                    Cat cat = new Cat();  
                    byCats(cat);
                    System.out.print("Введите кличку -"); 
                    cat.setName(in.next()); 
                    System.out.print("Введите возраст -"); 
                    cat.setAge(in.nextInt()); 
                    System.out.print("Введите породу -"); 
                    cat.setBreed(in.next());
                         } 
                else { 
                    Dog dog = new Dog();  
                    byDogs(dog);
                    System.out.print("Введите кличку -"); 
                    dog.setName(in.next()); 
                    System.out.print("Введите возраст -"); 
                    dog.setAge(in.nextInt()); 
                    System.out.print("Введите породу -"); 
                    dog.setBreed(in.next());
                       }
                    
        return 0;        
        }
    if (i==3) {
        System.out.println("Sell: \n1| Cat \n2| Dog ");  
            int h = in.nextInt();
            if (h==1) {
                catlist();
             System.out.println("Введите номер");
             int z = in.nextInt();
             cats.remove(z);
                    } else { 
                              doglist();
                              System.out.println("Введите номер");
                              int z = in.nextInt();
                              dogs.remove(z);
                            }
    
    
    }
            else  {return 1;}                  
         return 0;    
                }
                
      
    public void catlist(){
        if (cats.size()==0) System.out.println("Cats have ended"); else
       for(int i=0;i < cats.size(); i++){
            System.out.print(i+" - " +cats.get(i).getName()+" | ");
            
         } System.out.println();
     
}
    public void doglist(){
        if (dogs.size()==0) System.out.println("Dogs have ended"); else
       for(int i=0;i < dogs.size(); i++){
            System.out.print(i+" - " +dogs.get(i).getName()+" | ");
              
         }  System.out.println();
     
}  
    

    
}
