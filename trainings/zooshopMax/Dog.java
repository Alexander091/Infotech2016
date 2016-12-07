package zooshop;

public class Dog extends Animal{
    
    @Override
    public void feed(){ //покормить животное
        System.out.println("You feed dog!");
    }
    
    @Override
    public void playWithAnimal(){ // поиграть с животным
        System.out.println("You play with dog!");
    }
 }
