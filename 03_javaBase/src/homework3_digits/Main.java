package homework3_digits;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a digit: ");
        int digit = scanner.nextInt();
//        int sum = 0;
//        int odd = 0;
        int max = 0;
        int d;

//        for (int i = 0; i <= digit; i++) {
//            sum += i;
//
//            if (i % 2 != 0) {
//                odd += i;
//            }
//        }

        while (digit > 0) {
            d = digit % 10;
            digit /= 10;
            if (d > max) {
                max = d;
            }
        }



        System.out.println(max);

    }
}
