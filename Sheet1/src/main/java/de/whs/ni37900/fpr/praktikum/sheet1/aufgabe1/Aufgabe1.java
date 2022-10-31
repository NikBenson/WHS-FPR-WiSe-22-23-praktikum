package de.whs.ni37900.fpr.praktikum.sheet1.aufgabe1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Aufgabe1 {
    public static void main(String[] args) {
        final InputStreamReader is = new InputStreamReader(System.in);
        final BufferedReader br = new BufferedReader(is);
        final Scanner scanner = new Scanner(br);

        start(scanner);
    }

    public static void start(Scanner scanner) {
        long l = (long) Math.pow(3, 22);
        int i = (int) l;

        System.out.printf("long l = %d\n", l);
        System.out.printf("int i = %d\n", i);
    }
}
