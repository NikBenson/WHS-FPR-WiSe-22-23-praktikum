package de.whs.ni37900.fpr.praktikum.sheet5.aufgabe1;

import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.Personalverwaltung;
import de.whs.ni37900.fpr.praktikum.sheet5.aufgabe1.personal.ComparableMitarbeiter;

import java.util.Arrays;

public abstract class ComparablePersonalverwaltung<T extends ComparableMitarbeiter> extends Personalverwaltung<T> {
    public void sort() {
        Arrays.sort(personal);
    }
}
