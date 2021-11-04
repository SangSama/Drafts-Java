package buoi15.collection;

public class LinkedList2<T extends Comparable<T>> implements List2<T> {
    private Node2<T> head; // con trỏ đầu
    private Node2<T> tail; // con trỏ cuối
    private  int length;

    public LinkedList2() {
        // ban đầu thì chưa có node gì
        this.head = null;
        this.tail = null;
        this.length = 0;
    }


    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null; // kiểu tra có node không
    }

    @Override
    public boolean addHead(T t) {
        Node2<T> node = new Node2<>(t);
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
            this.length++;
            return true;
        }
        node.setNext(this.head);
        this.head.setPrev(node);
        this.head = node;
//        node.getNext().setPrev(this.head);
        this.length++;
        return true;
    }

    @Override
    public boolean addTail(T t) {
        Node2<T> node = new Node2<>(t);
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
            this.length++;
            return true;
        }
        node.setPrev(this.tail);
        this.tail.setNext(node);
        this.tail = node;
        this.length++;
        return true;
    }

    @Override
    public boolean removeHead(T t) {
        if (isEmpty()) {
            return false;
        }
        Node2<T> node = this.head;
        Node2<T> next = this.head.getNext();
        next.setPrev(null);
        this.head = next;
        node = null;
        return true;
    }

    @Override
    public boolean removeTail(T t) {
        if (isEmpty()) {
            return false;
        }
        Node2<T> node = this.tail.getPrev();
        Node2<T> tail = this.tail;
        this.tail = node;
        node.setPrev(null);
        node.setNext(null);
        return true;
    }

    @Override
    public Node<T> find(T data) {
        return null;
    }

    @Override
    public void print() {

    }
}
