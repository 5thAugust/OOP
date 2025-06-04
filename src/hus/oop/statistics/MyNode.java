package hus.oop.statistics;

public class MyNode {
    public double data;
    public MyNode next;
    public MyNode previous;

    public MyNode(double data) {
        this.data = data;
        this.next = null;
        this.previous = null;

        /* TODO */
    }

    public MyNode(double data, MyNode next, MyNode previous) {
        /* TODO */
    }

    public MyNode getNext() {
        return next;

    }

    public void setNext(MyNode top) {
        this.next = top;

    }

    public double getData() {
        return data;

    }

    public void setData(double data) {
        this.data = data;

    }
}
