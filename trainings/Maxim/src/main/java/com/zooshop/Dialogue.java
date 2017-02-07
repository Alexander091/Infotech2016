package com.zooshop;

public class Dialogue {

    void sayWelcome(){

        System.out.println("Добро пожаловать в Зоомагазин! Что вам угодно?");

    }

    void sayService(){

        System.out.print("1.Поиграть с кошкой");
        System.out.println(" 2.Поиграть с собакой");
        System.out.print("3.Покормить кошку ");
        System.out.println("  4.Покормить собаку");
        System.out.print("5.Купить животное ");
        System.out.println("  6.Продать кошку ");
        System.out.print("7.Продать собаку ");
        System.out.println("   8.Посмотреть на кошку");
        System.out.println("9.Посмотреть на собаку ");
        System.out.println("Если хотите уйти, скажите exit");

    }

    void sayAnythingElse(){

        System.out.print("\nЧто-нибудь ещё?\n");
        sayService();

    }

    void sayExit(){
        System.out.println("Всего доброго!");
    }
}
