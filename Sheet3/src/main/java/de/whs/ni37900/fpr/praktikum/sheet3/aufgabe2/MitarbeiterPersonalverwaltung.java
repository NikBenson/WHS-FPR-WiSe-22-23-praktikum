package de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2;

import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.Mitarbeiter;

public class MitarbeiterPersonalverwaltung extends Personalverwaltung<Mitarbeiter> {
    public MitarbeiterPersonalverwaltung() {
        super();
    }

    @Override
    protected Mitarbeiter[] empty() {
        return new Mitarbeiter[0];
    }
}
