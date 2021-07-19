package deque;

public class LinkedListDeque2<T> {
    public class Node{
        public T item;
        public Node next;

        /* Constructor */
        public Node(T i, Node n){
            item = i;
            next = n;
        }
    }

    private Node head;
    public LinkedListDeque2(){
        head = new Node(null,null);
    }
    int size = 0;

    public void addFirst(T item){
        size += 1;
        Node temp = head.next;
        Node newNode = new Node(item, temp);
        head.next = newNode;
    }

    public T getFirst(){
        return head.next.item;
    }

    public void addLast(T item){
        size += 1;
        Node p = head;
        if (p.next == null){
            head.next = new Node(item, null);
        }

        while (p.next != null){
            p = p.next;
        }
        p.next = new Node(item, null);
    }


    public boolean isEmpty(){
        Node p = head;
        if (p.next == null){
            return true;
        }
        return false;
    }

    public int size(){
        /* TODO */
        return size;
    }

    public void removeFirst(){
        Node p = head.next;
        if (p == null){
            p = null;
        }else{
            head.next = p.next;
        }

    }

    public void removeLast(){
        size -= 1;
        Node p = head;
        if (p.next == null){
            p = null;
        }

        while (p.next.next != null){
            p = p.next;
        }
        Node last = p.next;
        p.next = null;
        last = null;
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

    public String iterator(){
        Node p = head.next;
        String s = "";
        while (p != null){
            s += p.item.toString() + ",";
            p = p.next;
        }return s;
    }

    public boolean equals(Object o){
        /*TODO*/
        return false;
    }

    public static void main(String[] args){
        LinkedListDeque2<String> L = new LinkedListDeque2<String>();
        L.addFirst("World");
        L.addFirst("Hi");
        L.addFirst("Hey");
        System.out.println(L.getFirst());
        L.addLast("James");
        System.out.println(L.isEmpty());
        System.out.println(L.size());
        L.removeFirst();
        L.removeLast();
        System.out.println(L.get(0));
        System.out.println(L.iterator());
    }



}