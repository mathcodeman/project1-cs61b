package deque;

public interface Deque<T> {
    public void addFirst(T item);
    public void addLast(T item);
    public T getFirst();
    public boolean isEmpty();
    public int size();
    public T removeFirst();
    public T removeLast();
    public boolean contains(T item);
    public T get(int index);
    public String printDeque();
    public boolean equals(Object other);
}
