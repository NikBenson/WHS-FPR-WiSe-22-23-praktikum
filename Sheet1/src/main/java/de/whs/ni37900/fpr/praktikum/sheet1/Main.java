package de.whs.ni37900.fpr.praktikum.sheet1;

import de.whs.ni37900.fpr.praktikum.sheet1.aufgabe1.Aufgabe1;
import de.whs.ni37900.fpr.praktikum.sheet1.aufgabe2.Aufgabe2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Einstiegspunkt für eine beliebige Aufgabe des ersten Aufgabenblattes.
 */
public class Main {
    /**
     * Character-Stream ausgehend vom Byte-Stream {@code System.in}.
     * Dies ist der std::in der CLI, also die Nutzereingabe.
     */
    final InputStreamReader is = new InputStreamReader(System.in);

    /**
     * Speichert leseoperationen von {@code is} zwischen, um einen performanten Zugriff zu gewährleisten.
     */
    final BufferedReader br = new BufferedReader(is);

    /**
     * Stellt einfache, primitive Werten von {@code br} bereit.
     */
    final Scanner scanner = new Scanner(br);

    /**
     * Bildet die Nummer einer aufgabe auf eine Funktion ab, die dieser Aufgabe gerecht wird.
     */
    private final Map<Integer, Aufgabe> aufgaben = new HashMap<>() {{
        put(1, Aufgabe1::start);
        put(2, Aufgabe2::start);
    }};

    /**
     * Instanz des Programmes.
     * Fordert den Nutzer zur auswahl einer Aufgabe auf und führt diese aus
     */
    public Main() {
        System.out.printf("Bitte aufgabe auswählen\n Deine Optionen sind %s\n", aufgaben.keySet());

        while (!startAufgabe(scanner.nextInt())) {
            continue;
        }
        scanner.close();
    }

    /**
     * Startet eine Aufgabe nach auswahl über das CLI.
     * Hierfür wird die Klasse {@code Main} genutzt.
     *
     * @param args CLI argumente
     */
    public static void main(String[] args) {
        new Main();
    }

    /**
     * Startet eine Aufgabe.
     *
     * @param aufgabe die Nummer der zu startenden Aufgabe
     * @return ob eine Aufgabe gestartet wurde
     */
    boolean startAufgabe(int aufgabe) {
        if (!aufgaben.containsKey(aufgabe)) return false;

        aufgaben.get(aufgabe).run(scanner);
        return true;
    }

    /**
     * Interface für eine Funktion, die eine Aufgabe löst.
     */
    private interface Aufgabe {
        /**
         * Eine Aufgabe ist eine Funktion ohne Rückgabewert, die mit werten von einem eingabe Stream arbeitet.
         *
         * @param scanner primitive typen von std::in
         */
        void run(Scanner scanner);
    }
}
