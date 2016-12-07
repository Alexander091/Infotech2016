
package zooshop;

public class Animal {
    
    private double weight; //вес
    private double length; //длина  
    private int age;//возраст
    private String name;//клички животных
    private String colour;//цвет 
    
    public void setLength(double l){ //задаем размер
        this.length = l;
    }

    public void setAge(int a){//задаём возраст
        this.age = a;
    }

    public void setName(String n){//задаём имя
        this.name = n;
    }

    public void setWeight(double w){//задаём имя
        this.weight = w;
    }
    
    public void setColour(String c){ //задаем размер
        this.colour = c;
    }
    
    public double getLength(){
        return length;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public double getWeight(){
        return weight;
    }
    
    public String getColour(){
        return colour;
    }
    
    public void feed(){ //покормить животное
        System.out.println("You feed animal!");
    }

    public void playWithAnimal(){ // поиграть с животным
        System.out.println("You play with animal!");
    }
}
