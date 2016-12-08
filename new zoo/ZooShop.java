import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ZooShop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int catsCount = 2;
        int dogsCount = 1;
        List<Cat> cats = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        System.out.println("Завозим животных в зоомагазин");

        for (int i = 0; i < catsCount; i++) {
            System.out.println("Введите имя кота: ");
            String name = reader.readLine();
            System.out.println("Введите возраст кота: ");
            int age = Integer.parseInt(reader.readLine());
            Cat cat = new Cat(name, age);
            cats.add(cat);

        }

        for (int i = 0; i < dogsCount; i++) {
            System.out.println("Введите имя собаки: ");
            String name = reader.readLine();
            System.out.println("Введите возраст собаки: ");
            int age = Integer.parseInt(reader.readLine());
            Dog dog = new Dog(name, age);
            dogs.add(dog);
        }

        System.out.println("Добро пожаловать! Выберите действие из предложенного списка:");
        System.out.print("1.Покормить кота ");
        System.out.print("2.Поговорить с котом ");
        System.out.println("3.Купить кота ");
        System.out.print("4.Покормить собаку");
        System.out.print("5.Поговорить с собакой");
        System.out.println("6. Купить собаку");

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String str = buff.readLine();
        Cat cat = cats.get(0);
        Dog dog = dogs.get(0);
        switch (str) {
            case "1":
                cat.eat();
                break;
            case "2":
                cat.voice();
                break;
            case "3":
                cats.remove(cat);
                break;
            case "4":
                dog.eat();
                break;
            case "5":
                dog.voice();
                break;
            case "6":
                dogs.remove(dog);
                break;
     }


    }
}

