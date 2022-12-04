package de.whs.ni37900.fpr.praktikum.sheet5.aufgabe2;


import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.Mitarbeiter;

public interface MitarbeiterKleidergroesse extends Mitarbeiter {
    enum Kleidergroesse {
        XS, S, M, L, XL
    }

    Kleidergroesse kleidergroesse = Kleidergroesse.M;

}
