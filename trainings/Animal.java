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
abstract class Animal {
     
    private int age;
    private String name, breed;
    
    public void setBreed(String l){
        this.breed = l;
   }
    
    public void setAge(int a){
        this.age = a;
    }
    
    public void setName(String n){
        this.name = n;
    }
    
    public String getBreed(){
        return breed;
    }
    
   public int getAge(){
        return age;
    }
   
    public String getName(){
        return name;
    }
    
    


 
    
    


  
 }
