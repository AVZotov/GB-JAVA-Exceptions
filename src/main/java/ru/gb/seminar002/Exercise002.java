package ru.gb.seminar002;

public class Exercise002 {
    public static void main(String[] args) {


    }

    public static void Task1_printResult(int[] array, int index, int divider) {
        if (index >= array.length) {
            System.out.println("Index is out of array length");
            return;
        }
        if (divider == 0) {
            System.out.println("Dividing by zero not allowed");
        } else {
            System.out.println("caughtRes1 = " + array[index] / divider);
        }
    }
}
