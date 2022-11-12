package de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2;

import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.Manager;
import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.Mitarbeiter;

import java.sql.Date;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        MitarbeiterPersonalverwaltung personalverwaltung = new MitarbeiterPersonalverwaltung();

        personalverwaltung.einstellen(new Manager("Test1", Date.from(Instant.now()), 100, 0));
        personalverwaltung.einstellen(new Manager("Test2", Date.from(Instant.now()), 75, 0));
        personalverwaltung.einstellen(new Mitarbeiter("Test3", Date.from(Instant.now()), 50));
        personalverwaltung.einstellen(new Mitarbeiter("Test4", Date.from(Instant.now()), 25));
        personalverwaltung.einstellen(new Mitarbeiter("Test5", Date.from(Instant.now()), 25));

        System.out.printf("min %s%n", personalverwaltung.schlechtestesGehalt().toString());
        System.out.printf("max %s%n", personalverwaltung.bestesGehalt().toString());

        System.out.printf("Hat Test3 Duplikate? %b%n", personalverwaltung.existiertDoppelt(personalverwaltung.getPersonal()[2]));
        personalverwaltung.einstellen(personalverwaltung.getPersonal()[2]);
        System.out.printf("Hat Test3 Duplikate? %b%n", personalverwaltung.existiertDoppelt(personalverwaltung.getPersonal()[2]));

        personalverwaltung.gehaltAnpassen(personalverwaltung.getPersonal()[2], 2);
        personalverwaltung.bonusAusschuetten(100);

        personalverwaltung.entlassen(personalverwaltung.getPersonal()[3]);

        personalverwaltung.personalListeAusgeben();
    }
}
