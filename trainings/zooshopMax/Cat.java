package zooshop;

public class Cat extends Animal {
    
    @Override
    public void feed(){ //покормить животное
        System.out.println("You feed cat!");
    }
    
    @Override
    public void playWithAnimal(){ // поиграть с животным
        System.out.println("You play with cat!");
    }
}
