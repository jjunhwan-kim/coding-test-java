package problem.recursive_tree_graph.problem06;

/**
 * 6. 부분집합 구하기
 */

public class Main {

    public void dfs(int current, int n, boolean[] check) {

        if (current == n + 1) {
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= n; i++) {
                if (check[i]) {
                    sb.append(i + " ");
                }
            }

            if (sb.length() > 0) {
                System.out.println(sb.toString());
            }
        } else {
            check[current] = true;
            dfs(current + 1, n, check);

            check[current] = false;
            dfs(current + 1, n, check);
        }
    }

    public static void main(String[] args){
        Main main = new Main();

        int n = 3;
        boolean[] check = new boolean[n + 1];
        main.dfs(1, n, check);
    }
}
