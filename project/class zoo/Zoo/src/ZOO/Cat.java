package ZOO;

/**
 * Created by user on 03.12.2016.
 */
public class Cat extends Animal {

    public Cat(int age, boolean male, String breed, String name){
        super(age,male,breed,name);
    }

    @Override
    protected void voice()
    {
        System.out.println("Mau,mau,mau");
    }

}