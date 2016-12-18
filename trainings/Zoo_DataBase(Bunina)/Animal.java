public abstract class Animal {

    protected Animal (String name, int age,String colour) {
        this.name = name;
        this.age = age;
        this.colour = colour;
        //System.out.println(name +" "+ age  +" "+ colour);
    }


    protected String colour;
    public String getColour() {
        return colour;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected int age;

    public String getName() {
        return name;
    }

    protected String name;

    public abstract void eat();
    public abstract void voice();


}
