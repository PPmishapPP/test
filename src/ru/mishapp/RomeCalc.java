package ru.mishapp;

public class RomeCalc extends ArabCalc{

    public RomeCalc(String str) throws WrongStringException {
        String[] strArr = super.getArr(str);
        super.setFirstNumber(RomeNumber.valueOf(strArr[0]).getValue());
        super.setAction(Action.getAction(strArr[1].charAt(0)));
        super.setSecondNumber(RomeNumber.valueOf(strArr[2]).getValue());
    }

    @Override
    public String answer() throws WrongStringException {
        return arabToRome(super.answer());
    }

    private String arabToRome(String arabNumber) throws WrongStringException {
        StringBuilder romeNumber = new StringBuilder();
        int n = Integer.parseInt(arabNumber);
        if (n < 0) {
            throw new WrongStringException("Хотя в задании и сказано \"На выходе числа не ограничиваются по величине и могут быть любыми.\"," +
                    " википедия говорит, что римскими цифрми записывают только натуральные числа");
        }
        if (n == 100) return "C";
        int tens = n / 10;
        if (tens == 9){
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
        }else {
            romeNumber.append("X".repeat(tens));
        }
        n = n % 10;
        if (n > 0) {
            romeNumber.append(RomeNumber.getRomeNumber(n));
        }

        return String.valueOf(romeNumber);
    }

    enum RomeNumber{
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
        RomeNumber(int x){
            this.x = x;
        }
        public int getValue(){
            return x;
        }
        public static RomeNumber getRomeNumber(int value) {
            for (RomeNumber romeNumber : values()){
                if (romeNumber.x == value){
                    return romeNumber;
                }
            }
            return UNKNOWN;
        }
    }
}
