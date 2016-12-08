import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 03.12.2016.
 */

public class Zoo {


    private List<Animals> pets = new ArrayList<Animals>();

    public void buyCat(List list, int num)
    {
        Cat pet = new Cat();
        list.add(num,pet);
    }

    public void buyDog(List list, int num)
    {
        Dog pet = new Dog();
        list.add(num,pet);
    }

    public void sellCat(List list, int num)
    {
        list.remove(num-1);
    }

    public void printInfo(List list)
    {
        for(int i = 0; i<list.size();i++)
        {
            System.out.println((i+1) + " " + list.get(i));
        }
    }
}
