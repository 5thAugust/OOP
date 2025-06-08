
import java.util.ArrayList;
import java.util.List;

public class MyListPolynomial extends MyAbstractPolynomial {
    private List<Double> coefficients;

    public MyListPolynomial() {
        this.coefficients = new ArrayList<>();
    }

    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return coefficients.get(index);
    }

    @Override
    public double[] coefficients() {
        double[] coeffArray = new double[coefficients.size()];
        for (int i = 0; i < coeffArray.length; i++) {
            coeffArray[i] = coefficients.get(i);
        }
        return coeffArray;
    }

    @Override
    public MyListPolynomial append(double coefficient) {
        coefficients.add(coefficient);
        return this;
    }

    @Override
    public MyListPolynomial add(double coefficient, int index) {
        if (index < 0 || index > coefficients.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        coefficients.add(index, coefficient);
        return this;
    }

    @Override
    public MyListPolynomial set(double coefficient, int index) {
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        coefficients.set(index, coefficient);
        return this;
    }

    @Override
    public int degree() {
        return coefficients.size() - 1;
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * Math.pow(x, i);
        }
        return result;
    }

    @Override
    public MyListPolynomial derivative() {
        MyListPolynomial derivative = new MyListPolynomial();
        if (coefficients.size() <= 1) {
            derivative.append(0.0);
            return derivative;
        }

        for (int i = 1; i < coefficients.size(); i++) {
            derivative.append(coefficients.get(i) * i);
        }
        return derivative;
    }

    @Override
    public MyListPolynomial plus(MyPolynomial right) {
        MyListPolynomial result = new MyListPolynomial();
        double[] rightCoeffs = right.coefficients();
        int maxSize = Math.max(coefficients.size(), rightCoeffs.length);

        for (int i = 0; i < maxSize; i++) {
            double leftVal = i < coefficients.size() ? coefficients.get(i) : 0;
            double rightVal = i < rightCoeffs.length ? rightCoeffs[i] : 0;
            result.append(leftVal + rightVal);
        }

        return result;
    }

    @Override
    public MyListPolynomial minus(MyPolynomial right) {
        MyListPolynomial result = new MyListPolynomial();
        double[] rightCoeffs = right.coefficients();
        int maxSize = Math.max(coefficients.size(), rightCoeffs.length);

        for (int i = 0; i < maxSize; i++) {
            double leftVal = i < coefficients.size() ? coefficients.get(i) : 0;
            double rightVal = i < rightCoeffs.length ? rightCoeffs[i] : 0;
            result.append(leftVal - rightVal);
        }

        return result;
    }

    @Override
    public MyListPolynomial multiply(MyPolynomial right) {
        MyListPolynomial result = new MyListPolynomial();
        double[] rightCoeffs = right.coefficients();
        int resultSize = degree() + right.degree() + 1;

        // Initialize result coefficients to 0
        for (int i = 0; i < resultSize; i++) {
            result.append(0.0);
        }

        // Multiply each term
        for (int i = 0; i < coefficients.size(); i++) {
            for (int j = 0; j < rightCoeffs.length; j++) {
                double product = coefficients.get(i) * rightCoeffs[j];
                result.coefficients.set(i + j, result.coefficients.get(i + j) + product);
            }
        }

        return result;
    }
}