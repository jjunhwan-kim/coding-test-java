package problem.greedy.problem05;

import java.util.*;

/**
 * 5. 다익스트라 알고리즘
 * 아래의 가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로
 * 그램을 작성하세요. (경로가 없으면 Impossible를 출력한다)
 *
 * ▣ 입력설명
 * 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연
 * 결정보와 거리비용이 주어진다.
 *
 * ▣ 출력설명
 * 1번 정점에서 각 정점으로 가는 최소비용을 2번 정점부터 차례대로 출력하세요.
 *
 * ▣ 입력예제 1
 * 6 9
 * 1 2 12 // 1번 정점에서 2번정점으로 가는데 12의 비용이 든다.
 * 1 3 4
 * 2 1 2
 * 2 3 5
 * 2 5 5
 * 3 4 5
 * 4 2 2
 * 4 5 5
 * 6 4 5
 *
 * ▣ 출력예제 1
 * 2 : 11
 * 3 : 4
 * 4 : 9
 * 5 : 14
 * 6 : impossible
 */

public class Main {

    static class Edge {
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    public void solution(List<List<Edge>> graph, int[] distance, int startVertex) {

        Queue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        distance[startVertex] = 0;
        queue.offer(new Edge(startVertex, 0));

        while (!queue.isEmpty()) {

            Edge currentEdge = queue.poll();

            if (currentEdge.cost > distance[currentEdge.vertex]) continue;

            for (Edge edge : graph.get(currentEdge.vertex)) {
                int cost = currentEdge.cost + edge.cost;
                if (distance[edge.vertex] > cost) {
                    distance[edge.vertex] = cost;
                    queue.offer(new Edge(edge.vertex, cost));
                }
            }
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int cost = in.nextInt();

            graph.get(v1).add(new Edge(v2, cost));
        }

        main.solution(graph, distance, 1);

        for (int i = 2; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) System.out.println(i + " : impossible");
            else System.out.println(i + " : " + distance[i]);
        }
    }
}