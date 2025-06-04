package hus.oop.statistics;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        this.data = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(double data) {
        if (size >= this.data.length) {
            allocateMore();
        }
        this.data[size] = data;
        size++;
    }

    @Override
    public void insert(double data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (size >= this.data.length) {
            allocateMore();
        }
        // Shift elements to make space
        System.arraycopy(this.data, index, this.data, index + 1, size - index);
        this.data[index] = data;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        // Shift elements to fill the gap
        System.arraycopy(this.data, index + 1, this.data, index, size - index - 1);
        this.data[size - 1] = 0; // Clear the last element
        size--;
    }

    @Override
    public MyArrayList sortIncreasing() {
        MyArrayList sortedList = new MyArrayList();
        // Copy elements to new list
        for (int i = 0; i < size; i++) {
            sortedList.add(data[i]);
        }
        // Use optimized bubble sort
        boolean swapped;
        for (int i = 0; i < sortedList.size - 1; i++) {
            swapped = false;
            for (int j = 0; j < sortedList.size - i - 1; j++) {
                if (sortedList.data[j] > sortedList.data[j + 1]) {
                    // Swap elements
                    double temp = sortedList.data[j];
                    sortedList.data[j] = sortedList.data[j + 1];
                    sortedList.data[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps occurred, the array is sorted
            if (!swapped) break;
        }
        return sortedList;
    }

    @Override
    public int binarySearch(double data) {
        MyArrayList sortedList = this.sortIncreasing();
        // The array must be sorted for binary search
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedList.data[mid] == data) {
                return mid;
            } else if (sortedList.data[mid] < data) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    @Override
    public double get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return data[index];
    }

    @Override
    public double[] toArray() {
        double[] array = new double[size];
        System.arraycopy(data, 0, array, 0, size);
        return array;
    }

    @Override
    public MyIterator iterator(int start) {
        if (start < 0 || start >= size) {
            throw new IndexOutOfBoundsException("Start index out of bounds: " + start);
        }
        return new MyArrayListIterator(start);
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void allocateMore() {
        double[] newData = new double[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    private class MyArrayListIterator implements MyIterator {
        private int currentPosition;

        public MyArrayListIterator(int position) {
            if (position < 0 || position >= size) {
                throw new IndexOutOfBoundsException("Position out of bounds: " + position);
            }
            this.currentPosition = position;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < size;
        }

        @Override
        public Number next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements to iterate.");
            }
            return data[currentPosition++];
        }

        @Override
        public void remove() {
            if (currentPosition <= 0) {
                throw new IllegalStateException("next() must be called before remove()");
            }
            MyArrayList.this.remove(currentPosition - 1);
            currentPosition--;
        }
    }
}