package de.whs.ni37900.fpr.praktikum.sheet1.aufgabe2;

import java.util.*;

public class LGS {
    @SuppressWarnings("FieldMayBeFinal")
    private List<Equation> equations;

    public LGS(Equation... equations) {
        this.equations = new LinkedList<>(Arrays.asList(equations));
    }

    public Equation[] getEquations() {
        return equations.toArray(Equation[]::new);
    }

    public int getDegree() {
        Optional<Equation> highestDegreeEquation = equations.stream().max(Comparator.comparingInt(Equation::degree));
        return highestDegreeEquation.map(Equation::degree).orElse(0);
    }

    public boolean isSolvable() {
        int degree = getDegree();

        return degree > 0 && degree <= normalized().equations.size();
    }

    public LGS normalized() {
        LGS normalized = new LGS();

        for (Equation equation : equations) {
            if (!normalized.contains(equation)) normalized.add(equation);
        }

        return normalized;
    }

    public void add(Equation equation) {
        equations.add(equation);
    }

    public boolean contains(Equation equation) {
        return equations.stream().anyMatch(equation::isEquivalent);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Equation equation : equations) {
            builder.append(equation);
            builder.append("\n");
        }

        return builder.substring(0, builder.length() - 1);
    }
}
