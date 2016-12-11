/**
 * Created by user on 03.12.2016.
 */
public class Dog extends Animal {

    public Dog(int age, boolean male, String breed, String name)
    {
        setAge(age);
        setMale(male);
        setBreed(breed);
        setName(name);
    }

    @Override
    public void voice() {
        System.out.println("Gav,gav,gav");
    }
}