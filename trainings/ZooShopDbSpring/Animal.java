public class Animal {
    private int id;
    private String name;
    private int age;
    private String colour;

    public Animal() {

    }

    protected Animal(String name, int age, String colour) {
        this.name = name;
        this.age = age;
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String toString() {
        return String.format("[%s - %s - %s ]", name, age, colour);
    }
}
