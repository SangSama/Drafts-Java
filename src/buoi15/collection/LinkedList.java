package buoi15.collection;

public class LinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> head; // con trỏ đầu
    private Node<T> tail; // con trỏ cuối
    private  int length;

    public LinkedList() {
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
        Node<T> node = new Node<>(t); // khởi tạo node
        // nếu rỗng => trỏ đầu và trỏ cuối đều trỏ đến node mới
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
            this.length++;
            return true;
        }
        // nếu không rỗng => node.next(mới) gán bằng this.head=node.next(cũ)
        node.setNext(this.head);
        // con trỏ đầu this.head trỏ đến node mới
        this.head = node;
        this.length++;
        return true;
    }

    @Override
    public boolean addTail(T t) {
        Node<T> node = new Node<>(t); // khởi tạo node
        // nếu rỗng => trỏ đầu và trỏ cuối đều trỏ đến node mới
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
            this.length++;
            return true;
        }
        // nếu không rỗng => this.tail=node(cũ) .next đến node(mới)
        this.tail.setNext(node);
        // con trỏ cuối trỏ đến node(mới)
        this.tail = node;
        this.length++;
        return true;
    }

    @Override
    public boolean removeHead(T t) {
        // nếu rỗng
        if (length == 0) {
            return false;
        }
        // nếu không rỗng => biến node(mới) gán bằng node tại con trỏ head
        // biến next gán bằng node tiếp theo <=> this.head.getNext()
        // con trỏ đầu trỏ vào next
        // node bằng null;
        Node<T> node = this.head;
        Node<T> next = this.head.getNext();
        this.head = next;
        node = null;
        return true;
    }

    @Override
    public boolean removeTail(T t) {
        if (length == 0) return false;
        // gán node tại node trỏ đầu
        Node<T> node = this.head;
        // chạy node, kiểm tra xem đâu là node cuối
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        // trỏ cuối vào node
        this.tail = node;
        // trỏ đến null thì coi như đã xóa bỏ node cũ
        node.setNext(null);
        return true;
    }

    @Override
    public Node<T> find(T data) {
        Node<T> node = this.head;
        while (node != null) {
            if (node.getData().equals(data)) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public void print() {
        Node<T> node = this.head;
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
    }
}
