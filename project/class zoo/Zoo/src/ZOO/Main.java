package ZOO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        Zoo zooshop = new Zoo();
        Cat cat = new Cat();
        Dog dog = new Dog();
        writeHello(cat,dog,zooshop);
    }

    private static void writeHello(Cat cat, Dog dog, Zoo zooshop) throws IOException{

        boolean flag = true;
        int object_id = 1;
        String name;
        System.out.println("Вас приветствует Зоомагазин.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (flag) {
            System.out.println("\n0 - купить кошку в магазин.\n" + "1 - купить собаку в магазин\n" + "2 - продать питомца из магазина\n" + "3 - посмотреть список животных магазина\n" + "10 - выйти из магазина");
            int key = Integer.parseInt(reader.readLine());
            switch (key){
                case 0: {
                    name = Cat.addnewAnimal(cat);
                    zooshop.buyCat(object_id,name);
                    object_id++;
                    break;
                }
                case 1: {
                    name = Dog.addnewAnimal(dog);
                    zooshop.buyDog(object_id,name);
                    object_id++;
                    break;
                }
                case 2: {
                    zooshop.printInfo();
                    System.out.println("Введите имя животного: ");
                    name = reader.readLine();
                    zooshop.sellAnimal(name);
                    break;
                }
                case 3: {
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
        cleanZoo(object_id,zooshop);
    }

    private static void cleanZoo(int object_id, Zoo zoo) {
        for(int i = 0; i < object_id; i++)
        {
            zoo.sellAnimal(i);
        }
    }
}