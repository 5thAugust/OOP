
import java.util.*;

public class MySquareMatrix {
    private int[][] data;

    public MySquareMatrix(int size) {
        initRandom(size);
    }

    private void initRandom(int size) {
        data = new int[size][size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = rand.nextInt(81) + 10;
            }
        }
    }

    public int[] principalDiagonal() {
        int[] diag = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            diag[i] = data[i][i];
        }
        return diag;
    }

    public int[] secondaryDiagonal() {
        int[] diag = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            diag[i] = data[i][data.length - 1 - i];
        }
        return diag;
    }

    public int[] primes() {
        List<Integer> list = new ArrayList<>();
        for (int[] row : data) {
            for (int val : row) {
                if (isPrime(val)) {
                    list.add(val);
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public MySquareMatrix getSortedMatrix() {
        int size = data.length;
        int[] flattened = new int[size * size];
        int idx = 0;
        for (int[] row : data) {
            for (int val : row) {
                flattened[idx++] = val;
            }
        }
        Arrays.sort(flattened);
        MySquareMatrix sorted = new MySquareMatrix(size);
        idx = flattened.length - 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sorted.data[i][j] = flattened[idx--];
            }
        }
        return sorted;
    }

    public int get(int row, int col) {
        return data[row][col];
    }

    public void set(int row, int col, int value) {
        data[row][col] = value;
    }

    public MySquareMatrix add(MySquareMatrix that) {
        int size = data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.data[i][j] = this.data[i][j] + that.data[i][j];
            }
        }
        return result;
    }

    public MySquareMatrix minus(MySquareMatrix that) {
        int size = data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.data[i][j] = this.data[i][j] - that.data[i][j];
            }
        }
        return result;
    }

    public MySquareMatrix multiply(MySquareMatrix that) {
        int size = data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        for (int i = 0; i < size; i++) {
            Arrays.fill(result.data[i], 0);
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result.data[i][j] += this.data[i][k] * that.data[k][j];
                }
            }
        }
        return result;
    }

    public MySquareMatrix scaled(int value) {
        int size = data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.data[i][j] = this.data[i][j] * value;
            }
        }
        return result;
    }

    public MySquareMatrix transpose() {
        int size = data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.data[i][j] = this.data[j][i];
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int[] row : data) {
            for (int val : row) {
                builder.append(String.format("%6d", val));
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
