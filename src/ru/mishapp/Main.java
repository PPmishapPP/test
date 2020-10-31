package ru.mishapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws WrongStringException {
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        Calc calc;
        if (str.matches("\\d+\\s[+*\\-/]\\s\\d+")){
            calc = new ArabCalc(str);
        }else if (str.matches("[XVI]+\\s[+*\\-/]\\s[XVI]+")){
            calc = new RomeCalc(str);
        }else {
            throw new WrongStringException("Неверная строка");
        }

        System.out.println(calc.answer());

    }
}
