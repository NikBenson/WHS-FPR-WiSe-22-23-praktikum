package de.whs.ni37900.fpr.praktikum.sheet5.aufgabe1;


import de.whs.ni37900.fpr.praktikum.sheet5.aufgabe1.personal.ComparableManagerImpl;
import de.whs.ni37900.fpr.praktikum.sheet5.aufgabe1.personal.ComparableMitarbeiterImpl;

import java.sql.Date;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        ComparableMitarbeiterPersonalverwaltung personalverwaltung = new ComparableMitarbeiterPersonalverwaltung();

        personalverwaltung.einstellen(new ComparableManagerImpl("Test1", Date.from(Instant.now()), 100, 0));
        personalverwaltung.einstellen(new ComparableManagerImpl("Test2", Date.from(Instant.now()), 75, 0));
        personalverwaltung.einstellen(new ComparableMitarbeiterImpl("Test3", Date.from(Instant.now()), 50));
        personalverwaltung.einstellen(new ComparableMitarbeiterImpl("Test4", Date.from(Instant.now()), 25));
        personalverwaltung.einstellen(new ComparableMitarbeiterImpl("Test5", Date.from(Instant.now()), 25));

        personalverwaltung.personalListeAusgeben();
        System.out.println();
        personalverwaltung.sort();
        personalverwaltung.personalListeAusgeben();
    }
}
