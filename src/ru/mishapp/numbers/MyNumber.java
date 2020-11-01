package ru.mishapp.numbers;

import ru.mishapp.WrongStringException;

public interface MyNumber {
    void plus(MyNumber number);
    void minus(MyNumber number);
    void multiply(MyNumber number);
    void divide(MyNumber number);
    int getValue();
    String print() throws WrongStringException;
}
