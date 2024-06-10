import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bведите число, для которого нужно посчитать факториал: ");
        Scanner scanner = new Scanner(System.in);
        int factorial = Factorial.calculateFactorial(scanner.nextInt());
        System.out.println("Результат вычислений: " + factorial);
    }
}
