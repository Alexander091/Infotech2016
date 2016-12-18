
public class Cat extends Animal {

    public Cat(String name, int age,String colour) {
        super(name,age,colour);
    }

    @Override
    public  void eat() {
        System.out.println("Вы покормили кота");
    }

    @Override
    public void voice() {

        System.out.println("Мяу-мяу");
    }


}