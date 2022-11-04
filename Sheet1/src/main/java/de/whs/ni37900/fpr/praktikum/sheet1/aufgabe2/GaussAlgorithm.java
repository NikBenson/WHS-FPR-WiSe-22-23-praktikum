package de.whs.ni37900.fpr.praktikum.sheet1.aufgabe2;

import java.util.Arrays;

/**
 * Beim Gauß-Algorithmus werden bekanntermaßen in jedem Schritt alle Werte der jeweils betrachteten
 * Spalte unterhalb der Diagonalen eliminiert. Hierbei werden jeweils Zeilenoperationen der Form zi:=ziaij/
 * ajj*zj durchgeführt. Um numerische Fehler gering zu halten, führt man die sogenannte
 * Spaltenpivotisierung durch. Dabei werden vor jedem Gauß-Schritt die Zeilen des Gleichungssystems
 * so vertauscht, dass das betragsgrößte Element der jeweiligen Spalte auf der Diagonalen liegt.
 * Anschließend führt man dann die Eliminationen mithilfe der Zeilenoperationen durch.
 */
public class GaussAlgorithm implements LGSSolver {
    /**
     * Löst das angegebene LGS falls möglich mittels des Gauß-Verfahrens.
     *
     * @param lgs das zu lösende LGS
     * @return den Lösungsarray
     * @throws NotSolvableException wenn das LGS nicht eindeutig gelöst werden kann
     */
    @Override
    public double[] solve(LGS lgs) throws NotSolvableException {
        if (!lgs.isSolvable()) throw new NotSolvableException();

        return solveNormalized(lgs.normalized());
    }

    /**
     * Löst das angegebene, normalisierte LGS falls möglich rekursiv mittels des Gauß-Verfahrens.
     *
     * @param lgs das zu lösende LGS
     * @return den Lösungsarray
     * @throws NotSolvableException wenn das LGS nicht eindeutig gelöst werden kann
     */
    private double[] solveNormalized(LGS lgs) throws NotSolvableException {
        if (lgs.getDegree() == 1) return solveFirstDegree(lgs);

        double[] resultWithoutLastParameter = solve(reduceDegree(lgs));

        Equation first = lgs.getEquations()[0];
        double[] factors = first.getFactors();

        double sum = 0;
        for (int i = 0; i < resultWithoutLastParameter.length; i++) {
            sum += resultWithoutLastParameter[i] * factors[i];
        }

        double missingResultParameter = (first.getResult() - sum) / factors[factors.length - 1];

        double[] result = Arrays.copyOf(resultWithoutLastParameter, resultWithoutLastParameter.length + 1);
        result[result.length - 1] = missingResultParameter;

        return result;
    }

    /**
     * Löst das angegebene LGS ersten grades.
     *
     * @param lgs das zu lösende LGS
     * @return den Lösungsarray
     * @throws NotSolvableException wenn nicht alle gleichungen von {@code lgs} eindeutig sind
     */
    private double[] solveFirstDegree(LGS lgs) throws NotSolvableException {
        if (!allAreEquivalent(lgs)) throw new NotSolvableException();

        Equation equationEquivalentToLGS = lgs.getEquations()[0];
        double numerator = equationEquivalentToLGS.getResult();
        double denominator = equationEquivalentToLGS.getFactors()[0];

        if (denominator == 0) throw new NotSolvableException();

        return new double[]{numerator / denominator};
    }

    /**
     * Überprüft, ob alle Gleichungen des angegebenen LGS equivalent sind.
     *
     * @param lgs das zu prüfende LGS
     * @return ob alle Gleichungen von {@code lgs} equivalent sind
     */
    private boolean allAreEquivalent(LGS lgs) {
        Equation[] equations = lgs.getEquations();

        Equation first = equations[0];

        for (int i = 1; i < equations.length; i++) {
            if (!first.isEquivalent(equations[i])) return false;
        }

        return true;
    }

    /**
     * Generiert aus dem übergebenen LGS ein Teil-LGS des Grades {@code lgs.getDegree()} - 1
     *
     * @param lgs das zu reduzierende LGS
     * @return ein Teil-LGS von {@code lgs} des Grades {@code lgs.getDegree()} - 1
     */
    private LGS reduceDegree(LGS lgs) {
        Equation[] equations = lgs.getEquations();
        Equation first = equations[0];

        LGS reduced = new LGS();

        for (int i = 1; i < equations.length; i++) {
            Equation reducedEquation = eliminateNthFactor(first, equations[i], lgs.getDegree() - 1);
            double[] factors = reducedEquation.getFactors();
            reduced.add(new Equation(Arrays.copyOf(factors, factors.length - 1), reducedEquation.getResult()));
        }

        return reduced;
    }

    /**
     * Generiert eine Gleichung aus den übergebenen Gleichungen, bei denen der {@code n}te Faktor 0 ist.
     *
     * @param a die basis Gleichung
     * @param b die subtrahierte Gleichung
     * @param n der index des zu eliminierenden Faktors
     * @return eine Gleichung der Form {@code b} - x*{@code a}, wobei der {@code n}te Faktor 0 ist
     */
    private Equation eliminateNthFactor(Equation a, Equation b, int n) {
        return b.add(matchNthFactor(a, b, n).scale(-1));
    }

    /**
     * Erstellt eine Gleichung, bei der der {@code n}te Parameter beider angegebener Gleichungen übereinstimmt.
     *
     * @param a die Skalierte Gleichung
     * @param b die verglichene Gleichung
     * @param n der index des zu vereinheitlichenden Parameters
     * @return {@code a} skaliert zu {@code b}s {@code n}tem Wert
     */
    private Equation matchNthFactor(Equation a, Equation b, int n) {
        return a.scale(b.getFactors()[n] / a.getFactors()[n]);
    }
}
