package problem.dynamic_programming.problem05;

import java.util.*;

/**
 * 5. 동전교환(냅색 알고리즘)
 * 설명
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
 * 각 단위의 동전은 무한정 쓸 수 있다.
 *
 * 입력
 * 첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다.
 * 두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
 * 각 동전의 종류는 100원을 넘지 않는다.
 *
 * 출력
 * 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
 */

/**
 * 5
 * 1 8 20 25 50
 * 129
 *
 * 50 - 2
 * 20 - 1
 * 1 - 1
 * 8 - 1
 */
public class Main {

    public int solution(int m, int[] arr) {

        // dy[i] = i 금액을 만드는데 드는 최소 동전 개수
        int[] dy = new int[m + 1];

        dy[0] = 0;
        Arrays.sort(arr);

        // 1원을 사용하여 i 금액을 만드는 개수로 초기화
        for (int i = 1; i <= m; i++) {
            dy[i] = Integer.MAX_VALUE;
        }

        for (int coin : arr) {
            for (int i = coin; i <= m; i++) {
                dy[i] = Math.min(dy[i], dy[i - coin] + 1);
            }
        }

        return dy[m];
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int m = in.nextInt();

        System.out.println(main.solution(m, arr));
    }
}