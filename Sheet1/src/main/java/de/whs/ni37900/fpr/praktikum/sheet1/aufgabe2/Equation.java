package de.whs.ni37900.fpr.praktikum.sheet1.aufgabe2;


import java.util.Arrays;

/**
 * Eine Gleichung aus einem LGS.
 * Gespeichert werden die Faktoren in Matrixform.
 */
public class Equation {
    /**
     * Die Zeile in Matrixform.
     */
    private final double[] matrixRow;

    /**
     * Instanziiert eine Gleichung aus der Matrixform.
     *
     * @param matrixRow die Zeile in der Matrix
     */
    public Equation(double... matrixRow) {
        this.matrixRow = matrixRow;
    }

    /**
     * Instanziiert eine Gleichung aus den Faktoren.
     *
     * @param factors die Faktoren der Parameter
     * @param result  das Ergebnis
     */
    public Equation(double[] factors, double result) {
        matrixRow = Arrays.copyOf(factors, factors.length + 1);
        matrixRow[matrixRow.length - 1] = result;
    }

    /**
     * @return die Faktoren der Parameter
     */
    public double[] getFactors() {
        return Arrays.copyOf(matrixRow, matrixRow.length - 1);
    }

    /**
     * @return das Ergebnis
     */
    public double getResult() {
        return matrixRow[matrixRow.length - 1];
    }

    /**
     * @return matrix darstellung als Array
     */
    public double[] getMatrixRow() {
        return Arrays.copyOf(matrixRow, matrixRow.length);
    }

    /**
     * @return grad der Gleichung
     */
    public int degree() {
        return getFactors().length;
    }

    /**
     * Erstellt eine neue Gleichung basierend auf dieser.
     * Dabei ist jeder Wert der neuen Gleichung multipliziert mit {@code scalar}.
     *
     * @param scalar der Faktor
     * @return die skalierte Gleichung
     */
    public Equation scale(double scalar) {
        return new Equation(Arrays.stream(getMatrixRow()).map(operand -> operand * scalar).toArray());
    }

    /**
     * Addiert zwei Gleichungen
     *
     * @param other die zweite Gleichung
     * @return summe von {@code this} und {@code other}
     * @throws IllegalArgumentException bei Gleichungen unterschiedlichen Grades
     */
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

    /**
     * Überprüft other auf Gleichheit.
     *
     * @param other das zu vergleichende Objekt
     * @return ob {@code other} eine {@code Equation} mit denselben Faktoren Werten und demselben Ergebnis ist
     */
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

    /**
     * Überprüft other auf Äquivalenz.
     *
     * @param other zu vergleichende Gleichung
     * @return ob beide Gleichungen equivalent sind
     */
    public boolean isEquivalent(Equation other) {
        if (other.degree() != degree()) return false;
        if (degree() == 0) return true;

        double[] row1 = getMatrixRow();
        double[] row2 = other.getMatrixRow();

        final double assumedDifferenceFactor = row1[0] / row2[0];

        return equals(other.scale(assumedDifferenceFactor));
    }

    /**
     * @return Darstellung als Tupel
     */
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
