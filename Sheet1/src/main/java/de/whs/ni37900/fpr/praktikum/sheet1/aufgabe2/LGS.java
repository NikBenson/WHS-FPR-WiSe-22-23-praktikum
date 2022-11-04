package de.whs.ni37900.fpr.praktikum.sheet1.aufgabe2;

import java.util.*;

/**
 * Datenstruktur eines LGS als Liste von Gleichungen
 */
public class LGS {
    /**
     * Die Gleichungen in diesem LGS
     */
    @SuppressWarnings("FieldMayBeFinal")
    private List<Equation> equations;

    /**
     * Instanziiert ein LGS mit einer optionalen, initialen Liste von Gleichungen.
     *
     * @param equations initiale Liste von Gleichungen
     */
    public LGS(Equation... equations) {
        this.equations = new LinkedList<>(Arrays.asList(equations));
    }

    /**
     * @return gleichungen in diesem LGS
     */
    public Equation[] getEquations() {
        return equations.toArray(Equation[]::new);
    }

    /**
     * Anzahl der Unbekannten
     *
     * @return Grad des LGS
     */
    public int getDegree() {
        Optional<Equation> highestDegreeEquation = equations.stream().max(Comparator.comparingInt(Equation::degree));
        return highestDegreeEquation.map(Equation::degree).orElse(0);
    }

    /**
     * @return ob das LGS lösbar ist
     */
    public boolean isSolvable() {
        int degree = getDegree();

        return degree > 0 && degree <= normalized().equations.size();
    }

    /**
     * Normalisiert das LGS
     *
     * @return das LGS ohne äquivalente Gleichungen
     */
    public LGS normalized() {
        LGS normalized = new LGS();

        for (Equation equation : equations) {
            if (!normalized.contains(equation)) normalized.add(equation);
        }

        return normalized;
    }

    /**
     * Fügt eine weitere Gleichung in dieses LGS ein
     *
     * @param equation die neue Gleichung
     */
    public void add(Equation equation) {
        equations.add(equation);
    }

    /**
     * Überprüft, ob eine äquivalente Gleichung in dem LGS vorhanden ist
     *
     * @param equation die zu prüfende Gleichung
     * @return ob es bereits eine äquivalente gleichung in diesem LGS gibt
     */
    public boolean contains(Equation equation) {
        return equations.stream().anyMatch(equation::isEquivalent);
    }

    /**
     * @return Darstellung als eine Gleichung pro Zeile
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Equation equation : equations) {
            builder.append(equation);
            builder.append("\n");
        }

        return builder.substring(0, builder.length() - 1);
    }
}
