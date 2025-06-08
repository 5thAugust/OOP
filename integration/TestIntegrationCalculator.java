
import java.util.Random;

public class TestIntegrationCalculator {
    private MyPolynomial polynomial;

    public TestIntegrationCalculator(MyPolynomial polynomial) {
        this.polynomial = polynomial;
    }

    public static void main(String[] args) {
        System.out.println("Testing ArrayPolynomial:");
        TestIntegrationCalculator arrayTest = new TestIntegrationCalculator(null);
        arrayTest.testArrayPolynomial();

        System.out.println("\n--------------------------------\n");

        System.out.println("Testing ListPolynomial:");
        TestIntegrationCalculator listTest = new TestIntegrationCalculator(null);
        listTest.testListPolynomial();
    }

    public void testArrayPolynomial() {
        Random random = new Random();
        int size = random.nextInt(5) + 3;

        double[] coefficients = new double[size];
        for (int i = 0; i < size; i++) {
            coefficients[i] = random.nextDouble() * 10 - 5;
        }

        MyArrayPolynomial poly = new MyArrayPolynomial();
        for (double coeff : coefficients) {
            poly.append(coeff);
        }

        System.out.println("Created polynomial: " + poly);

        System.out.println("\nTesting polynomial operations:");

        double newCoeff = random.nextDouble() * 2;
        poly.append(newCoeff);
        System.out.println("After appending " + newCoeff + ": " + poly);

        int indexToSet = random.nextInt(poly.degree() + 1);
        double setValue = random.nextDouble() * 3;
        poly.set(setValue, indexToSet);
        System.out.println("After setting coefficient at index " + indexToSet + " to " + setValue + ": " + poly);

        double x = random.nextDouble() * 4;
        System.out.println("Polynomial value at x=" + x + ": " + poly.evaluate(x));

        MyArrayPolynomial poly2 = new MyArrayPolynomial();
        for (int i = 0; i < 4; i++) {
            poly2.append(random.nextDouble() * 4 - 2);
        }
        System.out.println("\nSecond polynomial: " + poly2);

        System.out.println("Sum of polynomials: " + poly.plus(poly2));

        System.out.println("Difference of polynomials: " + poly.minus(poly2));

        System.out.println("Product of polynomials: " + poly.multiply(poly2));

        System.out.println("\nTesting integration:");
        IntegrationCalculator calculator = new IntegrationCalculator(poly);

        // Test with different integrators
        System.out.println("Midpoint rule result (1.0 to 5.0): " +
                calculator.integrate(1.0, 5.0));

        calculator.setIntegrator(new TrapezoidRule(1e-6, 1000));
        System.out.println("Trapezoid rule result (1.0 to 5.0): " +
                calculator.integrate(1.0, 5.0));

        calculator.setIntegrator(new SimpsonRule(1e-6, 1000));
        System.out.println("Simpson rule result (1.0 to 5.0): " +
                calculator.integrate(1.0, 5.0));
    }

    public void testListPolynomial() {
        Random random = new Random();
        int size = random.nextInt(5) + 3;

        double[] coefficients = new double[size];
        for (int i = 0; i < size; i++) {
            coefficients[i] = random.nextDouble() * 10 - 5;
        }

        MyListPolynomial poly = new MyListPolynomial();
        for (double coeff : coefficients) {
            poly.append(coeff);
        }

        System.out.println("Created polynomial: " + poly);

        // Test polynomial operations
        System.out.println("\nTesting polynomial operations:");

        int indexToAdd = random.nextInt(poly.degree() + 1);
        double addValue = random.nextDouble() * 2;
        poly.add(addValue, indexToAdd);
        System.out.println("After adding coefficient " + addValue + " at index " + indexToAdd + ": " + poly);

        indexToAdd = random.nextInt(poly.degree() + 1);
        double setValue = random.nextDouble() * 3;
        poly.set(setValue, indexToAdd);
        System.out.println("After setting coefficient at index " + indexToAdd + " to " + setValue + ": " + poly);

        double x = random.nextDouble() * 4;
        System.out.println("Polynomial value at x=" + x + ": " + poly.evaluate(x));

        MyListPolynomial poly2 = new MyListPolynomial();
        for (int i = 0; i < 4; i++) {
            poly2.append(random.nextDouble() * 4 - 2);
        }
        System.out.println("\nSecond polynomial: " + poly2);

        System.out.println("Sum of polynomials: " + poly.plus(poly2));

        System.out.println("Difference of polynomials: " + poly.minus(poly2));

        System.out.println("Product of polynomials: " + poly.multiply(poly2));

        System.out.println("\nTesting integration:");
        IntegrationCalculator calculator = new IntegrationCalculator(poly);

        System.out.println("Midpoint rule result (2.0 to 6.0): " +
                calculator.integrate(2.0, 6.0));

        calculator.setIntegrator(new TrapezoidRule(1e-6, 1000));
        System.out.println("Trapezoid rule result (2.0 to 6.0): " +
                calculator.integrate(2.0, 6.0));

        calculator.setIntegrator(new SimpsonRule(1e-6, 1000));
        System.out.println("Simpson rule result (2.0 to 6.0): " +
                calculator.integrate(2.0, 6.0));
    }
}