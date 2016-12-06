package zooshop;

public class ZooShop {
    
    public static void main(String[] args){ 
 
        Cat cat = new Cat();
        Dog dog = new Dog();
        ShopService service = new ShopService();
        
        cat.setNameCat("Lord"); 
        cat.setAgeCat(5); 
        cat.setLengthCat(0.7);
        cat.feedCat();
        cat.playWithCat();
        
        service.buyCat(cat);
        service.showLeftAnimals();
        
        
    }
    
}
