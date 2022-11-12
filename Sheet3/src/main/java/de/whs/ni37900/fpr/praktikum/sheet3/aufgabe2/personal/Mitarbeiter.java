package de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Mitarbeiter {
    protected final UUID personalId;
    protected final String name;
    protected final Date einstellungsdatum;

    protected double gehalt;

    public Mitarbeiter(String name, Date einstellungsdatum, double gehalt) {
        this.personalId = UUID.randomUUID();
        this.name = name;
        this.einstellungsdatum = einstellungsdatum;
        this.gehalt = gehalt;
    }

    public UUID getPersonalId() {
        return personalId;
    }

    public String getName() {
        return name;
    }

    public Date getEinstellungsdatum() {
        return einstellungsdatum;
    }

    public double getGehalt() {
        return gehalt;
    }

    public double gehaltAnpassen(double prozent) {
        return gehalt *= prozent;
    }

    @Override
    public String toString() {
        return "Mitarbeiter{" +
                "personalId=" + personalId +
                ", name='" + name + '\'' +
                ", einstellungsdatum=" + einstellungsdatum +
                ", gehalt=" + gehalt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mitarbeiter that)) return false;
        return Double.compare(that.getGehalt(), getGehalt()) == 0 && getPersonalId().equals(that.getPersonalId()) && getName().equals(that.getName()) && getEinstellungsdatum().equals(that.getEinstellungsdatum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonalId(), getName(), getEinstellungsdatum(), getGehalt());
    }
}
