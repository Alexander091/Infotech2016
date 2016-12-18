package com.zooshop;

public abstract class Animal {

        private double weight; //вес
        private double length; //длина
        private int age;//возраст
        private String name;//клички животных
        private String colour;//цвет

        protected Animal(){}

        protected Animal(String name, String colour, int age, double length, double weight){
            this.name = name;
            this.colour = colour;
            this.age = age;
            this.length = length;
            this.weight = weight;
        }

        public double getLength(){
            return length;
        }

        public int getAge(){
            return age;
        }

        public String getName(){
            return name;
        }

        public double getWeight(){
            return weight;
        }

        public String getColour(){
            return colour;
        }

        public void feed(){ //покормить животное
            System.out.println("You feed animal!");
        }

        public void playWithAnimal(){ // поиграть с животным
            System.out.println("You play with animal!");
        }

        @Override
        public String toString(){
            return
                    "Name "+this.name +
                            " colour " + this.colour +
                            " age " + this.age +
                            " length "  + this.length +
                            " weight " + this.weight;

        }
}
