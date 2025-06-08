
public class TrapezoidRule implements MyIntegrator {
    private double precision;
    private int maxIterations;

    public TrapezoidRule(double precision, int maxIterations) {
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    @Override
    public double integrate(MyPolynomial polynomial, double lower, double upper) {
        if (lower == upper) {
            return 0;
        }

        int n0 = 1;
        double previousIntegral = integrate(polynomial, lower, upper, n0);
        double currentIntegral;
        int iterations = 0;

        while (iterations < maxIterations) {
            n0 *= 2;
            currentIntegral = integrate(polynomial, lower, upper, n0);

            if (Math.abs(currentIntegral - previousIntegral) / 3 < precision) {
                return currentIntegral;
            }

            previousIntegral = currentIntegral;
            iterations++;
        }

        return previousIntegral;
    }

    private double integrate(MyPolynomial polynomial, double lower, double upper, int numOfSubIntervals) {
        double h = (upper - lower) / numOfSubIntervals;
        double sum = 0.5 * (polynomial.evaluate(lower) + polynomial.evaluate(upper));

        for (int i = 1; i < numOfSubIntervals; i++) {
            double x = lower + i * h;
            sum += polynomial.evaluate(x);
        }

        return sum * h;
    }
}