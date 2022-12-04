package de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal;

import java.util.Date;
import java.util.UUID;

public interface Mitarbeiter {

    UUID getPersonalId();

    String getName();

    Date getEinstellungsdatum();

    double getGehalt();

    double gehaltAnpassen(double prozent);
}
