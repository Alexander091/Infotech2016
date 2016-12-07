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
public class Animal {
    
    private double weight; 
    private int age;
    private String name;
    
    public void setWeight(double l){
        this.weight = l;
   }
    
    public void setAge(int a){
        this.age = a;
    }
    
    public void setName(String n){
        this.name = n;
    }
    
    public double getWeight(){
        return weight;
    }
    
   public int getAge(){
        return age;
    }
   
    public String getName(){
        return name;
    }
    
    public void feed(){
        System.out.println("You feed!");
 
    }
    
   public void play(){
     System.out.println("You play with!");
}
  
 }
