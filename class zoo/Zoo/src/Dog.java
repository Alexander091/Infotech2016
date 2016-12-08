/**
 * Created by user on 03.12.2016.
 */
public class Dog extends Animals {

    private int age;
    private double length;
    private double height;
    private String name;
    private String breed;

    public Dog()
    {

        this.age = 2;
        this.length = 0.7;
        this.height = 5.4;
        this.name = "Sharik";
        this.breed = "Husky";

    }

    @Override
    public void voice() {
        System.out.println("Gav,gav,gav");
    }
}