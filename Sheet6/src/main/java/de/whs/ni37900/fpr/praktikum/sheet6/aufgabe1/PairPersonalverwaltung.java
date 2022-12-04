package de.whs.ni37900.fpr.praktikum.sheet6.aufgabe1;

import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.Personalverwaltung;
import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.Manager;
import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.Mitarbeiter;

import java.util.Arrays;
import java.util.Comparator;

import javafx.util.Pair;

public class PairPersonalverwaltung extends Personalverwaltung<Mitarbeiter> {
    @Override
    protected Mitarbeiter[] empty() {
        return new Mitarbeiter[0];
    }

    public Pair<Manager, Manager> getManagerWithHighestAndLowestBonus() {
        Manager[] managers = getManagers();

        if(managers.length == 0) {
            return null;
        }

        Arrays.sort(managers, Comparator.comparingDouble(Manager::getBonus));

        return new Pair<>(managers[0], managers[managers.length - 1]);
    }

    public Manager[] getManagers() {
        return Arrays.stream(getPersonal()).filter(Manager.class::isInstance).map(Manager.class::cast).toArray(Manager[]::new);
    }
}
