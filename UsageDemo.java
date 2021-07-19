package deque;

public class UsageDemo {
    public static void main(String[] args){
        Deque<Double> D1 = new ArrayDeque<>();
        for (int i = 0;i < 5;i++){
            D1.addLast(0.00);
        }
        for (int i = 0;i < D1.size();i++) {
            D1.removeFirst();
            D1.addLast(12.0);
        }
        D1.printDeque();
        double first = D1.removeFirst();
        System.out.println(first);
        D1.printDeque();
        double firstNext = D1.getFirst();
        System.out.println(firstNext);
        double newSample = 0.5 * 2 * (first+firstNext);
        D1.addLast(newSample);
        D1.printDeque();
    }
}
