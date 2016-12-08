public class Dog extends Animal {

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(name +" "+ age);
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
