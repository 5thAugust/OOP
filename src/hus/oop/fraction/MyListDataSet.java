package hus.oop.fraction;

import java.util.List;

public class MyListDataSet implements MyDataSet {
    private List<MyFraction> fractions;

    /**
     * Hàm dựng khởi tạo list chứa các phân số.
     */
    public MyListDataSet() {
        this.fractions = new java.util.ArrayList<>();


    }

    /**
     * Hàm dựng khởi tạo list chứa các phân số theo truyền vào.
     * @param fractions
     */
    public MyListDataSet(List<MyFraction> fractions) {
        if (fractions == null) {
            this.fractions = new java.util.ArrayList<>();
        } else {
            this.fractions = new java.util.ArrayList<>(fractions);
        }


    }

    @Override
    public boolean insert(MyFraction fraction, int index) {
        if (index < 0 || index > fractions.size()) {
            return false; // Index out of bounds
        }
        if (fractions.size() == 0 || index == fractions.size()) {
            return append(fraction); // If inserting at the end, use append
        }
        fractions.add(index, fraction); // Insert at the specified index
        return true; // Insertion successful

        /* TODO */
    }

    @Override
    public boolean append(MyFraction fraction) {
        if (fraction == null) {
            return false; // Cannot append null fraction
        }
        fractions.add(fraction); // Add the fraction to the end of the list
        return true; // Append successful

        /* TODO */
    }

    @Override
    public MyListDataSet toSimplify() {
        MyListDataSet simplifiedSet = new MyListDataSet();
        for (MyFraction fraction : fractions) {
            simplifiedSet.append(fraction.simplify()); // Assuming MyFraction has a simplify method
        }
        return simplifiedSet; // Return the new dataset with simplified fractions

        /* TODO */
    }

    public MyListDataSet sortIncreasing() {
        fractions.sort((f1, f2) -> f1.compareTo(f2)); // Assuming MyFraction implements Comparable
        return this; // Return the sorted dataset

        /* TODO */
    }

    public MyListDataSet sortDecreasing() {
        fractions.sort((f1, f2) -> f2.compareTo(f1)); // Assuming MyFraction implements Comparable
        return this; // Return the sorted dataset in decreasing order

        /* TODO */
    }

    @Override
    public String myDataSetToString() {
        StringBuilder sb = new StringBuilder();
        for (MyFraction fraction : fractions) {
            sb.append(fraction.toString()).append("\n"); // Assuming MyFraction has a toString method
        }
        return sb.toString(); // Return the string representation of the dataset

        /* TODO */
    }

    @Override
    public void print() {
        for (MyFraction fraction : fractions) {
            System.out.print(fraction.toString() + " "); // Print each fraction in the dataset
        }
        System.out.println();

        /* TODO */
    }
}
