package ru.gb.seminar001;


import java.util.Arrays;

public class Seminar001_HW {
    public static void main(String[] args) {
        int[] a = {4, 5, 6};
        int[] b = {1, 2, 0};
        System.out.println(Arrays.toString(subArrays(a, b)));
    }

    public static void arrayOutOfBoundsException() {
        int[] array = new int[10];
        int a = array[11];
    }

    public static void divisionByZero() {
        int a = 10;
        int b = 0;
        int c = a / b;
    }

    public static void numberFormatException() {
        int a = Integer.parseInt("a");
    }

    public static int[] subArrays(int[] a, int[] b) {
        if (a.length != b.length) {
            return new int[1];
        }
        int[] result = new int[a.length];

        for (int i = 0; i < result.length; i++) {
            if (b[i] == 0) {
                throw new RuntimeException("division by zero");

            }
            result[i] = a[i] / b[i];
        }
        return result;
    }
}
