package de.whs.ni37900.fpr.praktikum.sheet1;

import de.whs.ni37900.fpr.praktikum.sheet1.aufgabe1.Aufgabe1;
import de.whs.ni37900.fpr.praktikum.sheet1.aufgabe2.Aufgabe2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    final InputStreamReader is = new InputStreamReader(System.in);
    final BufferedReader br = new BufferedReader(is);
    final Scanner scanner = new Scanner(br);
    private final Map<Integer, Aufgabe> aufgaben = new HashMap<>() {{
        put(1, Aufgabe1::start);
        put(2, Aufgabe2::start);
    }};

    public Main() {
        System.out.printf("Bitte aufgabe auswählen\n Deine Optionen sind %s\n", aufgaben.keySet());

        while (!startAufgabe(scanner.nextInt())) {
            continue;
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Main();
    }

    boolean startAufgabe(int aufgabe) {
        if (!aufgaben.containsKey(aufgabe)) return false;

        aufgaben.get(aufgabe).run(scanner);
        return true;
    }

    private interface Aufgabe {
        void run(Scanner scanner);
    }
}
