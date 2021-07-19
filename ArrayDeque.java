package deque;

public class ArrayDeque<T> implements Deque<T>{
    public Object arr[];
    public int size;
    public int listSize = 100;

    /*Constructor*/
    public ArrayDeque(){
        arr = new Object[listSize];
        size = 0;
    }
    public boolean isFull(){
        if (size >= listSize){
            return true;
        }return false;
    }

    public void addFirst(T item){
        if (isFull() == true){
            listSize *= 2;
        }
        Object[] newArr = new Object[listSize];
        newArr[0] = item;
        for (int i = 0; i < size; i++){
            newArr[i+1] = arr[i];
        }
        arr = newArr;
        size += 1;
    }

    public T getFirst(){
        return (T) arr[0];
    }

    public void addLast(T items){
        if (isFull() == true){
            listSize *= 2;
        }
        Object [] newArr = new Object[listSize];
        for (int i = 0;i < size; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
        arr[size] = items;
        size += 1;
    }
     public boolean isEmpty(){
        if (size != 0){
            return false;
        }
        return true;
     }

     public boolean contains(T item){
        for (int i = 0; i < size; i++){
            if (arr[i] == item){
                return true;
            }
        }return false;
     }

    public int size() {
        return size;
    }

    public T removeFirst(){
        if (size == 0){
            return null;
        }else{
            T returnitem = (T) arr[0];
            for (int i = 0; i < size - 1; i++){
                arr[i] = arr[i+1];
            }
            size -= 1;
            return returnitem;
        }

    }

    public T removeLast(){
        if (size == 0){
            return null;
        }else{
            T returnitem = (T) arr[size-1];
            Object [] newArr = new Object[listSize];
            for (int i = 0; i < size - 1;i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
            size -= 1;
            return returnitem;
        }

    }

    public T get(int index){
        return (T) arr[index];
    }

    public String printDeque(){
        String s = "";
        for (int i = 0; i < size; i++){
            s += arr[i] + " ";
        }System.out.println(s);
        return s;
    }

    @Override
    public boolean equals(Object other){
        int pt1 = 0;
        int pt2 = 0;
        ArrayDeque<T> otherArray = (ArrayDeque<T>) other;
        if (this.size() != otherArray.size()){
            return false;
        }
        if (otherArray.getClass() != this.getClass()){
            return false;
        }
        while (pt1 < this.size() && pt2 < otherArray.size()){
            if (this.arr[pt1] != otherArray.get(pt2)){
                return false;
            }
            pt1 += 1;
            pt2 += 1;
        }return true;
    }

    public static void main(String[] args){
        ArrayDeque<String> L1 = new ArrayDeque<String>();
        ArrayDeque<String> L2 = new ArrayDeque<String>();
        L1.addFirst("Hi");
        L2.addFirst("Hi");
        L1.addLast("James");
        System.out.println(L1.contains("hi"));
        System.out.println(L1.equals(L2));

    }
}
