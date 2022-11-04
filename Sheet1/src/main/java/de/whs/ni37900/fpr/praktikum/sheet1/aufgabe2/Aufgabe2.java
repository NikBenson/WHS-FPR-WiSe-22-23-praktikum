package de.whs.ni37900.fpr.praktikum.sheet1.aufgabe2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <h2>Aufgabe 2</h2>
 * Implementieren Sie den Gauß-Algorithmus mit Spaltenpivotisierung zur Lösung von linearen
 * Gleichungssystemen der Form A x = b! Das Programm soll folgende Eigenschaften besitzen:
 * <ul>
 *     <li>Eingabe der Zahl der Unbekannten n. Es wird vorausgesetzt, dass die Zahl der Gleichungen identisch mit der Zahl der Unbekannten ist, es sich also um eine n x n-Matrix handelt.</li>
 *     <li>Eingabe der Koeffizientenmatrix A und der rechten Seite b.</li>
 *     <li>Durchführung des Lösungsalgorithmus' mit anschließender Ausgabe des Vektors x.</li>
 * </ul>
 */
public class Aufgabe2 {
    /**
     * Der Algorithmus, der zum Lösen des LGS verwendet wird.
     */
    public static LGSSolver solver = new GaussAlgorithm();

    /**
     * Startet Aufgabe 2 als Standalone
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
     * Einstiegspunkt der zweiten Aufgabe.
     * Liest ein LGS von std::in und gibt die lösung aus.
     * Dabei wird Zeile für Zeile des LGS eingelesen, bis das LGS lösbar ist.
     * Anschließend wird zum Lösen {@code solver} verwendet.
     *
     * @param scanner Eingabe des Programms, klassischerweise von {@code System.in}
     */
    public static void start(Scanner scanner) {
        System.out.println("Bitte gib den gewünschten Grad des LGS ein:");
        final int degree = scanner.nextInt();
        final LGS lgs = new LGS();

        if (degree <= 0) {
            System.out.println("Ein LGS des Grades 0 kann nicht gelöst werden.");
            return;
        }

        while (!lgs.isSolvable()) {
            System.out.println("Bitte gib die Faktoren einer Gleichung ein:");

            double[] row = new double[degree + 1];
            for (int i = 0; i < row.length; i++) {
                row[i] = scanner.nextDouble();
            }
            lgs.add(new Equation(row));
        }

        try {
            final double[] result = solver.solve(lgs);

            System.out.printf("Die Lösung des LGS\n%s\nist\n%s", lgs, Arrays.toString(result));

        } catch (NotSolvableException e) {
            System.out.println("Die Gleichung konnte nicht gelöst werden.");
        }
    }
}
