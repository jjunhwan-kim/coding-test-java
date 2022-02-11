package problem.dfs_bfs.problem07;

import java.util.Scanner;

/**
 * 7. 조합의 경우수(메모이제이션)
 * nCr = n! / ((n - r)! * r!) 로 계산합니다.
 * 하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
 * nCr = n-1Cr-1 + n-1Cr
 * n개 중 r개를 뽑을 때, n 번째가 포함이 되는 경우 n-1Cr-1
 *                   n 번째가 포함이 안되는 경우 n-1Cr
 *                   따라서 두 개의 합인 n-1Cr-1 + n-1Cr이 nCr이 된다.
 *
 * 입력
 * 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
 *
 * 출력
 * 첫째 줄에 조합수를 출력합니다.
 */

public class Main {

    private int[][] combination = new int[35][35];

    public int dfs(int n, int r) {

        if (combination[n][r] > 0) {
            return combination[n][r];
        }

        if (r == 0 || n == r) {
            return combination[n][r] = 1;
        }

        return combination[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int r = in.nextInt();
        System.out.println(main.dfs(n, r));
    }
}
