package problem.greedy.problem07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 7. 원더랜드(최소스패닝트리)
 * 설명
 * 원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
 * 원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
 * 아래의 그림은 그 한 예를 설명하는 그림이다.
 * 위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.
 *
 * 입력
 * 첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.
 * 다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
 * 이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.
 *
 * 출력
 * 모든 도시를 연결하면서 드는 최소비용을 출려한다.
 */

public class Main {

    static class Edge {
        int v1, v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }

    public int find(int[] parent, int v) {
        if (parent[v] == v) {
            return parent[v];
        } else {
            return parent[v] = find(parent, parent[v]);
        }
    }

    public void union(int[] parent, int v1, int v2) {
        int p1 = find(parent, v1);
        int p2 = find(parent, v2);

        if (p1 != p2) {
            parent[p1] = p2;
        }
    }

    public int kruskal(int n, List<Edge> edges) {

        int answer = 0;
        int count = 0;

        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        edges.sort((o1, o2) -> o1.cost - o2.cost);

        for (Edge edge : edges) {
            int v1 = find(parent, edge.v1);
            int v2 = find(parent, edge.v2);
            if (v1 != v2) {
                union(parent, v1, v2);
                answer += edge.cost;
                count++;
                if (count == n - 1) {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        int v = in.nextInt();
        int e = in.nextInt();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int cost = in.nextInt();

            edges.add(new Edge(v1, v2, cost));
        }

        System.out.println(main.kruskal(v, edges));
    }
}