package homework3_digits;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a digit: ");
        int dig = Math.abs(scanner.nextInt());
        int sum = 0;
        int odd = 0;
        int max = 0;
        int tail;

        while (dig > 0) {
            tail = dig % 10;

            sum += tail;

            if ((tail % 2) != 0) {
                odd += tail;
            }

            if (tail > max) {
                max = tail;
            }

            dig /= 10;
        }

        System.out.println("Cумма цифр: " + sum);
        System.out.println("Cумма нечётных чисел: " + odd);
        System.out.println("Максимальная цифра: " + max);
    }

}
