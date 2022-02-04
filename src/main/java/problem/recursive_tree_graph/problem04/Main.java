package problem.recursive_tree_graph.problem04;

/**
 * 4. 피보나치
 */

public class Main {

    private int fi[];

    public int fibo(int n) {
        if (fi[n] > 0) {
            return fi[n];
        } else {
            if (n == 1) {
                return fi[n] = 1;
            } else if (n == 2) {
                return fi[n] = 1;
            } else {
                return fi[n] = fibo(n - 2) + fibo(n - 1);
            }
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        int n = 45;
        main.fi = new int[n + 1];
        main.fibo(45);

        for (int i = 1; i <= n; i++) System.out.println(main.fi[i] + " ");
    }
}
