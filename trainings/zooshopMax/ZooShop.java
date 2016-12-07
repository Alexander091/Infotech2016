package zooshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZooShop {
    
    public static void main(String[] args) throws IOException{ 
 
        Cat cat = new Cat();
        Dog dog = new Dog();
        ShopService serv = new ShopService();
        
        String string = "";
        String end = "Goodbye";
        
        System.out.println("Hello!Nice to meet you in my 'Zoo Shop'! What do you want to do?");
        System.out.print("1.Play with cat ");
        System.out.println(" 2.Play with dog");
        System.out.print("3.Feed cat ");
        System.out.println(" 4.Feed dog");
        System.out.print("5.Buy cat ");
        System.out.println(" 6.Buy dog");
        System.out.print("7.Sell cat ");
        System.out.println(" 8.Sell dog");
        System.out.println("9.Show how animals have ZooShop?");
        System.out.println("If You don't want anything say 'Goodbye!'");
        
        do{
        BufferedReader buff = new BufferedReader (new InputStreamReader (System.in));
        string = buff.readLine();
        switch (string){
            case "1":
                cat.playWithAnimal();
                break;
            case "2":
                dog.playWithAnimal();
                break;
            case "3":
                cat.feed();
                break;
            case "4":
                dog.feed();
            break;
            case "5":
                serv.buyAnimal(cat);
            break;
            case "6":
                serv.buyAnimal(dog);
            break;
            case "7":
                serv.sellAnimal(cat);
            break;
            case "8":
                serv.sellAnimal(dog);
            break;
            case "9":
                System.out.println("The ZooShop has " + serv.showLeftAnimals() + " pets");
            break;
        }
        if(!string.equals(end)){
            System.out.print("\nAnything else? ");
            System.out.print("1.Play with cat ");
            System.out.println(" 2.Play with dog");
            System.out.print("3.Feed cat ");
            System.out.println(" 4.Feed dog");
            System.out.print("5.Buy cat ");
            System.out.println(" 6.Buy dog");
            System.out.print("7.Sell cat ");
            System.out.println(" 8.Sell dog");
            System.out.println("9.Show how animals have ZooShop?");
            System.out.println("If You don't want anything say 'Goodbye!'");
        }
        if(string.equals(end)){
            System.out.println("Goodbye,Sir!");
        }
        }while(!string.equals(end));
        
        
      
        
    }
    
}
