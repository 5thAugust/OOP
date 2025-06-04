package hus.oop.vector;

public class MyArrayVector extends MyAbstractVector {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyArrayVector() {
        this.data = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public double get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return data[index];
    }

    @Override
    public double[] coordinates() {
        double[] coordinates = new double[size];
        System.arraycopy(data, 0, coordinates, 0, size);
        return coordinates;
    }

    @Override
    public MyArrayVector insert(double value) {
        return insert(value, size);
    }

    @Override
    public MyArrayVector insert(double value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (size == data.length) {
            allocateMore();
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
        return this;
    }

    @Override
    public MyArrayVector remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return this;
    }

    @Override
    public MyArrayVector extract(int[] indices) {
        MyArrayVector extracted = new MyArrayVector();
        for (int index : indices) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index out of bounds: " + index);
            }
            extracted.insert(data[index]);
        }
        return extracted;
    }

    @Override
    public void set(double value, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        data[index] = value;
    }

    @Override
    public MyArrayVector add(double value) {
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] + value);
        }
        return result;
    }

    @Override
    public MyArrayVector add(MyVector another) {
        if (another.size() != size) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] + another.get(i));
        }
        return result;
    }

    @Override
    public MyArrayVector addTo(double value) {
        for (int i = 0; i < size; i++) {
            data[i] += value;
        }
        return this;
    }

    @Override
    public MyArrayVector addTo(MyVector another) {
        if (another.size() != size) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        for (int i = 0; i < size; i++) {
            data[i] += another.get(i);
        }
        return this;
    }

    @Override
    public MyArrayVector minus(double value) {
        return add(-value);
    }

    @Override
    public MyArrayVector minus(MyVector another) {
        if (another.size() != size) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] - another.get(i));
        }
        return result;
    }

    @Override
    public MyArrayVector minusFrom(double value) {
        for (int i = 0; i < size; i++) {
            data[i] = value - data[i];
        }
        return this;
    }

    @Override
    public MyArrayVector minusFrom(MyVector another) {
        if (another.size() != size) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        for (int i = 0; i < size; i++) {
            data[i] = another.get(i) - data[i];
        }
        return this;
    }

    @Override
    public double dot(MyVector another) {
        if (another.size() != size) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += data[i] * another.get(i);
        }
        return result;
    }

    @Override
    public MyArrayVector pow(double power) {
        for (int i = 0; i < size; i++) {
            data[i] = Math.pow(data[i], power);
        }
        return this;
    }

    @Override
    public MyArrayVector scale(double value) {
        for (int i = 0; i < size; i++) {
            data[i] *= value;
        }
        return this;
    }

    @Override
    public double norm() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += data[i] * data[i];
        }
        return Math.sqrt(sum);
    }

    /**
     * Mở rộng kích thước vector lên gấp đôi khi cần thiết.
     */
    private void allocateMore() {
        double[] newData = new double[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}