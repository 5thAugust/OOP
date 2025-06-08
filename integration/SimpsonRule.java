
public class SimpsonRule implements MyIntegrator {
    private double precision;
    private int maxIterations;

    public SimpsonRule(double precision, int maxIterations) {
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    @Override
    public double integrate(MyPolynomial polynomial, double lower, double upper) {
        if (lower == upper) {
            return 0;
        }

        int n0 = 2; // Initial number of subintervals (must be even for Simpson's rule)
        double previousIntegral = integrate(polynomial, lower, upper, n0);
        double currentIntegral;
        int iterations = 0;

        while (iterations < maxIterations) {
            n0 *= 2;
            currentIntegral = integrate(polynomial, lower, upper, n0);

            // Check for convergence
            if (Math.abs(currentIntegral - previousIntegral) / 15 < precision) {
                return currentIntegral;
            }

            previousIntegral = currentIntegral;
            iterations++;
        }

        return previousIntegral;
    }

    private double integrate(MyPolynomial polynomial, double lower, double upper, int numOfSubIntervals) {
        if (numOfSubIntervals % 2 != 0) {
            throw new IllegalArgumentException("Number of subintervals must be even for Simpson's rule");
        }

        double h = (upper - lower) / numOfSubIntervals;
        double sum = polynomial.evaluate(lower) + polynomial.evaluate(upper);

        // Calculate the sum of terms
        for (int i = 1; i < numOfSubIntervals; i++) {
            double x = lower + i * h;
            if (i % 2 == 0) {
                sum += 2 * polynomial.evaluate(x);
            } else {
                sum += 4 * polynomial.evaluate(x);
            }
        }

        return sum * h / 3;
    }
}