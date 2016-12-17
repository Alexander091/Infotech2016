package ZOO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 03.12.2016.
 */

public class Zoo {

    private List<Animal> pets = new ArrayList<Animal>();

    protected void buyCat(Cat cat)
    {
        this.pets.add(cat);
    }

    protected void buyDog(Dog dog)
    {
        this.pets.add(dog);
    }

    protected void sellCat(int num)
    {
        this.pets.remove(num-1);
    }

    protected void printInfo() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Хотите посмотреть какого-то питомца?");
        String answer = reader.readLine();
        if(answer.equals("да") || answer.equals("Да") || answer.equals("Yes") || answer.equals("yes") || answer.equals("1")) {
            System.out.println("Какой питомец интересен?");
            int key = Integer.parseInt(reader.readLine());
            System.out.println(this.pets.get(key-1).getAge() + " год");
            if (this.pets.get(key-1).isMale()==true)
                System.out.println("Мальчик");
            else
                System.out.println("Девочка");
            System.out.println(this.pets.get(key-1).getBreed());
            System.out.println(this.pets.get(key-1).getName());
        }
    }

    protected void printIformation(){
        for (int i = 0; i< pets.size();i++)
        {
            System.out.println(this.pets.get(i));
        }
    }

}
