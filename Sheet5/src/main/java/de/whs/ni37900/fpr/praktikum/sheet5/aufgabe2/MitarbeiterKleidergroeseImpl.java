package de.whs.ni37900.fpr.praktikum.sheet5.aufgabe2;

import de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal.MitarbeiterImpl;

import java.util.Date;

public class MitarbeiterKleidergroeseImpl extends MitarbeiterImpl implements MitarbeiterKleidergroesse {

    public MitarbeiterKleidergroeseImpl(String name, Date einstellungsdatum, double gehalt) {
        super(name, einstellungsdatum, gehalt);
        //kleidergroesse = Kleidergroesse.L;
    }
}
