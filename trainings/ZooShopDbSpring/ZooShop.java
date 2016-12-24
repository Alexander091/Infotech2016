import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ZooShop {
    public static void main(String[] args) throws IOException {

        Animal animal = new Animal();
        animal.setName("Барсик");
        animal.setAge(21);
        animal.setColour("черный");
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
       AnimalDao animalDao = (AnimalDao) context.getBean("animalDao");
       animalDao.saveAnimal(animal);

        animalDao.getAllCats();

    }
}


