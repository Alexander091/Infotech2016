
public class Cat extends Animal {

   public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(name +" "+ age);
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
