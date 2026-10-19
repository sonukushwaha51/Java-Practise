package combinations;

public class StepCount {

    public static void main(String[] args) {
        int stairs = 6;

        int prev = 1;
        int next = 2;
        for (int i = 3; i <= stairs; i++) {
            int total = prev + next;
            prev = next;
            next = total;
        }
        System.out.println(next);
    }
}
