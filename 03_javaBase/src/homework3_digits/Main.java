package homework3_digits;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a digit: ");
        int digit = scanner.nextInt();
        int sum = 0;
        int odd = 0;
        int max = 0;

        for (int i = 0; i <= digit; i++) {
            sum += i;

            if (i % 2 != 0) {
                odd += i;
            }
        }

        while (digit > 0) {
            if ((digit % 10) > max) {
                max = (digit % 10);
            }
            digit /= 10;
        }

        System.out.println("Cумма цифр: " + sum);
        System.out.println("Cумма нечётных чисел: " + odd);
        System.out.println("Максимальная цифра: " + max);
    }

}
