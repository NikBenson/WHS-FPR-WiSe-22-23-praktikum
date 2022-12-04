package de.whs.ni37900.fpr.praktikum.sheet6.aufgabe2;


import java.util.Arrays;

public class Sorter<T extends Comparable<? super T>> {
    private final T[] data;
    private boolean isSorted = false;

    public static void main(String[] args) {
        final Integer[] data = {94495, 86, 50020425, 81566, 3181, 5, 734, 6};

        Sorter<Integer> sorter = new Sorter<>(data);

        System.out.println(sorter);
        sorter.get();
        System.out.println(sorter);
    }

    public Sorter(final T[] data) {
        this.data = data.clone();
    }

    public T[] get() {
        if (isSorted) {
            return data.clone();
        }

        return sorted();
    }

    private T[] sorted() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (shouldSwap(i, j)) swap(i, j);
            }
        }

        isSorted = true;
        return data;
    }

    private boolean shouldSwap(final int a, final int b) {
        return data[a].compareTo(data[b]) > 0;
    }

    private void swap(final int a, final int b) {
        final T temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    @Override
    public String toString() {
        return "Sorter{" +
                "data=" + Arrays.toString(data) +
                ", isSorted=" + isSorted +
                '}';
    }
}
