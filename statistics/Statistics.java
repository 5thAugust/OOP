package hus.oop.statistics;

public class Statistics {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public Statistics(MyList data) {
        if (data == null) {
            throw new IllegalArgumentException("Data list cannot be null");
        }
        this.data = data;

        /* TODO */
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     * @return giá trị lớn nhất.
     */
    public double max() {
        if (data.size() == 0) {
            throw new IllegalStateException("Cannot find max in an empty list");
        }
        double max = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            double value = data.get(i);
            if (value > max) {
                max = value;
            }
        }
        return max;

        /* TODO */
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        if (data.size() == 0) {
            throw new IllegalStateException("Cannot find min in an empty list");
        }
        double min = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            double value = data.get(i);
            if (value < min) {
                min = value;
            }
        }
        return min;
        /* TODO */
    }

    /**
     * Tính kỳ vọng của mẫu theo dữ liệu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        /* TODO */
        if (data.size() == 0) {
            throw new IllegalStateException("Cannot calculate mean of an empty list");
        }
        double sum = 0.0;
        for (int i = 0; i < data.size(); i++) {
            sum += data.get(i);
        }
        return sum / data.size();

    }

    /**
     * Tính phương sai của mẫu theo dữ liệu trong list.
     * @return phương sai.
     */
    public double variance() {
        if (data.size() == 0) {
            throw new IllegalStateException("Cannot calculate variance of an empty list");
        }
        double mean = mean();
        double sumOfSquares = 0.0;
        for (int i = 0; i < data.size(); i++) {
            double value = data.get(i);
            sumOfSquares += (value - mean) * (value - mean);
        }
        return sumOfSquares / (data.size() - 1);



        /* TODO */
    }

    /**
     * Tìm kiếm trong list có phẩn tử nào có giá trị bằng data không, sử dụng binarySearch trong list.
     * Trả về index một phần tử có giá trị bằng data, nếu không tìm thấy thì trả về -1.
     * @return
     */
    public int search(double data) {
        if (this.data.size() == 0) {
            return -1; // Không tìm thấy trong danh sách rỗng
        }
        int index = this.data.binarySearch(data);
        return index >= 0 ? index : -1; // Trả về index nếu tìm thấy, -1 nếu không tìm thấy

        /* TODO */
    }

    /**
     * Tính rank của các phần tử trong list.
     * @return rank của các phần tử trong list
     */
    public double[] rank() {
        if (data.size() == 0) {
            throw new IllegalStateException("Cannot calculate rank of an empty list");
        }
        double[] ranks = new double[data.size()];
        double[] sortedData = data.sortIncreasing().toArray();
        for (int i = 0; i < data.size(); i++) {
            double value = data.get(i);
            int rank = 1; // Rank starts from 1
            for (int j = 0; j < sortedData.length; j++) {
                if (sortedData[j] < value) {
                    rank++;
                }
            }
            ranks[i] = rank;
        }
        return ranks;
        /* TODO */
    }


    public MyList sort() {
        if (data.size() == 0) {
            throw new IllegalStateException("Cannot sort an empty list");
        }
        return data.sortIncreasing(); // Sử dụng phương thức sortIncreasing của MyList để sắp xếp

        /* TODO */

    }
}
