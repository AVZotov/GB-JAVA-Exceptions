package ru.gb.seminar002;

import java.util.Scanner;

public class Exercise004 {
    public static void main(String[] args) {
        System.out.println(getString());
    }
    public static String getString(){
        System.out.print("Enter your input here: ");
        Scanner scanner = new Scanner(System.in);
        String result = null;
        result = scanner.nextLine();

        if (result.isEmpty()){
            throw new RuntimeException("Error! Your input can't be empty string!");
        }
        return result;
    }
}
