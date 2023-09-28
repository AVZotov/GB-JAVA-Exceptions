package ru.gb.seminar002;

import java.util.Scanner;

public class Exercise001 {
    public static void main(String[] args) {
        System.out.println(getFloat());
    }
    public static float getFloat(){
        boolean flag = true;
        System.out.print("enter your value: ");
        float result = 0;

        while (flag){
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextFloat()){
                result = scanner.nextFloat();
                flag = false;
                scanner.close();
            }
            else {
                System.out.print("You entered wrong value, pls try again: ");
            }
        }
        return result;
    }
}
