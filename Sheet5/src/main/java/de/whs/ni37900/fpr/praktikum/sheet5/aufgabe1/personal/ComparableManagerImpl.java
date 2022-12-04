package de.whs.ni37900.fpr.praktikum.sheet5.aufgabe1.personal;

import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.ManagerImpl;

import java.util.Date;

public class ComparableManagerImpl extends ManagerImpl implements ComparableMitarbeiter {
    public ComparableManagerImpl(String name, Date einstellungsdatum, double gehalt, double bonus) {
        super(name, einstellungsdatum, gehalt, bonus);
    }
}
