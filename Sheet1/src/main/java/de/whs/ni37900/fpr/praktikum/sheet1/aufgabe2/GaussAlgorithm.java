package de.whs.ni37900.fpr.praktikum.sheet1.aufgabe2;

import java.util.Arrays;

public class GaussAlgorithm implements LGSSolver {
    @Override
    public double[] solve(LGS lgs) throws NotSolvableException {
        if (!lgs.isSolvable()) throw new NotSolvableException();

        return solveNormalized(lgs.normalized());
    }

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

    private double[] solveFirstDegree(LGS lgs) throws NotSolvableException {
        if (!allAreEquivalent(lgs)) throw new NotSolvableException();

        Equation equationEquivalentToLGS = lgs.getEquations()[0];
        double numerator = equationEquivalentToLGS.getResult();
        double denominator = equationEquivalentToLGS.getFactors()[0];

        if (denominator == 0) throw new NotSolvableException();

        return new double[]{numerator / denominator};
    }

    private boolean allAreEquivalent(LGS lgs) {
        Equation[] equations = lgs.getEquations();

        Equation first = equations[0];

        for (int i = 1; i < equations.length; i++) {
            if (!first.isEquivalent(equations[i])) return false;
        }

        return true;
    }

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

    private Equation eliminateNthFactor(Equation a, Equation b, int n) {
        return b.add(matchNthFactor(a, b, n).scale(-1));
    }

    private Equation matchNthFactor(Equation a, Equation b, int n) {
        return a.scale(b.getFactors()[n] / a.getFactors()[n]);
    }
}
