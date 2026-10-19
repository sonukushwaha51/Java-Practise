package combinations;

public class JosephusProblem {

    public static void main(String[] args) {
        int n = 7; int k = 3;
        int survivor = findSurvivor(n, k);
        System.out.println(survivor);
    }

    private static int findSurvivor(int n, int k) {
        int survivor = 0;
        for (int i = 1; i <= n; i++) {
            survivor = (survivor + k) % i;
            System.out.println(survivor);
        }
        return survivor + 1;
    }
}
