package de.whs.ni37900.fpr.praktikum.sheet1.aufgabe2;


/**
 * Interface, das ein LGS lösen kann
 */
public interface LGSSolver {
    /**
     * Löst das angegebene LGS falls möglich.
     *
     * @param lgs das zu lösende LGS
     * @return den Lösungsarray
     * @throws NotSolvableException wenn das LGS nicht eindeutig gelöst werden kann
     */
    double[] solve(LGS lgs) throws NotSolvableException;
}
