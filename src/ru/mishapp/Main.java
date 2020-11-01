package ru.mishapp;

import ru.mishapp.numbers.ArabNumber;
import ru.mishapp.numbers.MyNumber;
import ru.mishapp.numbers.RomeNumber;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws WrongStringException {
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        String[] strArr = getArr(str);
        Action action = Action.getAction(strArr[1].charAt(0));
        MyNumber firstNumber, secondNumber, answer;

        if (str.matches("\\d+\\s[+*\\-/]\\s\\d+")){
            firstNumber = new ArabNumber(strArr[0]);
            secondNumber = new ArabNumber(strArr[2]);
        }else if (str.matches("[XVI]+\\s[+*\\-/]\\s[XVI]+")){
            firstNumber = new RomeNumber(strArr[0]);
            secondNumber = new RomeNumber(strArr[2]);
        }else {
            throw new WrongStringException("Неверная строка");
        }
        answer = MyCalc.action(firstNumber, action, secondNumber);
        System.out.println(answer.print());
    }

    private static String[] getArr(String str) throws WrongStringException {
        String[] strArr = str.split(" ");
        if (strArr.length != 3) {
            throw new WrongStringException("Хотя в задании точно не сказано, что числа и операторы " +
                    "должны быть отделены пробелом, в примерах всегда именно так, поэтому вот :)");
        }
        return strArr;
    }
}
