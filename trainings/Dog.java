package zooshop;

public class Dog {
   
    private double lengthDog; 
    private int ageDog;
    private String nameDog;
   
    public void setLengthDog(double l){ 
        this.lengthDog = l;
    }
   
    public void setAgeDog(int a){//задаём возраст
        this.ageDog = a;
    }
   
    public void setNameDog(String n){//задаём имя
        this.nameDog = n;
    }
   
    public double getLengthDog(){
        return lengthDog;
    }

    public int getAgeDog(){
        return ageDog;
    }

    public String getNameDog(){
        return nameDog;
    }

    public void feedDog(){
        System.out.println("You feed dog!");
    }

    public void playWithDog(){
        System.out.println("You play with dog!");
    }

 }
