package de.whs.ni37900.fpr.praktikum.sheet6.aufgabe1;


import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.Manager;
import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.ManagerImpl;
import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.MitarbeiterImpl;
import javafx.util.Pair;

import java.sql.Date;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        PairPersonalverwaltung personalverwaltung = new PairPersonalverwaltung();

        personalverwaltung.einstellen(new ManagerImpl("Test1", Date.from(Instant.now()), 100, 100));
        personalverwaltung.einstellen(new ManagerImpl("Test2", Date.from(Instant.now()), 75, 1_000));
        personalverwaltung.einstellen(new MitarbeiterImpl("Test3", Date.from(Instant.now()), 50));
        personalverwaltung.einstellen(new MitarbeiterImpl("Test4", Date.from(Instant.now()), 25));
        personalverwaltung.einstellen(new MitarbeiterImpl("Test5", Date.from(Instant.now()), 25));
        personalverwaltung.einstellen(new ManagerImpl("Test6", Date.from(Instant.now()), 75, 1_000));
        personalverwaltung.einstellen(new ManagerImpl("Test7", Date.from(Instant.now()), 75, 100));
        personalverwaltung.einstellen(new ManagerImpl("Test8", Date.from(Instant.now()), 75, 10_000));

        personalverwaltung.personalListeAusgeben();
        System.out.println();
        Pair<Manager, Manager> managerWithHighestAndLowestBonus = personalverwaltung.getManagerWithHighestAndLowestBonus();
        System.out.printf("highest: %s,%nlowest: %s%n", managerWithHighestAndLowestBonus.getValue(), managerWithHighestAndLowestBonus.getKey());
    }
}
