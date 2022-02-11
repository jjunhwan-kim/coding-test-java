package problem.dfs_bfs.problem08;

import java.util.Scanner;

/**
 * 8. 수열 추측하기
 * 설명
 * 가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
 * 예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.
 *   3   1   2   4
 *     4   3   6
 *       7   9
 *         16
 *
 *  3       1       2        4
 *   (3+1)    (1+2)     (2+4)
 *     (3+1+1+2)   (1+2+2+4)
 *      (3+1+1+1+2+2+2+4) = 3+3+6+4 = 16
 *   3C0 + 3C1 + 3C2 + 3C3
 *
 *
 * N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
 * 단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.
 *
 * 입력
 * 첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다.
 * N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.
 *
 * 출력
 * 첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.
 * 답이 존재하지 않는 경우는 입력으로 주어지지 않는다.
 */

public class Main {

    private static int n, f;
    private static boolean isFound;
    private static boolean[] check;
    private static int[] permutation;
    private static int[] combination;
    private static int[][] c;

    public int combi(int n, int r) {
        if (c[n][r] > 0) return c[n][r];
        if (n == r || r == 0) {
            return c[n][r] = 1;
        }
        return c[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
    
    public void dfs(int current, int sum) {

        if (isFound) return;

        if (current == n) {
            if (sum == f) {
                for (int i = 0; i < n; i++) {
                    System.out.print(permutation[i] + " ");
                }
                System.out.println();
                isFound = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (!check[i]) {
                    check[i] = true;
                    permutation[current] = i;
                    dfs(current + 1, sum + permutation[current] * combination[current]);
                    check[i] = false;
                }
            }
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        f = in.nextInt();
        isFound = false;
        check = new boolean[n + 1];
        permutation = new int[n];
        combination = new int[n];
        c = new int[10][10];
        for (int i = 0; i < n; i++) {
            combination[i] = main.combi(n - 1, i);
        }

        main.dfs(0, 0);
    }
}
