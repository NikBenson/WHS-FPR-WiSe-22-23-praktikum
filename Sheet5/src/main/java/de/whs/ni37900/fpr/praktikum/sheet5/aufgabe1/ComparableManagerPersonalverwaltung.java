package de.whs.ni37900.fpr.praktikum.sheet5.aufgabe1;

import de.whs.ni37900.fpr.praktikum.sheet5.aufgabe1.personal.ComparableManagerImpl;

public class ComparableManagerPersonalverwaltung extends ComparablePersonalverwaltung<ComparableManagerImpl> {
    @Override
    protected ComparableManagerImpl[] empty() {
        return new ComparableManagerImpl[0];
    }
}
