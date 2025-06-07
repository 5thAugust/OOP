package hus.oop.statistics;

public class TestStatistics {
    private Statistics statistics;

    public TestStatistics(Statistics statistics) {
        /* TODO */
    }

    public static void main(String[] args) {
        /* TODO
           - Thực hiện từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
             là <TenSinhVien_MaSinhVien_Statistics>.txt (Ví dụ, NguyenVanA_123456_Statistics.txt).
           - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
             <TenSinhVien_MaSinhVien_Statistics>.zip (Ví dụ, NguyenVanA_123456_Statistics.zip),
             nộp lên classroom.
         */
        TestStatistics test = new TestStatistics(new Statistics(new MyArrayList()));
        test.testMyArrayList();
        test = new TestStatistics(new Statistics(new MyLinkedList()));
        test.testMyLinkedList();

    }

    public void testMyArrayList() {
        /* TODO
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một list kiểu MyArrayList, có các phần tử dữ liệu kiểu double được sinh ngẫu nhiên
             nằm trong đoạn [1, 20]. Tạo Statistics có dữ liệu là list dữ liệu vừa tạo, lưu vào statistics.
           - Sử dụng Statistics để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, sắp xếp, tìm kiếm).
             In ra terminal tập dữ liệu, tập dữ liệu được sắp xếp, các đại lượng thống kê và kết quả chức năng tìm kiếm.
         */
        // Example implementation
        int length = (int) (Math.random() * 21) + 30; // Random number between 30 and 50
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < length; i++) {
            double randomValue = Math.random() * 19 + 1; // Random double between 1 and 20
            list.add(randomValue);
        }
        statistics = new Statistics(list);
        System.out.println("Original Data: " + list);
        System.out.println("Max: " + statistics.max());
        System.out.println("Min: " + statistics.min());
        System.out.println("Mean: " + statistics.mean());
        System.out.println("Variance: " + statistics.variance());
        System.out.println("Rank: " + statistics.rank());
        MyList sortedList = statistics.sort();
        System.out.println("Sorted Data: " + sortedList);
        double searchValue = list.get((int) (Math.random() * length)); // Randomly select a value to search
        int searchResult = statistics.search(searchValue);
        System.out.println("Search for " + searchValue + ": " + (searchResult != -1 ? "Found at index " + searchResult : "Not found"));

    }

    public void testMyLinkedList() {
        /* TODO
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một list kiểu MyLinkedList, có các phần tử lưu dữ liệu kiểu double được sinh ngẫu nhiên
             nằm trong đoạn [1, 20]. Tạo Statistics có dữ liệu là list dữ liệu vừa tạo, lưu vào statistics.
           - Sử dụng Statistics để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, sắp xếp, tìm kiếm).
             In ra terminal tập dữ liệu, tập dữ liệu được sắp xếp, các đại lượng thống kê và kết quả chức năng tìm kiếm.
         */
        // Example implementation
        int length = (int) (Math.random() * 21) + 30; // Random number between 30 and 50
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < length; i++) {
            double randomValue = Math.random() * 19 + 1; // Random double between 1 and 20
            list.add(randomValue);
        }
        statistics = new Statistics(list);
        System.out.println("Original Data: " + list);
        System.out.println("Max: " + statistics.max());
        System.out.println("Min: " + statistics.min());
        System.out.println("Mean: " + statistics.mean());
        System.out.println("Variance: " + statistics.variance());
        System.out.println("Rank: " + statistics.rank());
        MyList sortedList = statistics.sort();
        System.out.println("Sorted Data: " + sortedList);
        double searchValue = list.get((int) (Math.random() * length)); // Randomly select a value to search
        int searchResult = statistics.search(searchValue);
        System.out.println("Search for " + searchValue + ": " + (searchResult != -1 ? "Found at index " + searchResult : "Not found"));

    }
}
