package problem.dfs_bfs.problem01;

import java.util.*;

/**
 * 1. 합이 같은 부분집합(DFS : 아마존 인터뷰)
 * 설명
 * N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
 * 두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
 * 둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
 * 예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.
 *
 * 입력
 * 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
 * 두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.
 *
 * 출력
 * 첫 번째 줄에 “YES" 또는 ”NO"를 출력한다.
 */

public class Main {

    private static int n;
    private static int[] arr;
    private static int total;
    private static String answer = "NO";
    private static boolean isFound = false;

    public void dfs(int current, int sum1, int sum2) {

        if (isFound) {
            return;
        }

        if (sum1 > total / 2 || sum2 > total / 2) {
            return;
        }

        if (current == n) {
            if (sum1 == sum2) {
                isFound = true;
                answer = "YES";
            }
        } else {
            dfs(current + 1, sum1 + arr[current], sum2);
            dfs(current + 1, sum1, sum2 + arr[current]);
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            total += arr[i];
        }

        main.dfs(0, 0, 0);
        System.out.println(answer);
    }
}
