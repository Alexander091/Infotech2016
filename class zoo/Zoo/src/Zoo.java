import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by user on 03.12.2016.
 */

public class Zoo {

    public static void main(String[] args) throws IOException
    {

        ArrayList<Dog> dogs = new ArrayList<Dog>();
        Dog Sharik = new Dog();
        dogs.add(Sharik);
        Sharik.age = 1;
        Sharik.height = 10;
        Sharik.length = 100;
        String NameS = "Murzik";
        Sharik.getName(NameS);
        Sharik.Evolute();
        Sharik.sleep();
        Sharik.voice();

        ArrayList<Cat> cats = new ArrayList<Cat>();
        Cat Murzik = new Cat();
        cats.add(Murzik);
        Murzik.age = 1;
        Murzik.height = 5;
        Murzik.length = 50;
        String NameM = "Murzik";
        Murzik.getName(NameM);
        Murzik.Evolute();
        Murzik.sleep();
        Murzik.voice();
    }
}
