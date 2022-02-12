package problem.dfs_bfs.problem11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 11. 미로의 최단거리 통로(BFS)
 * 설명
 * 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
 * 경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
 * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
 * 위와 같은 경로가 최단 경로의 길이는 12이다.
 *
 * 입력
 * 첫 번째 줄부터 7*7 격자의 정보가 주어집니다.
 *
 * 출력
 * 첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.
 */

public class Main {

    private static boolean visit[][];
    private static int map[][];
    private static int distance[][];
    private static int dx[] = {1, 0, -1, 0};
    private static int dy[] = {0, 1, 0, -1};

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int bfs(int x, int y) {

        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(x, y));
        visit[x][y] = true;
        distance[x][y] = 0;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == 7 && current.y == 7) {
                return distance[current.x][current.y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (map[nx][ny] == 0 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    distance[nx][ny] = distance[current.x][current.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        visit = new boolean[9][9];
        map = new int[9][9];
        distance = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = 1;
            }
        }

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                map[i][j] = in.nextInt();
            }
        }

        System.out.println(main.bfs(1, 1));
    }
}
