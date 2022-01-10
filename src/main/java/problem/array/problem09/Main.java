package problem.array.problem09;

import java.util.Scanner;

/**
 * 9. 격자판 최대합
 * 설명
 * 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 *
 * 입력
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 * 출력
 * 최대합을 출력합니다.
 */

public class Main {

    public int solution(int n, int[][] arr) {

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += arr[i][j];
                colSum += arr[j][i];
            }
            if (rowSum > answer) answer = rowSum;
            if (colSum > answer) answer = colSum;
        }
        int diagonalSum1 = 0;
        int diagonalSum2 = 0;

        for (int i = 0; i < n; i++) {
            diagonalSum1 += arr[i][i];
            diagonalSum2 += arr[i][n - 1 - i];
        }

        if (diagonalSum1 > answer) answer = diagonalSum1;
        if (diagonalSum2 > answer) answer = diagonalSum2;

        return answer;
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(main.solution(n, arr));
    }
}
