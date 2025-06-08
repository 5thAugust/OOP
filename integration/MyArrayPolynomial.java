
public class MyArrayPolynomial extends MyAbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;


    public MyArrayPolynomial() {
        this.coefficents = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return coefficents[index];
    }

    @Override
    public double[] coefficients() {
        double[] result = new double[size];
        System.arraycopy(coefficents, 0, result, 0, size);
        return result;
    }

    @Override
    public MyArrayPolynomial append(double coefficient) {
        if (size == coefficents.length) {
            allocateMore();
        }
        coefficents[size++] = coefficient;
        return this;
    }

    @Override
    public MyArrayPolynomial add(double coefficient, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (size == coefficents.length) {
            allocateMore();
        }

        // Shift elements to make space
        System.arraycopy(coefficents, index, coefficents, index + 1, size - index);
        coefficents[index] = coefficient;
        size++;
        return this;
    }

    @Override
    public MyArrayPolynomial set(double coefficient, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        coefficents[index] = coefficient;
        return this;
    }

    @Override
    public int degree() {
        return size - 1;
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += coefficents[i] * Math.pow(x, i);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial derivative() {
        if (size <= 1) {
            return new MyArrayPolynomial().append(0);
        }

        MyArrayPolynomial derivative = new MyArrayPolynomial();
        for (int i = 1; i < size; i++) {
            derivative.append(coefficents[i] * i);
        }
        return derivative;
    }

    @Override
    public MyArrayPolynomial plus(MyPolynomial right) {
        MyArrayPolynomial result = new MyArrayPolynomial();
        double[] rightCoeffs = right.coefficients();
        int maxSize = Math.max(size, rightCoeffs.length);

        for (int i = 0; i < maxSize; i++) {
            double leftVal = i < size ? coefficents[i] : 0;
            double rightVal = i < rightCoeffs.length ? rightCoeffs[i] : 0;
            result.append(leftVal + rightVal);
        }

        return result;
    }

    @Override
    public MyArrayPolynomial minus(MyPolynomial right) {
        MyArrayPolynomial result = new MyArrayPolynomial();
        double[] rightCoeffs = right.coefficients();
        int maxSize = Math.max(size, rightCoeffs.length);

        for (int i = 0; i < maxSize; i++) {
            double leftVal = i < size ? coefficents[i] : 0;
            double rightVal = i < rightCoeffs.length ? rightCoeffs[i] : 0;
            result.append(leftVal - rightVal);
        }

        return result;
    }

    @Override
    public MyArrayPolynomial multiply(MyPolynomial right) {
        MyArrayPolynomial result = new MyArrayPolynomial();
        double[] rightCoeffs = right.coefficients();
        int resultSize = degree() + right.degree() + 1;

        // Initialize result coefficients to 0
        for (int i = 0; i < resultSize; i++) {
            result.append(0);
        }

        // Multiply each term
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < rightCoeffs.length; j++) {
                double product = coefficents[i] * rightCoeffs[j];
                result.coefficents[i + j] += product;
            }
        }

        return result;
    }


    private void allocateMore() {
        double[] newArray = new double[coefficents.length * 2];
        System.arraycopy(coefficents, 0, newArray, 0, size);
        coefficents = newArray;
    }
}