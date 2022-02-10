package problem.dfs_bfs.problem06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 6. 순열 구하기
 * 10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 *
 * ▣ 입력설명
 * 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
 * 두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.
 *
 * ▣ 출력설명
 * 첫 번째 줄에 결과를 출력합니다.
 * 출력순서는 사전순으로 오름차순으로 출력합니다.
 *
 * ▣ 입력예제 1
 * 3 2
 * 3 6 9
 *
 * ▣ 출력예제 1
 * 3 6
 * 3 9
 * 6 3
 * 6 9
 * 9 3
 * 9 6
 */

public class Main {

    private static int n, m;
    private static boolean[] check;
    private static int[] result;
    private static int[] arr;

    public void dfs(int current) {

        if (current == m) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (!check[i]) {
                    check[i] = true;
                    result[current] = arr[i];
                    dfs(current + 1);
                    check[i] = false;
                }
            }
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        check = new boolean[n];
        arr = new int[n];
        result = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        main.dfs(0);
    }
}
