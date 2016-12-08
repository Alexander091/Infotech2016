public abstract class Animal {

    public int getAge() {
        return age;
    }

    protected int age;

    public String getName() {
        return name;
    }

    protected String name;

    public abstract void eat();
    public abstract void voice();


}
