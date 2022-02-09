package problem.recursive_tree_graph.problem12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 12. 경로탐색(인접리스트)
 * 입력 값
 * 5 9
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 4 5
 */

public class Main {

    private static int n, m, answer = 0;
    private static List<List<Integer>> graph;
    private static boolean[] visit;

    public void dfs(int current) {
        if (current == n) {
            answer++;
        } else {
            for (Integer i : graph.get(current)) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(i);
                    visit[i] = false;
                }
            }
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        visit = new boolean[n + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }
        visit[1] = true;
        main.dfs(1);
        System.out.println(answer);
    }
}
