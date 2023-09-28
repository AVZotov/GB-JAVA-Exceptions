package ru.gb.seminar002;

public class Exercise003 {
    public static void main(String[] args) {
        int a = 90;
        int b = 3;
        int[] array = {1, 2};
        try {
            System.out.println(a / b);
        } catch (ArithmeticException ex) {
            System.out.println("Что-то пошло не так...");

        }
        printSum(23, 234);
        try {
            array[3] = 9;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

}
