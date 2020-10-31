package ru.mishapp;

public class ArabCalc implements Calc{
    private int firstNumber;
    private int secondNumber;
    private Action action;

    public ArabCalc(String str) throws WrongStringException {
        String[] strArr = getArr(str);
        firstNumber = Integer.parseInt(strArr[0]);
        secondNumber = Integer.parseInt(strArr[2]);
        if (firstNumber > 10 || firstNumber < 1 || secondNumber > 10 || secondNumber < 1){
            throw new WrongStringException("Калькулятор должен принимать на вход числа от 1 до 10 включительно");
        }
        action = Action.getAction(strArr[1].charAt(0));
    }

    public ArabCalc() {
    }

    protected void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    protected void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    protected void setAction(Action action) {
        this.action = action;
    }

    protected String[] getArr(String str) throws WrongStringException {
        String[] strArr = str.split(" ");
        if (strArr.length != 3) {
            throw new WrongStringException("Хотя в задании точно не сказано, что числа и операторы " +
                    "должны быть отделены пробелом, в примерах всегда именно так, поэтому вот :)");
        }
        return strArr;
    }

    @Override
    public String answer() throws WrongStringException{
        switch (action){
            case PLUS -> {
                return String.valueOf(firstNumber + secondNumber);
            }
            case MINUS -> {
                return String.valueOf(firstNumber - secondNumber);
            }
            case MULTIPLY -> {
                return String.valueOf(firstNumber * secondNumber);
            }
            case DIVIDE -> {
                return String.valueOf(firstNumber / secondNumber);
            }
        }
        throw new WrongStringException("Неизвестная операция");
    }
}
