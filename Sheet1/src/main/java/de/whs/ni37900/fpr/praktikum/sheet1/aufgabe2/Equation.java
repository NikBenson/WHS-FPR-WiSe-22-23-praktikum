package de.whs.ni37900.fpr.praktikum.sheet1.aufgabe2;


import java.util.Arrays;

public class Equation {
    private final double[] matrixRow;

    public Equation(double... matrixRow) {
        this.matrixRow = matrixRow;
    }

    public Equation(double[] factors, double result) {
        matrixRow = Arrays.copyOf(factors, factors.length + 1);
        matrixRow[matrixRow.length - 1] = result;
    }

    public double[] getFactors() {
        return Arrays.copyOf(matrixRow, matrixRow.length - 1);
    }

    public double getResult() {
        return matrixRow[matrixRow.length - 1];
    }

    public double[] getMatrixRow() {
        return Arrays.copyOf(matrixRow, matrixRow.length);
    }

    public int degree() {
        return getFactors().length;
    }

    public Equation scale(double scalar) {
        return new Equation(Arrays.stream(getMatrixRow()).map(operand -> operand * scalar).toArray());
    }

    public Equation add(Equation other) throws IllegalArgumentException {
        if (degree() != other.degree()) throw new IllegalArgumentException("Can't add Equations of different degrees.");

        double[] summandA = getMatrixRow();
        double[] summandB = other.getMatrixRow();
        double[] sum = new double[degree() + 1];

        for (int i = 0; i < sum.length; i++) {
            sum[i] = summandA[i] + summandB[i];
        }

        return new Equation(sum);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Equation)) return false;
        return Arrays.equals(getMatrixRow(), ((Equation) other).getMatrixRow());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getMatrixRow());
    }

    public boolean isEquivalent(Equation other) {
        if (other.degree() != degree()) return false;
        if (degree() == 0) return true;

        double[] row1 = getMatrixRow();
        double[] row2 = other.getMatrixRow();

        final double assumedDifferenceFactor = row1[0] / row2[0];

        return equals(other.scale(assumedDifferenceFactor));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("(");

        for (double factor : getFactors()) {
            builder.append("   ");
            builder.append(factor);
            builder.append("   ");
        }

        builder.append("|");
        builder.append("   ");
        builder.append(getResult());
        builder.append("   ");
        builder.append(")");

        return builder.toString();
    }
}
