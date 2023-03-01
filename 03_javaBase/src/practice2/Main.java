package practice2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Привет, неизвестный!");
        } else {
            System.out.println("Привет, " + name + "!");
        }
    }
}
