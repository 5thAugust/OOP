
public class IntegrationCalculator {
    private MyIntegrator integrator;
    private MyPolynomial poly;


    public IntegrationCalculator(MyPolynomial poly) {
        this.poly = poly;
        this.integrator =  new MidpointRule(1e-6, 1000); // Default integrator
    }


    public IntegrationCalculator(MyIntegrator integrator, MyPolynomial poly) {
        this.integrator = integrator;
        this.poly = poly;
    }

    public void setPoly(MyPolynomial poly) {
        this.poly = poly;
    }

    public void setIntegrator(MyIntegrator integrator) {
        this.integrator = integrator;
    }

    public double integrate(double lower, double upper) {
        if (integrator == null || poly == null) {
            throw new IllegalStateException("Integrator or polynomial is not set");
        }
        return integrator.integrate(poly, lower, upper);
    }
}