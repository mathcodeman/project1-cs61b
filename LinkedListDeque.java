package deque;

public class LinkedListDeque<T> implements Deque<T> {
    public class Node{
        public T item;
        public Node next;
        public Node previous;

        /* Constructor */
        public Node(T i, Node pr , Node n){
            item = i;
            previous = pr;
            next = n;

        }
    }

    private Node head;
    private Node tail;
    public LinkedListDeque(){
        head = new Node(null,null, null);
        tail = new Node(null,head,null);
        head.next = tail;
    }
    int size = 0;

    public void addFirst(T item){
        size += 1;
        Node temp = head.next;
        Node newNode = new Node(item, head, temp);
        head.next = newNode;
        temp.previous = newNode;
    }

    public T getFirst(){
        return head.next.item;
    }

    public void addLast(T item){
        size += 1;
        Node temp = tail.previous;
        Node newNode = new Node(item,temp,tail);
        tail.previous = newNode;
        temp.next = newNode;
    }


    public boolean isEmpty(){
        Node p = head;
        if (p.next == tail){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public T removeFirst(){
        Node p = head.next;
        if (p == tail){
            return null;
        }else{
            T returnNode = p.item;
            Node temp = p.next;
            head.next = temp;
            temp.previous = head;
            size -= 1;
            return returnNode;

        }

    }

    public T removeLast(){
        Node p = tail.previous;
        if (p == head){
            p = null;
            return null;
        }else{
            T returnItem = p.item;
            Node temp = p.previous;
            tail.previous = temp;
            temp.next = tail;
            size -= 1;
            return returnItem;
        }

    }

    public boolean contains(T item){
        Node p = head;
        while (p.next != null){
            if (p.item == item){
                return true;
            }else{
                p = p.next;
            }
        }return false;
    }

    public T get(int index){
        Node p = head.next;
        if (index + 1 > size){
            return null;
        }else{
            for (int i = 0; i < index; i++){
                p = p.next;
            }
            return p.item;
        }

    }

    public String printDeque(){
        Node p = head.next;
        String s = "";
        while (p != null){
            if (p.item != null) {
                s += p.item.toString() + " ";
            }
            p = p.next;
        }
        System.out.println(s);
        return s;
    }

    @Override
    public boolean equals(Object other){
        /*TODO*/
        LinkedListDeque<T> otherList = (LinkedListDeque<T>) other;
        Node pt1 = this.head;
        Node pt2 = otherList.head;
        if (pt1.next == tail){
            return false;
        }
        if (otherList.size() != this.size()){
            return false;
        }
        if (otherList.getClass() != this.getClass()){
            return false;
        }
        while (pt1.next != null && pt2.next != null){
            if (pt1.item != pt2.item){
                return false;
            }
            pt1 = pt1.next;
            pt2 = pt2.next;
        }
        return true;
    }

    public static void main(String[] args){
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<>();
        /*for (int i = 0; i < 100; i++){
            lld1.addLast(i);
            lld2.addLast(i);
        }
        lld2.removeLast();
        lld2.addLast(99);
        lld2.addLast(1);*/
        System.out.println(lld1.equals(lld2));
        System.out.println(lld1.printDeque());
    }



}
