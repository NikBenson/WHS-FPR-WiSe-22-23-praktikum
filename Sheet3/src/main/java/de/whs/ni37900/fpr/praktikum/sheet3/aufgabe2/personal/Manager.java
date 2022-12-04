package de.whs.ni37900.fpr.praktikum.sheet3.aufgabe2.personal;

public interface Manager extends Mitarbeiter {
    double getBonus();

    double bonusZuweisen(double bonus);
}
