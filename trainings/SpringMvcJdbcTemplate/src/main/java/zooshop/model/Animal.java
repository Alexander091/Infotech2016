package zooshop.model;

import zooshop.annotation.Attribute;

public class Animal  extends Entity {

    @Attribute(11)
    private int age;
    @Attribute(33)
    private String name;
    @Attribute(22)
    private String colour;


    public Animal() {

    }

    protected Animal(String name, int age, String colour) {
        this.name = name;
        this.age = age;
        this.colour = colour;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

//    @Override
//    public String toString() {
//        StringBuilder result = new StringBuilder();
//        result.append("Name:").append(name).append("Age:").append(age).append("Color:").append(colour);
//        return result.toString();
//    }

    @Override
    public String toString(){
        return
                super.toString() +
                        " Name "+this.name +
                        " colour " + this.colour +
                        " age " + this.age ;

    }
}
