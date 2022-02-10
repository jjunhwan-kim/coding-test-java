package problem.dfs_bfs.problem04;

import java.util.Scanner;

/**
 * 4. 중복순열
 * 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열
 * 하는 방법을 모두 출력합니다.
 *
 * ▣ 입력설명
 * 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
 *
 * ▣ 출력설명
 * 첫 번째 줄에 결과를 출력합니다.
 * 출력순서는 사전순으로 오름차순으로 출력합니다.
 *
 * ▣ 입력예제 1
 * 3 2
 *
 * ▣ 출력예제 1
 * 1 1
 * 1 2
 * 1 3
 * 2 1
 * 2 2
 * 2 3
 * 3 1
 * 3 2
 * 3 3
 */

public class Main {

    private static int n, m;
    private static int[] result;

    public void dfs(int current) {
        if (current == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                result[current] = i;
                dfs(current + 1);
            }
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        result = new int[m];
        main.dfs(0);
    }
}
