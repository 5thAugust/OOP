
public interface MyPolynomial {

    double coefficient(int index);


    double[] coefficients();


    int degree();

    MyPolynomial set(double coefficient, int index);

    MyPolynomial append(double coefficient);

    MyPolynomial add(double coefficient, int index);


    double evaluate(double x);


    MyPolynomial derivative();


    MyPolynomial plus(MyPolynomial right);


    MyPolynomial minus(MyPolynomial right);


    MyPolynomial multiply(MyPolynomial right);
}
