package ru.mishapp.numbers;

import ru.mishapp.WrongStringException;

public class ArabNumber implements MyNumber{

    private int value;

    public ArabNumber(String stringValue) throws WrongStringException {
        int value = Integer.parseInt(stringValue);
        if (value > 10 || value < 1){
            throw new WrongStringException("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. ");
        }
        this.value = value;
    }

    public ArabNumber(){

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void plus(MyNumber number) {
        value = value + number.getValue();
    }

    @Override
    public void minus(MyNumber number) {
        value = value - number.getValue();
    }

    @Override
    public void multiply(MyNumber number) {
        value = value * number.getValue();
    }

    @Override
    public void divide(MyNumber number) {
        value = value / number.getValue();
    }

    public String print() throws WrongStringException {
        return String.valueOf(value);
    }
}
