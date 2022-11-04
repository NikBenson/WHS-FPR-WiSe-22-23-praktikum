package de.whs.ni37900.fpr.praktikum.sheet1.aufgabe1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * <h2>Aufgabe 1</h2>
 * In einem Programm stehen folgende Zeilen:<br/>
 * <code>
 * long l = (long) Math.pow(3, 22);<br/>
 * int i = l;
 * </code><br/>
 * Funktioniert das Programm so? Wie können Sie es ändern, sodass es wenigstens ausführbar ist?
 * Lassen Sie sich die Werte von i und l ausgeben. Was stellen Sie fest? Erklären Sie!
 */
public class Aufgabe1 {
    /**
     * Startet Aufgabe 1 als Standalone
     *
     * @param args CLI argumente
     */
    public static void main(String[] args) {
        final InputStreamReader is = new InputStreamReader(System.in);
        final BufferedReader br = new BufferedReader(is);
        final Scanner scanner = new Scanner(br);

        start(scanner);

        scanner.close();
    }

    /**
     * Einstiegspunkt der ersten Aufgabe.
     * Das beispiel wurde durch einen Cast ergänzt und die Werte von {@code l} und {@code i} werden ausgegeben.
     *
     * @param ignoredScanner Eingabe des Programms, klassischerweise von {@code System.in}
     */
    public static void start(Scanner ignoredScanner) {
        long l = (long) Math.pow(3, 22);
        int i = (int) l;

        System.out.printf("long l = %d\n", l);
        System.out.printf("int i = %d\n", i);
    }
}
