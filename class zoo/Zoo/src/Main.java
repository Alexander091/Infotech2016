import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 08.12.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException
    {
        Zoo zooshop = new Zoo();
        Cat Murzik = new Cat();
        Dog Sharik = new Dog();

        List<Animals> pets = new ArrayList<Animals>();
        pets.add(0,Murzik);
        pets.add(1,Sharik);


        boolean flag = true;
        int numAddList = 2, numSellList = 0;
        System.out.println("Вас приветствует Зоомагазин.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (flag) {
            System.out.println("\n0 - добавить кошку в магазин.\n" + "1 - добавить собаку в магазин\n" + "2 - удалить животное из магазинв\n" + "3 - посмотреть список животных магазина\n" + "10 - выйти из магазина");
            int key = Integer.parseInt(reader.readLine());
            if(key == 0) {
                zooshop.buyCat(pets, numAddList);
                numAddList++;
            }
            else if(key == 1) {
                zooshop.buyDog(pets, numAddList);
                numAddList++;
            }
            else if(key == 2) {
                zooshop.printInfo(pets);
                numSellList = Integer.parseInt(reader.readLine());
                zooshop.sellCat(pets, numSellList);
                continue;
            }
            else if(key == 3)
                zooshop.printInfo(pets);
            else if(key == 10) {
                zooshop.printInfo(pets);
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
}