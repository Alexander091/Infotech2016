public class Dog extends Animal {

    public Dog(String name, int age,String colour) {
        super(name,age,colour);
    }

    @Override
    public void voice() {
        System.out.println("Гав-гав");
    }

    @Override
    public void eat() {
        System.out.println("Вы покормили собаку");
    }

}
