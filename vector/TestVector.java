package hus.oop.vector;

import java.util.Random;

public class TestVector {
    private MyVector vector;
    private static final Random random = new Random();

    public TestVector(MyVector vector) {
        this.vector = vector;
    }

    public static void main(String[] args) {
        System.out.println("Testing MyArrayVector:");
        TestVector arrayTest = new TestVector(new MyArrayVector());
        arrayTest.testArrayVector();

        System.out.println("\nTesting MyListVector:");
        TestVector listTest = new TestVector(new MyListVector());
        listTest.testListVector();

        System.out.println("\nAll tests completed successfully!");
    }

    public void testArrayVector() {
        int n = 5 + random.nextInt(6); // Random size between 5 and 10
        System.out.println("Creating ArrayVector with size: " + n);

        // Initialize vector with random values
        for (int i = 0; i < n; i++) {
            vector.insert(random.nextDouble() * 10);
        }
        System.out.println("Initial vector: " + vector);

        // Test insert
        vector.insert(99.9, 2);
        System.out.println("After insert at index 2: " + vector);

        // Test remove
        vector.remove(3);
        System.out.println("After remove at index 3: " + vector);

        // Test set
        vector.set(55.5, 1);
        System.out.println("After set at index 1: " + vector);

        // Test operations
        MyVector added = vector.add(5.0);
        System.out.println("Vector + 5.0: " + added);

        double norm = vector.norm();
        System.out.println("Norm: " + norm);
    }

    public void testListVector() {
        int n = 5 + random.nextInt(6); // Random size between 5 and 10
        System.out.println("Creating ListVector with size: " + n);

        // Initialize vector with random values
        for (int i = 0; i < n; i++) {
            vector.insert(random.nextDouble() * 10);
        }
        System.out.println("Initial vector: " + vector);

        // Test insert
        vector.insert(88.8, 1);
        System.out.println("After insert at index 1: " + vector);

        // Test remove
        vector.remove(4);
        System.out.println("After remove at index 4: " + vector);

        // Test set
        vector.set(44.4, 2);
        System.out.println("After set at index 2: " + vector);

        // Test operations
        MyVector scaled = vector.scale(2.0);
        System.out.println("Vector * 2.0: " + scaled);

        double dotProduct = vector.dot(scaled);
        System.out.println("Dot product: " + dotProduct);
    }
}