package ru.mishapp.numbers;


import ru.mishapp.WrongStringException;

public class RomeNumber extends ArabNumber {


    public RomeNumber(String stringValue) throws WrongStringException {
        super.setValue(Number.valueOf(stringValue).getValue());
        if (super.getValue() == 0) {
            throw new WrongStringException("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. ");
        }
    }

    @Override
    public String print() throws WrongStringException {
        StringBuilder romeNumber = new StringBuilder();
        int n = super.getValue();
        if (n < 1) {
            throw new WrongStringException("Хотя в задании и сказано \"На выходе числа не ограничиваются по величине и могут быть любыми.\"," +
                    " википедия говорит, что римскими цифрми записывают только натуральные числа");
        }
        if (n == 100) return "C";
        int tens = n / 10;
        if (tens == 9) {
            romeNumber.append("XC");
            n = n - 90;
        }
        if (n - 50 > 0) {
            romeNumber.append("L");
            n = n - 50;
        }

        tens = n / 10;
        if (tens == 4) {
            romeNumber.append("XL");
        } else {
            romeNumber.append("X".repeat(tens));
        }
        n = n % 10;
        if (n > 0) {
            romeNumber.append(Number.getRomeNumber(n));
        }

        return String.valueOf(romeNumber);

    }

    enum Number {
        I(1),
        II(2),
        III(3),
        IV(4),
        V(5),
        VI(6),
        VII(7),
        VIII(8),
        IX(9),
        X(10),
        UNKNOWN(0);
        private final int x;

        Number(int x) {
            this.x = x;
        }

        public static Number getRomeNumber(int value) {
            for (Number number : values()) {
                if (number.x == value) {
                    return number;
                }
            }
            return UNKNOWN;
        }

        public int getValue() {
            return x;
        }
    }
}
