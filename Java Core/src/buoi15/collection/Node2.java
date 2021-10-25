package buoi15.collection;

public class Node2<T extends Comparable<T>> {
    /*
    * Danh sách liên kết 2 chiều
    * */

    private T data;
    private Node2<T> next;
    private Node2<T> prev;

    public Node2(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node2<T> getNext() {
        return next;
    }

    public void setNext(Node2<T> next) {
        this.next = next;
    }

    public Node2<T> getPrev() {
        return prev;
    }

    public void setPrev(Node2<T> prev) {
        this.prev = prev;
    }
}
