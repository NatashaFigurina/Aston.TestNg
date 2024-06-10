public class Factorial {

    public static int calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Нельзя вычислить факториал отрицательного числа");
        }
        if (number == 0) {
            return 1;
        }
        int factorialResult = 1;
        for (int i = 1; i <= number; i++) {
            factorialResult *= i;
        }
        return factorialResult;
    }
}
