package hus.oop.fraction;

import java.util.Random;

public class TestFraction {
    private MyDataSet myDataSet;

    public TestFraction(MyDataSet myDataSet) {
        this.myDataSet = myDataSet;
    }

    public static void main(String[] args) {
        // Tạo một đối tượng MyArrayDataSet để kiểm thử
        TestFraction testArray = new TestFraction(new MyArrayDataSet());
        testArray.testMyArrayDataSet();

        // Tạo một đối tượng MyListDataSet để kiểm thử
        TestFraction testList = new TestFraction(new MyListDataSet());
        testList.testMyListDataSet();

        System.out.println("Chương trình đã chạy xong!");
    }

    public void testMyArrayDataSet() {
        Random random = new Random();
        int numbers = random.nextInt(21) + 30; // Sinh ngẫu nhiên số [30, 50]

        // Tạo và thêm phân số vào MyArrayDataSet
        for (int i = 0; i < numbers; i++) {
            int numerator = random.nextInt(100) + 1;
            int denominator = random.nextInt(100) + 1;
            myDataSet.append(new MyFraction(numerator, denominator));
        }

        // In tập dữ liệu ban đầu
        System.out.println("Tập dữ liệu ban đầu:");
        myDataSet.print();

        // Sắp xếp tăng dần
        System.out.println("Tập dữ liệu sắp xếp tăng dần:");
        myDataSet.sortIncreasing().print();

        // Sắp xếp giảm dần
        System.out.println("Tập dữ liệu sắp xếp giảm dần:");
        myDataSet.sortDecreasing().print();

        // In phân số tối giản
        System.out.println("Phân số tối giản:");
        myDataSet.toSimplify().print();
    }

    public void testMyListDataSet() {
        Random random = new Random();
        int numbers = random.nextInt(21) + 30; // Sinh ngẫu nhiên số [30, 50]

        // Tạo và thêm phân số vào MyListDataSet
        for (int i = 0; i < numbers; i++) {
            int numerator = random.nextInt(100) + 1;
            int denominator = random.nextInt(100) + 1;
            myDataSet.append(new MyFraction(numerator, denominator));
        }

        // In tập dữ liệu ban đầu
        System.out.println("Tập dữ liệu ban đầu:");
        myDataSet.print();

        // Sắp xếp tăng dần
        System.out.println("Tập dữ liệu sắp xếp tăng dần:");
        myDataSet.sortIncreasing().print();

        // Sắp xếp giảm dần
        System.out.println("Tập dữ liệu sắp xếp giảm dần:");
        myDataSet.sortDecreasing().print();

        // In phân số tối giản
        System.out.println("Phân số tối giản:");
        myDataSet.toSimplify().print();
    }
}