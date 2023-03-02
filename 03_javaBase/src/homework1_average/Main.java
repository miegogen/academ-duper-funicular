package homework1_average;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter beginning of range: ");
        int begin = scanner.nextInt();
        System.out.print("Enter ending of range: ");
        int end = scanner.nextInt();

        int resultAll = 0;
        int resultEven = 0;
        int countAll = 0;
        int countEven = 0;

        while (begin <= end) {
            if (begin % 2 == 0) {
                resultEven += begin;
                countEven++;
            }

            resultAll += begin;
            countAll++;

            begin++;
        }

        // Замечания: сделать счётчик всех переменных,
        //            реализовать average чётных чисел

        System.out.println("AverageAll is: " + (resultAll / countAll));
        System.out.println("AverageOdd is: " + (resultEven / countEven));
    }

}
