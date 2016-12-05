/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop;

import java.util.ArrayList;
import java.util.List;

public class Petshop {

   public static class Cat{
    
       private String color;
       private String kind;
       private String name;
       private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "My cat is "+ age+ " old. "
                    + "\nname: "+name
                    +"\ncolor: "+ color
                    +"\nkind: "+ kind + "\n";
           // return super.toString(); //To change body of generated methods, choose Tools | Templates.
        }
         
       
   }
   public static class Dog{
       private String color;
       private String kind;
       private String name;
       private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "My dog is "+ age+ " old. "
                    + "\nname: "+name
                    +"\ncolor: "+ color
                    +"\nkind: "+ kind+"\n";
        }
        
        
       
       
       
   }
   
   static List<Cat> cats = new ArrayList<>();
   static List<Dog> dogs = new ArrayList<>();
   
  //static List<Cat> cats;
   public static void main(String[] args) {
       // create some animals
       Cat cat1 = new Cat();
       Dog dog1 = new Dog();
       
       //change status
       cat1.setAge(1); //cat1.age = 1;
       cat1.setColor("black");
       cat1.setKind("Британская");
       cat1.setName("Bars");
       System.out.println(cat1);
       
       
       dog1.setAge(3); 
       dog1.setColor("white");
       dog1.setKind("Тойтерьер");
       dog1.setName("Sima");
       System.out.println(dog1);
       
       // add to lists
       cats.add(cat1);
       dogs.add(dog1);
       
       //print lists
       System.out.println(cats);
       System.out.println(dogs);
       
       //взять объект
       cats.remove(cat1);
       System.out.println(cats);
       
       // print
       
       
        
   }
    
}
