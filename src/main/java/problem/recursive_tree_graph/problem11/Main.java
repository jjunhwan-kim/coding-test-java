package problem.recursive_tree_graph.problem11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 11. 경로탐색(DFS)
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
    private static boolean[][] graph;
    private static boolean[] visit;

    public void dfs(int current) {
        if (current == n) {
            answer++;
        } else {
            for (int i = 0; i <= n; i++) {
                if (graph[current][i] && !visit[i]) {
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
        graph = new boolean[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph[a][b] = true;
        }
        visit[1] = true;
        main.dfs(1);
        System.out.println(answer);
    }
}
