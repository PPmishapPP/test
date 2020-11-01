package ru.mishapp;

import ru.mishapp.numbers.MyNumber;

public class MyCalc {
    public static MyNumber action (MyNumber firstNumber, Action action, MyNumber secondNumber) throws WrongStringException {
        switch (action){
            case PLUS -> firstNumber.plus(secondNumber);
            case MINUS -> firstNumber.minus(secondNumber);
            case MULTIPLY -> firstNumber.multiply(secondNumber);
            case DIVIDE -> firstNumber.divide(secondNumber);
            default -> throw new WrongStringException("Неизвестная операция");
        }
        return firstNumber;
    }
}
