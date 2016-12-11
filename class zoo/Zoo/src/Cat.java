/**
 * Created by user on 03.12.2016.
 */
public class Cat extends Animal {

    public Cat(int age, boolean male, String breed, String name)
    {
        setAge(age);
        setMale(male);
        setBreed(breed);
        setName(name);
    }

    @Override
    public void voice()
    {
        System.out.println("Mau,mau,mau");
    }

}