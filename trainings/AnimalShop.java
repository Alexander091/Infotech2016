package animalshop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AnimalShop {
       
    public static void main(String[] args) throws IOException {
        ArrayList<Cats> c1 = new ArrayList<Cats>();
        ArrayList<Dogs> d1 = new ArrayList<Dogs>();

        Cats cat = new Cats();
        Dogs dog = new Dogs();
        
        String s = "";
        String name = "";
        String end = "Goodbye";
        
        System.out.println("Hello!Nice to meet you in my 'Zoo Shop'! What animal do you want to buy?");
        System.out.println("1.Cat");
        System.out.println("2.Dog");
        System.out.println("If You don't want to buy anyone say 'Goodbue!'");
        
        do{
        BufferedReader buff = new BufferedReader (new InputStreamReader (System.in));
        s = buff.readLine();
        switch (s){
            case "1":
                System.out.println("Please, choose name for cat");
                BufferedReader buff1 = new BufferedReader (new InputStreamReader (System.in));
                name = buff1.readLine();
                cat.animalName(name);
                cat.animalAge();
                cat.animalHeigth();
                cat.animalLength();
                c1.add(cat);
                break;
            case "2":
                System.out.println("Please, choose name for dog");
                BufferedReader buff2 = new BufferedReader (new InputStreamReader (System.in));
                name = buff2.readLine();
                dog.animalName(name);
                dog.animalAge();
                dog.animalHeigth();
                dog.animalLength();
                d1.add(dog);
                break;
            case "3":
                break;
        }
        if(!s.equals(end)){
            System.out.print("You buy ");     
            System.out.print(c1.size() + " cats ");
            System.out.println(d1.size() + " dogs");
            System.out.println("Anything else? 1 - Cat, 2 - Dog"); 
            System.out.println("If You don't want to buy anyone say 'Goodbye!'");}
        else if(s.equals(end)){
            System.out.print("You buy ");
            System.out.print(c1.size() + " cats ");
            System.out.println(d1.size() + " dogs");
            System.out.println("Goodbye,Sir!");
        }
        }while(!s.equals(end));
        
        
    }
    
}
