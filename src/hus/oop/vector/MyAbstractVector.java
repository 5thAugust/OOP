package hus.oop.vector;

public abstract class MyAbstractVector implements MyVector {
    /**
     * Mô tả vector theo định dạng [a1 a2 ... an]
     * @return chuỗi biểu diễn vector
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            sb.append(get(i));
            if (i < size() - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * So sánh hai vector có bằng nhau không.
     * Hai vector bằng nhau nếu có cùng kích thước và có các phần tử bằng nhau.
     * @param another vector khác để so sánh
     * @return true nếu hai vector bằng nhau, false nếu ngược lại
     */
    @Override
    public boolean equals(MyVector another) {
        // Kiểm tra null
        if (another == null) {
            return false;
        }

        // Kiểm tra cùng kích thước
        if (this.size() != another.size()) {
            return false;
        }

        // Kiểm tra từng phần tử
        for (int i = 0; i < size(); i++) {
            if (this.get(i) != another.get(i)) {
                return false;
            }
        }

        return true;
    }
}