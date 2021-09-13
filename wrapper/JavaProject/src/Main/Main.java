package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię:");
        String name = scanner.nextLine();
        System.out.println("Podaj swój wiek: ");
        int age = scanner.nextInt();

        System.out.println("Siema " + name);

        if(15 <= age) {
            System.out.println("Możesz się ruchać");
        } else {
            System.out.println("Prokurator PUK PUK");
        }
    }
}
