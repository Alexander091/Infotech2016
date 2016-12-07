import java.util.ArrayList;

/**
 * Created by user on 03.12.2016.
 */
public class Animals {
    int age;
    int length;
    int height;
    String Name;

    public void Evolute()
    {
        System.out.println("This animal was upgrated!");
    }

    public void getName(String Name)
    {
        Name = this.Name;
    }

    public void sleep()
    {
        System.out.println("Zzzzzz...");
    }
}
