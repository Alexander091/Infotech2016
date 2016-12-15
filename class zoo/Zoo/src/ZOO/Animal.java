package ZOO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 03.12.2016.
 */
public abstract class Animal {

    private int age;
    private boolean male;
    private String breed;
    private String name;


    public Animal(int age, boolean male, String breed, String name){
        setAge(age);
        setMale(male);
        setBreed(breed);
        setName(name);
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected boolean isMale() {
        return male;
    }

    protected void setMale(boolean male) {
        this.male = male;
    }

    protected String getBreed() {
        return breed;
    }

    protected void setBreed(String breed) {
        this.breed = breed;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected static void addnewAnimal(Animal animal) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Какой возраст питомца нужен?");
        animal.age = Integer.parseInt(reader.readLine());
        System.out.println("Мальчик/девочка(true/false)?");
        animal.male = Boolean.parseBoolean(reader.readLine());
        System.out.println("Какой породы?");
        animal.breed = reader.readLine();
        System.out.println("Какое имя дать?");
        animal.name = reader.readLine();
    }

    protected void voice(){
        System.out.println("Uuuuuu...");
    }

}
