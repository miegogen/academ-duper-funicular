package homework1_average;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter beginning of range: ");
        int begin = scanner.nextInt();
        System.out.print("Enter ending of range: ");
        int end = scanner.nextInt();
        int result = 0;
        int length = end - begin;

        while (begin <= end) {
            result += begin;
            begin++;
            System.out.println("Begin: " + begin + "   Result: " + result);
        }

        System.out.println("Average is: " + (result / length));
    }
}
