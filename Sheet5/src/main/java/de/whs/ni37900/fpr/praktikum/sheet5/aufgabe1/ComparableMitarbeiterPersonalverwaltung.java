package de.whs.ni37900.fpr.praktikum.sheet5.aufgabe1;

import de.whs.ni37900.fpr.praktikum.sheet5.aufgabe1.personal.ComparableMitarbeiter;

public class ComparableMitarbeiterPersonalverwaltung extends ComparablePersonalverwaltung<ComparableMitarbeiter> {
    @Override
    protected ComparableMitarbeiter[] empty() {
        return new ComparableMitarbeiter[0];
    }
}
