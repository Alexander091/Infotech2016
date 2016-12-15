package ZOO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 08.12.2016.
 */
public class Main {


    public static void main(String[] args) throws IOException
    {
        Zoo zooshop = new Zoo();
        Cat cat = new Cat(1,false, "Siamese", "Murka");
        Dog dog = new Dog(2,true,"Mops", "Sharik");

        zooshop.buyCat(cat);
        zooshop.buyDog(dog);

        Menu(cat,dog,zooshop);

    }

    protected static void Menu(Cat cat, Dog dog, Zoo zooshop) throws IOException{

        boolean flag = true;
        int numSellList = 0;
        System.out.println("Вас приветствует Зоомагазин.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (flag) {
            System.out.println("\n0 - добавить кошку в магазин.\n" + "1 - добавить собаку в магазин\n" + "2 - удалить животное из магазинв\n" + "3 - посмотреть список животных магазина\n" + "10 - выйти из магазина");
            int key = Integer.parseInt(reader.readLine());
            switch (key){
                case 0: {
                    Cat.addnewAnimal(cat);
                    zooshop.buyCat(cat);
                    break;
                }
                case 1: {
                    Dog.addnewAnimal(dog);
                    zooshop.buyDog(dog);
                    break;
                }
                case 2: {
                    zooshop.printInfo();
                    numSellList = Integer.parseInt(reader.readLine());
                    zooshop.sellCat(numSellList);
                    break;
                }
                case 3: {
                    zooshop.printIformation();
                    zooshop.printInfo();
                    break;
                }
                case 10: {
                    zooshop.printIformation();
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Что-то пошло не так...\nКонец программы...");
                    flag = false;
                    break;
                }
            }
        }
    }
}