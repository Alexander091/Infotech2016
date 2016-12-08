/**
 * Created by user on 03.12.2016.
 */
public class Cat extends Animals {

    private int age;
    private double length;
    private double height;
    private String name;
    private String breed;

    public Cat()
    {

        this.age = 1;
        this.length = 0.3;
        this.height = 2.3;
        this.name = "Murzik";
        this.breed = "Siamese";

    }


    @Override
    public void voice()
    {
        System.out.println("Mau,mau,mau");
    }

}