package de.whs.ni37900.fpr.praktikum.sheet5.aufgabe1.personal;

import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.Mitarbeiter;

import java.util.Date;

public interface ComparableMitarbeiter extends Mitarbeiter, Comparable<ComparableMitarbeiter>{

    @Override
    default int compareTo(ComparableMitarbeiter o) {
        return Double.compare(getGehalt(), o.getGehalt());
    }
}
