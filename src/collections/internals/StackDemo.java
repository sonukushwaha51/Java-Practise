package collections.internals;

public class StackDemo {

    private int[] arr;

    private int maxSize;

    private int top;

    public StackDemo(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.top = -1;
    }

    public  void add(int n) {
        top++;
        arr[top] = n;
    }

    public void remove() {
        arr[top] = 0;
    }

    public int peek() {
        return arr[top];
    }

    public static void main(String[] args) {
        StackDemo stackDemo = new StackDemo(10);
        stackDemo.add(5);
        System.out.println(stackDemo.peek());
        stackDemo.remove();
        System.out.println(stackDemo.peek());
    }
}
