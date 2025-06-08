
import java.util.Arrays;
import java.util.Random;

public class TestMatrix {
    public static void main(String[] args) {
        Random rand = new Random();
        int size = rand.nextInt(6) + 5;

        MySquareMatrix matrix1 = new MySquareMatrix(size);
        MySquareMatrix matrix2 = new MySquareMatrix(size);

        System.out.println("Matrix 1:");
        System.out.println(matrix1);

        System.out.println("Transpose of Matrix 1:");
        System.out.println(matrix1.transpose());

        System.out.println("Principal Diagonal of Matrix 1:");
        System.out.println(Arrays.toString(matrix1.principalDiagonal()));

        System.out.println("Secondary Diagonal of Matrix 1:");
        System.out.println(Arrays.toString(matrix1.secondaryDiagonal()));

        System.out.println("Matrix 2:");
        System.out.println(matrix2);

        System.out.println("Transpose of Matrix 2:");
        System.out.println(matrix2.transpose());

        System.out.println("Principal Diagonal of Matrix 2:");
        System.out.println(Arrays.toString(matrix2.principalDiagonal()));

        System.out.println("Secondary Diagonal of Matrix 2:");
        System.out.println(Arrays.toString(matrix2.secondaryDiagonal()));

        System.out.println("Matrix 1 + Matrix 2:");
        System.out.println(matrix1.add(matrix2));

        System.out.println("Matrix 1 - Matrix 2:");
        System.out.println(matrix1.minus(matrix2));

        System.out.println("Matrix 1 * Matrix 2:");
        System.out.println(matrix1.multiply(matrix2));

        System.out.println("Prime numbers in Matrix 1:");
        System.out.println(Arrays.toString(matrix1.primes()));

        System.out.println("Prime numbers in Matrix 2:");
        System.out.println(Arrays.toString(matrix2.primes()));
    }
}
