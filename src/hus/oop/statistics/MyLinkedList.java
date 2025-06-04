package hus.oop.statistics;

public class MyLinkedList extends MyAbstractList {
    private MyNode top;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        this.top = null;
    }

    @Override
    public int size() {
        int count = 0;
        MyNode current = top;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    @Override
    public void add(double data) {
        MyNode newNode = new MyNode(data);
        if (top == null) {
            top = newNode;
        } else {
            MyNode current = top;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    @Override
    public void insert(double data, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        MyNode newNode = new MyNode(data);
        if (index == 0) {
            newNode.setNext(top);
            top = newNode;
        } else {
            MyNode current = getNodeByIndex(index - 1);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            top = top.getNext();
        } else {
            MyNode current = getNodeByIndex(index - 1);
            current.setNext(current.getNext().getNext());
        }
    }

    @Override
    public MyLinkedList sortIncreasing() {
        MyLinkedList sortedList = new MyLinkedList();
        MyIterator it = iterator(0);
        while (it.hasNext()) {
            sortedList.add(it.next().doubleValue());
        }

        // Bubble sort implementation
        boolean swapped;
        do {
            swapped = false;
            MyNode current = sortedList.top;
            MyNode prev = null;

            while (current != null && current.getNext() != null) {
                if (current.getData() > current.getNext().getData()) {
                    // Swap data
                    double temp = current.getData();
                    current.setData(current.getNext().getData());
                    current.getNext().setData(temp);
                    swapped = true;
                }
                prev = current;
                current = current.getNext();
            }
        } while (swapped);

        return sortedList;
    }

    @Override
    public int binarySearch(double data) {
        // For binary search to work, the list must be sorted
        MyLinkedList sortedList = this.sortIncreasing();
        int left = 0;
        int right = sortedList.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            MyNode midNode = sortedList.getNodeByIndex(mid);
            if (midNode.getData() == data) {
                return mid;
            } else if (midNode.getData() < data) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    @Override
    public double get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return getNodeByIndex(index).getData();
    }

    @Override
    public double[] toArray() {
        double[] array = new double[size()];
        MyIterator it = iterator(0);
        int index = 0;
        while (it.hasNext()) {
            array[index++] = it.next().doubleValue();
        }
        return array;
    }

    @Override
    public MyIterator iterator(int start) {
        if (start < 0 || start >= size()) {
            throw new IndexOutOfBoundsException("Start index out of bounds: " + start);
        }
        return new MyLinkedListIterator(start);
    }

    private MyNode getNodeByIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        MyNode current = top;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    private class MyLinkedListIterator implements MyIterator {
        private int currentPosition;

        public MyLinkedListIterator(int position) {
            if (position < 0 || position >= size()) {
                throw new IndexOutOfBoundsException("Position out of bounds: " + position);
            }
            this.currentPosition = position;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < size();
        }

        @Override
        public Number next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements to iterate.");
            }
            return get(currentPosition++);
        }

        @Override
        public void remove() {
            if (currentPosition <= 0) {
                throw new IllegalStateException("next() must be called before remove()");
            }
            MyLinkedList.this.remove(currentPosition - 1);
            currentPosition--;
        }
    }
}