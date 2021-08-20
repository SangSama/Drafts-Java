package buoi15.collection;

public interface List<T extends Comparable<T>> {

    int size();

    boolean isEmpty();

    boolean addHead(T t);

    boolean addTail(T t);

    boolean removeHead(T t);

    boolean removeTail(T t);

    Node<T> find(T data);

    void print();
}
