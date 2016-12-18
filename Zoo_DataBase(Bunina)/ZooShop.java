import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ZooShop {
    public static void main(String[] args) throws IOException {

        ConnectionBD bd = new ConnectionBD();
        String query = "Select * From objects";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int catsCount = 2;
        int dogsCount = 1;
        List<Cat> cats = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        System.out.println("Завозим животных в зоомагазин");

//заполняем таблицу objects(тут в таблицу идет только имя , и вроде как мы знаем что parent_id=1, а o_t_id  котов 2, а собак 3)
        try {
            Statement statement = bd.getConnection().createStatement();
               for (int i = 0; i < catsCount; i++) {
                System.out.println("Введите имя кота: ");
                String name = reader.readLine();
                System.out.println("Введите возраст кота: ");
                int age = Integer.parseInt(reader.readLine());
                System.out.println("Какого цвета кот? ");
                String colour =  reader.readLine();
                Cat cat = new Cat(name, age, colour);
                cats.add(cat);
               statement.execute("INSERT INTO objects(parent_id,object_type_id,name) VALUES(1,2" + ",'"+name+"');");

            }

            for (int i = 0; i < dogsCount; i++) {
                System.out.println("Введите имя собаки: ");
                String name = reader.readLine();
                System.out.println("Введите возраст собаки: ");
                int age = Integer.parseInt(reader.readLine());
                System.out.println("Какого цвета пес? ");
                String colour =  reader.readLine();
                Dog dog = new Dog(name, age, colour);
                dogs.add(dog);
                statement.execute("INSERT INTO objects(parent_id,object_type_id,name) VALUES(1,3" + ",'"+name+"');");


            }
//вывод всего что есть в objects
            System.out.println("Наши ребята из objects:");
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int parent_id = resultSet.getInt("parent_id");
                int object_type_id = resultSet.getInt("object_type_id");
                String name = resultSet.getString("name");
                int object_id = resultSet.getInt("object_id");
                System.out.println( parent_id+ " " +  object_type_id + " " + name+ " " + object_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
