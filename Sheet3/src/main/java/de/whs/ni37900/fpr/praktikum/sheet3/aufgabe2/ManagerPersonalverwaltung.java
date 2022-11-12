package de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2;

import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.Manager;

public class ManagerPersonalverwaltung extends Personalverwaltung<Manager> {
    public ManagerPersonalverwaltung() {
        super();
    }

    @Override
    protected Manager[] empty() {
        return new Manager[0];
    }
}
