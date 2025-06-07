package hus.oop.fraction;

public class MyArrayDataSet implements MyDataSet {
    private static int DEFAULT_CAPACITY = 16;
    private MyFraction[] fractions;
    private int length;

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số có kích thước là DEFAULT_CAPACITY.
     */
    public MyArrayDataSet() {
        this.fractions = new MyFraction[DEFAULT_CAPACITY];
        this.length = 0;

    }

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số truyền vào.
     * @param fractions
     */
    public MyArrayDataSet(MyFraction[] fractions) {
        if (fractions == null) {
            this.fractions = new MyFraction[DEFAULT_CAPACITY];
        } else {
            this.fractions = new MyFraction[fractions.length];
            System.arraycopy(fractions, 0, this.fractions, 0, fractions.length);
        }
        this.length = fractions != null ? fractions.length : 0;


    }

    /**
     * Phương thức chèn phân số fraction vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không chèn được vào.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction là một phân số.
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    @Override
    public boolean insert(MyFraction fraction, int index) {
        if (!checkBoundaries(index, length)) {
            return false;
        }
        if (length >= fractions.length) {
            allocateMore();
        }
        for (int i = length; i > index; i--) {
            fractions[i] = fractions[i - 1];
        }
        fractions[index] = fraction;
        length++;
        return true;

        /* TODO */
    }

    /**
     * Phương thức thêm phân số fraction vào vị trí cuối cùng chưa có dứ liệu của mảng data.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    @Override
    public boolean append(MyFraction fraction) {
        if (length >= fractions.length) {
            allocateMore();
        }
        fractions[length] = fraction;
        length++;
        return true;

        /* TODO */
    }

    @Override
    public MyArrayDataSet toSimplify() {
        MyArrayDataSet simplifiedDataSet = new MyArrayDataSet();
        for (int i = 0; i < length; i++) {
            if (fractions[i] != null) {
                MyFraction simplifiedFraction = fractions[i].simplify();
                simplifiedDataSet.append(simplifiedFraction);
            }
        }
        return simplifiedDataSet;
    }


    @Override
    public MyArrayDataSet sortIncreasing() {
        /* TODO */
        MyArrayDataSet sortedDataSet = new MyArrayDataSet();
        MyFraction[] sortedFractions = new MyFraction[length];
        System.arraycopy(fractions, 0, sortedFractions, 0, length);
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (sortedFractions[i].compareTo(sortedFractions[j]) > 0) {
                    MyFraction temp = sortedFractions[i];
                    sortedFractions[i] = sortedFractions[j];
                    sortedFractions[j] = temp;
                }
            }
        }
        for (MyFraction fraction : sortedFractions) {
            sortedDataSet.append(fraction);
        }
        return sortedDataSet;
    }

    @Override
    public MyArrayDataSet sortDecreasing() {
        MyArrayDataSet sortedDataSet = new MyArrayDataSet();
        MyFraction[] sortedFractions = new MyFraction[length];
        System.arraycopy(fractions, 0, sortedFractions, 0, length);
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (sortedFractions[i].compareTo(sortedFractions[j]) < 0) {
                    MyFraction temp = sortedFractions[i];
                    sortedFractions[i] = sortedFractions[j];
                    sortedFractions[j] = temp;
                }
            }
        }
        for (MyFraction fraction : sortedFractions) {
            sortedDataSet.append(fraction);
        }
        return sortedDataSet;
    }

    @Override
    public String myDataSetToString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(fractions[i].toString());
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();

    }

    @Override
    public void print() {
        System.out.println(myDataSetToString());

        /* TODO */
    }

    /**
     * Phương thức mở rộng kích thước mảng gấp đôi, bằng cách tạo ra mảng mới có kích thước
     * gấp đôi, sau đó copy dự liệu từ mảng cũ vào.
     */
    private void allocateMore() {
        MyFraction[] newFractions = new MyFraction[fractions.length * 2];
        System.arraycopy(fractions, 0, newFractions, 0, fractions.length);
        fractions = newFractions;

        /* TODO */
    }

    /**
     * Phương thức kiểm tra xem index có nằm trong khoảng [0, upperBound] hay không.
     * @param index
     * @param upperBound
     * @return true nếu index nằm trong khoảng [0, upperBound], false nếu ngược lại.
     */
    private boolean checkBoundaries(int index, int upperBound) {
        return index >= 0 && index <= upperBound;
        /* TODO */
    }
}
