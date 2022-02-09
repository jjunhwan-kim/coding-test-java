package problem.recursive_tree_graph.problem13;

import java.util.*;

/**
 * 13. 그래프 최단거리(BFS)
 * 입력
 6 9
 1 3
 1 4
 2 1
 2 5
 3 4
 4 5
 4 6
 6 2
 6 5
 */

public class Main {

    private static int n, m;
    private static List<List<Integer>> graph;
    private static boolean[] visit;
    private static int[] distance;

    public void bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        visit[root] = true;
        distance[root] = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (!visit[next]) {
                    visit[next] = true;
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
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
        distance = new int[n + 1];

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
        main.bfs(1);

        for (int i = 1; i <= n; i++) {
            System.out.print(distance[i] + " ");
        }
    }
}
