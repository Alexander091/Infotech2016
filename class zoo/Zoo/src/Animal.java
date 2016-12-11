/**
 * Created by user on 03.12.2016.
 */
public abstract class Animal {

    private int age;
    private boolean male;
    private String breed;
    private String name;

    public void getInfo()
    {
        getAge();
        isMale();
        getBreed();
        getName();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void evolute()
    {
        System.out.println("This animal was upgrated!");
    }

    public void sleep()
    {
        System.out.println("Zzzzzz...");
    }

    public void voice()
    {
        System.out.println(" ... ");
    }
}
