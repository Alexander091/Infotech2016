package zooshop;

public class Cat {
    
   private double lengthCat; //длина котов/кошек  
   private int ageCat;//возраст котов/кошек
   private String nameCat;//Клички животных
   
   public void setLengthCat(double l){ //задаем размер
       this.lengthCat = l;
   }
   
   public void setAgeCat(int a){//задаём возраст
       this.ageCat = a;
   }
   
   public void setNameCat(String n){//задаём имя
       this.nameCat = n;
   }
   
   public double getLengthCat(){
       return lengthCat;
   }
   
   public int getAgeCat(){
       return ageCat;
   }
   
   public String getNameCat(){
       return nameCat;
   }
   
   public void feedCat(){
       System.out.println("You feed cat!");
   }
   
   public void playWithCat(){
       System.out.println("You play with cat!");
   }
   
}
