package de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2;

import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.Manager;
import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.Mitarbeiter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public abstract class Personalverwaltung<T extends Mitarbeiter> {
    private final Random random = new Random();
    protected T[] personal;

    protected Personalverwaltung() {
        personal = empty();
    }

    protected abstract T[] empty();

    public T[] getPersonal() {
        return personal;
    }

    public void einstellen(final T mitarbeiter) {
        personal = Arrays.copyOf(personal, personal.length + 1);
        personal[personal.length - 1] = mitarbeiter;
    }

    public T entlassen(final T mitarbeiter) {
        T gefunden = null;
        for (int i = 0; i < personal.length; i++) {
            if (gefunden != null) {
                personal[i - 1] = personal[i];
                continue;
            }

            if (personal[i] == mitarbeiter) {
                gefunden = personal[i];
            }
        }

        if (gefunden != null) {
            personal = Arrays.copyOf(personal, personal.length - 1);
        }

        return gefunden;
    }

    public double gehaltAnpassen(final Mitarbeiter mitarbeiter, final double prozent) {
        return mitarbeiter.gehaltAnpassen(prozent);
    }

    public Manager bonusAusschuetten(final double summe) {
        Manager[] managers = Arrays.stream(personal).filter(Manager.class::isInstance).toArray(Manager[]::new);

        if (managers.length == 0) {
            return null;
        }


        Manager manager = managers[random.nextInt(0, managers.length)];
        manager.bonusZuweisen(summe);
        return manager;
    }

    public T bestesGehalt() {
        return Arrays.stream(personal).max(Comparator.comparingDouble(T::getGehalt)).orElse(null);
    }

    public T schlechtestesGehalt() {
        return Arrays.stream(personal).min(Comparator.comparingDouble(T::getGehalt)).orElse(null);
    }

    public boolean existiertDoppelt(final T mitarbeiter) {
        return zaehle(mitarbeiter) > 1;
    }

    private int zaehle(final T mitarbeiter) {
        int anzahl = 0;

        for (final T eingetragenerMitarbeiter : personal)
            if (mitarbeiter.equals(eingetragenerMitarbeiter)) anzahl++;

        return anzahl;
    }

    public void personalListeAusgeben() {
        for (final T mitarbeiter : personal) {
            System.out.println(mitarbeiter.toString());
        }
    }
}
