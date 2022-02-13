package problem.dfs_bfs.problem13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 13. 섬나라 아일랜드
 * 설명
 * N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
 * 각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
 * 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
 * 만약 위와 같다면 섬의 개수는 5개입니다.
 *
 * 입력
 * 첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
 * 두 번째 줄부터 격자판 정보가 주어진다.
 *
 * 출력
 * 첫 번째 줄에 섬의 개수를 출력한다.
 */

public class Main {

    private static int n;
    private static int map[][];
    private static int dx[] = {1, 1, 0, -1, -1, -1, 0, 1};
    private static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void dfs(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if (map[ny][nx] == 1) {
                map[ny][nx] = 0;
                dfs(nx, ny);
            }
        }
    }

    public void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        map[y][x] = 0;
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int ny = dy[i] + current.y;
                int nx = dx[i] + current.x;

                if (map[ny][nx] == 1) {
                    map[ny][nx] = 0;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();

        map = new int[n + 2][n + 2];

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                map[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = in.nextInt();
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1) {
                    //map[i][j] = 0;
                    //main.dfs(j, i);
                    main.bfs(j, i);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
