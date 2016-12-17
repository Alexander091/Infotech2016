import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by user on 08.12.2016.
 */
public class Main {


    public static void main(String[] args) throws IOException
    {
        Zoo zooshop = new Zoo();
        Cat cat = new Cat(1,false, "Siamese", "Murka");
        Dog dog = new Dog(2,true,"Mops", "Sharik");

        int age = 0;
        boolean male = false;
        String breed = " ",name = " ";

        zooshop.buyCat(cat);
        zooshop.buyDog(dog);

        boolean flag = true;
        int numSellList = 0;
        System.out.println("Вас приветствует Зоомагазин.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (flag) {
            System.out.println("\n0 - добавить кошку в магазин.\n" + "1 - добавить собаку в магазин\n" + "2 - удалить животное из магазинв\n" + "3 - посмотреть список животных магазина\n" + "10 - выйти из магазина");
            int key = Integer.parseInt(reader.readLine());
            if(key == 0) {
                addnewAnimal(age, male, breed, name);
                cat = new Cat(age,male,breed,name);
                zooshop.buyCat(cat);
            }
            else if(key == 1) {
                addnewAnimal(age, male, breed, name);
                dog = new Dog(age,male,breed,name);
                zooshop.buyDog(dog);
            }
            else if(key == 2) {
                zooshop.printInfo();
                numSellList = Integer.parseInt(reader.readLine());
                zooshop.sellCat(numSellList);
                continue;
            }
            else if(key == 3)
                zooshop.printInfo();
            else if(key == 10) {
                zooshop.printInfo();
                flag = false;
                break;
            }
            else {
                System.out.println("Что-то пошло не так...\nКонец программы...");
                flag = false;
                break;
            }
        }
    }

    public static void addnewAnimal (int age,boolean male,String breed,String name)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какой возраст питомца нужен?");
        age = scanner.nextInt();
        System.out.println("Мальчик/девочка(true/false)?");
        male = scanner.nextBoolean();
        System.out.println("Какой породы?");
        breed = scanner.next();
        System.out.println("Какое имя дать?");
        name = scanner.next();
    }
}