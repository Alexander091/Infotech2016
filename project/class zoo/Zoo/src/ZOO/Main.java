package ZOO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        Zoo zooshop = new Zoo();
        Cat cat = new Cat(1,false, "Siamese", "Murka");
        Dog dog = new Dog(2,true,"Mops", "Sharik");
        zooshop.buyCat(4,"Murka");
        zooshop.buyDog(5,"Sharik");
        Menu(cat,dog,zooshop);
    }

    protected static void Menu(Cat cat, Dog dog, Zoo zooshop) throws IOException{

        boolean flag = true;
        String name;
        System.out.println("Вас приветствует Зоомагазин.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (flag) {
            System.out.println("\n0 - добавить кошку в магазин.\n" + "1 - добавить собаку в магазин\n" + "2 - удалить кошку из магазина\n" + "3 удалить собаку из магазина\n" + "4 - посмотреть список животных магазина\n" + "10 - выйти из магазина");
            int key = Integer.parseInt(reader.readLine());
            switch (key){
                case 0: {
                    name = Cat.addnewAnimal(cat);
                    zooshop.buyCat(4,name);
                    break;
                }
                case 1: {
                    name = Dog.addnewAnimal(dog);
                    zooshop.buyDog(5,name);
                    break;
                }
                case 2: {
                    zooshop.printInfo();
                    System.out.println("Введите имя животного: ");
                    name = reader.readLine();
                    zooshop.sellCat(name);
                    break;
                }
                case 3: {
                    zooshop.printInfo();
                    System.out.println("Введите имя животного: ");
                    name = reader.readLine();
                    zooshop.sellDog(name);
                    break;
                }
                case 4: {
                    zooshop.printInfo();
                    zooshop.printAnimal();
                    break;
                }
                case 10: {
                    zooshop.printInfo();
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Что-то пошло не так...\nКонец программы...");
                    zooshop.closeShop();
                    flag = false;
                    break;
                }
            }
        }
    }
}