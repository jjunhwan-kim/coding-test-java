package problem.array.problem05;

import java.util.Scanner;

/**
 * 5. 소수(에라토스테네스 체)
 * 설명
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 *
 * 입력
 * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
 *
 * 출력
 * 첫 줄에 소수의 개수를 출력합니다.
 */

public class Main {

    public int solution(int n) {

        int[] check = new int[n + 1];
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (check[i] == 0) {
                for (int j = i + i; j <= n; j += i) {
                    check[j] = 1;
                }
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(main.solution(n));
    }
}
