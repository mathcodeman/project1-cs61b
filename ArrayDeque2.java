package deque;

public class ArrayDeque2 {
    public int [] arr;
    public int size;
    public int listSize = 100;

    /*Construtor*/
    public ArrayDeque2(){
        arr = new int[listSize];
        size = 0;
    }
    public boolean isFull(){
        if (size >= listSize){
            return true;
        }return false;
    }

    public void addFirst(int item){
        if (isFull() == true){
            listSize *= 2;
        }
        int [] newArr = new int[listSize];
        newArr[0] = item;
        for (int i = 0; i < size; i++){
            newArr[i+1] = arr[i];
        }
        arr = newArr;
        size += 1;
    }

    public int getFirst(){
        return arr[0];
    }

    public void addLast(int items){
        if (isFull() == true){
            listSize *= 2;
        }
        int [] newArr = new int[listSize];
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

    public int size() {
        return size;
    }

    public int removeFirst(){
        int returnitem = arr[0];
        for (int i = 0; i < size - 1; i++){
            arr[i] = arr[i+1];
        }
        size -= 1;
        return returnitem;
    }

    public int removeLast(){
        int returnitem = arr[size-1];
        int [] newArr = new int[listSize];
        for (int i = 0; i < size - 1;i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
        size -= 1;
        return returnitem;
    }

    public int get(int index){
        return arr[index];
    }

    public String printDeque(){
        String s = "";
        for (int i = 0; i < size; i++){
            s += arr[i] + " ";
        }return s;
    }

    public static void main(String[] args){
        ArrayDeque2 L = new ArrayDeque2();
        for (int i = 201; i > 0; i--){
            L.addFirst(i);
        }
        L.addLast(1);
        System.out.println(L.printDeque());
        System.out.println("Removed last item: " + L.removeLast());
        System.out.println("Get item: " + L.get(1));
        System.out.println("Removed fist item: " + L.removeFirst());
        System.out.println("Is empty?: " + L.isEmpty());
        System.out.println("What is the size?: " + L.size());
        System.out.println("First item: " + L.getFirst());
        System.out.println(L.printDeque());
    }
}
