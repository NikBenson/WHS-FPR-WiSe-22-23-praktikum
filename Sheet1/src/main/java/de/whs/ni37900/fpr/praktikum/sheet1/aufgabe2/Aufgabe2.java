package de.whs.ni37900.fpr.praktikum.sheet1.aufgabe2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Aufgabe2 {
    public static LGSSolver solver = new GaussAlgorithm();

    public static void main(String[] args) {
        final InputStreamReader is = new InputStreamReader(System.in);
        final BufferedReader br = new BufferedReader(is);
        final Scanner scanner = new Scanner(br);

        start(scanner);
    }

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
