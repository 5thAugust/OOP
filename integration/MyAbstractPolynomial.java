
public abstract class MyAbstractPolynomial implements MyPolynomial {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        double[] coefficients = coefficients();

        for (int i = 0; i < coefficients.length; i++) {
            if (i != 0) {
                sb.append(" + ");
            }

            sb.append(coefficients[i]);

            if (i > 0) {
                sb.append("x");
                if (i > 1) {
                    sb.append("^").append(i);
                }
            }
        }

        sb.append("]");
        return sb.toString();
    }

    public double[] differentiate() {
        double[] coefficients = coefficients();
        if (coefficients.length <= 1) {
            return new double[]{0};
        }

        double[] derivative = new double[coefficients.length - 1];
        for (int i = 1; i < coefficients.length; i++) {
            derivative[i - 1] = coefficients[i] * i;
        }

        return derivative;
    }
}