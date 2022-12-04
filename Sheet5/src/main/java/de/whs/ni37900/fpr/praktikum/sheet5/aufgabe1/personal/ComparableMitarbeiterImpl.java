package de.whs.ni37900.fpr.praktikum.sheet5.aufgabe1.personal;

import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.MitarbeiterImpl;

import java.util.Date;

public class ComparableMitarbeiterImpl extends MitarbeiterImpl implements ComparableMitarbeiter {
    public ComparableMitarbeiterImpl(String name, Date einstellungsdatum, double gehalt) {
        super(name, einstellungsdatum, gehalt);
    }
}
