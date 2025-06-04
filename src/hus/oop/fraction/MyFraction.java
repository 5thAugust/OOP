package hus.oop.fraction;

public class MyFraction implements MyFractionComparable {
    private int numerator;
    private int denominator;

    /**
     * Hàm dựng khởi tạo giá trị mặc định là 1/1.
     */
    public MyFraction() {
        this.numerator = 1;
        this.denominator = 1;

        /* TODO */
    }

    /**
     * Hàm dựng khởi tạo giá trị cho tử số và mẫu số.
     * @param numerator
     * @param denominator
     */
    public MyFraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
        simplify();
        /* TODO */
    }

    /**
     * Hàm dựng copy, copy giá trị của phân số truyền vào.
     * @param copyMyFraction
     */
    public MyFraction(MyFraction copyMyFraction) {
        if (copyMyFraction == null) {
            throw new IllegalArgumentException("Cannot copy a null fraction.");
        }
        this.numerator = copyMyFraction.numerator;
        this.denominator = copyMyFraction.denominator;
        if (this.denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
        simplify();

        /* TODO */
    }

    public int getNumerator() {
        if (denominator == 0) {
            throw new IllegalStateException("Denominator is zero, cannot get numerator.");
        }
        return numerator;

        /* TODO */
    }

    public void setNumerator(int numerator) {
        if (denominator == 0) {
            throw new IllegalStateException("Denominator is zero, cannot set numerator.");
        }
        this.numerator = numerator;
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
        simplify();

        /* TODO */
    }

    public int getDenominator() {
        if (denominator == 0) {
            throw new IllegalStateException("Denominator is zero, cannot get denominator.");
        }
        return denominator;

        /* TODO */
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.denominator = denominator;
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
        simplify();

        /* TODO */
    }

    /**
     * Phương thức trả về giá trị kiểu byte của phân số.
     * @return
     */
    public byte byteValue() {

        return (byte) (numerator / denominator); // Trả về giá trị của tử số, mẫu số không ảnh hưởng đến giá trị byte.

        /* TODO */
    }

    /**
     * Phương thức trả về giá trị kiểu int của phân số.
     * @return
     */
    public int intValue() {

        return numerator / denominator; // Trả về giá trị của tử số, mẫu số không ảnh hưởng đến giá trị int.

        /* TODO */
    }

    /**
     * Phương thức trả về giá trị kiểu long của phân số.
     * @return
     */
    public long longValue() {

        return (long) numerator / denominator;

        /* TODO */
    }

    /**
     * Phương thức trả về giá trị kiểu short của phân số.
     * @return
     */
    public short shortValue() {
        return (short) (numerator / denominator);
        /* TODO */
    }

    /**
     * Phương thức trả về giá trị kiểu double của phân số.
     * @return
     */
    public double doubleValue() {
        return (double) numerator / denominator;
        /* TODO */
    }

    /**
     * Phương thức trả về giá trị kiểu float của phân số.
     * @return
     */
    public float floatValue() {
        return (float) numerator / denominator;
        /* TODO */
    }

    /**
     * Phương thức tính ước số chung lớn nhất của tử số và mẫu số.
     * @return ước số chung lớn nhất của tử số và mẫu số.
     */
    private int gcd() {
        int a = Math.abs(numerator);
        int b = Math.abs(denominator);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;

        /* TODO */
    }

    /**
     * Phương thức rút gọn phân số về phân số tối giản.
     *
     * @return
     */
    public MyFraction simplify() {
        int gcd = gcd();
        if (gcd != 0) {
            numerator /= gcd;
            denominator /= gcd;
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }


        /* TODO */
        return this;
    }

    @Override
    public int compareTo(MyFraction another) {
        if (another == null) {
            throw new IllegalArgumentException("Cannot compare with null fraction.");
        }
        // So sánh hai phân số bằng cách đưa chúng về cùng mẫu số.
        int leftNumerator = this.numerator * another.denominator;
        int rightNumerator = another.numerator * this.denominator;
        if (leftNumerator < rightNumerator) {
            return -1; // this < another
        } else if (leftNumerator > rightNumerator) {
            return 1; // this > another
        } else {
            return 0; // this == another
        }

        /* TODO */
    }

    /**
     * Phương thức mô tả phân số theo định dạng numerator/denominator;
     * @return
     */
    @Override
    public String toString() {
        if (denominator == 0) {
            return "undefined";
        }
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        return numerator + "/" + denominator;

        /* TODO */
    }
}
