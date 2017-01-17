package com.zooshop;

public class Dialogue {

    private static final Dialogue DIALOGUE = new Dialogue();

    private Dialogue(){};

    public static Dialogue getDialogue(){

        return DIALOGUE;

    }

    public static void sayWelcome(){

        System.out.println("Добро пожаловать в Зоомагазин! Что вам угодно?");

    }

    public static void sayService(){

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

    public static void sayAnythingElse(){

        System.out.print("\nЧто-нибудь ещё?\n");
        Dialogue.sayService();

    }

    public static void sayExit(){
        System.out.println("Всего доброго!");
    }
}
