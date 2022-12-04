package de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal;


import java.util.Date;
import java.util.Objects;

public class ManagerImpl extends MitarbeiterImpl implements Manager {
    protected double bonus;

    public ManagerImpl(String name, Date einstellungsdatum, double gehalt, double bonus) {
        super(name, einstellungsdatum, gehalt);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public double bonusZuweisen(double bonus) {
        return this.bonus += bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bonus=" + bonus +
                ", personalId=" + personalId +
                ", name='" + name + '\'' +
                ", einstellungsdatum=" + einstellungsdatum +
                ", gehalt=" + gehalt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager manager)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(manager.getBonus(), getBonus()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBonus());
    }
}
