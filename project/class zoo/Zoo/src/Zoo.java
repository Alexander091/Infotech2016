import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by user on 03.12.2016.
 */

public class Zoo {

    private List<Animal> pets = new ArrayList<Animal>();

    public void buyCat(Cat cat)
    {
        this.pets.add(cat);
    }

    public void buyDog(Dog dog)
    {
        this.pets.add(dog);
    }

    public void sellCat(int num)
    {
        this.pets.remove(num-1);
    }

    public void printInfo()
    {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i< pets.size();i++)
        {
            System.out.println(this.pets.get(i));
        }
        System.out.println("Хотите посмотреть какого-то питомца?");
        String answer = scanner.nextLine();
        if(answer.equals("да") || answer.equals("Да")) {
            System.out.println("Какой питомец интересен?");
            int key = scanner.nextInt();
            System.out.println(this.pets.get(key-1).getAge() + " год");
            if (this.pets.get(key-1).isMale()==true)
                System.out.println("Мальчик");
            else
                System.out.println("Девочка");
            System.out.println(this.pets.get(key-1).getBreed());
            System.out.println(this.pets.get(key-1).getName());
        }
    }
}
