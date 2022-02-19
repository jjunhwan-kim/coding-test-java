package problem.dynamic_programming.problem01;

import java.util.*;

/**
 * 1. 계단오르기
 * 설명
 * 철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는
 * 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.
 * 그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?
 *
 * 입력
 * 첫째 줄은 계단의 개수인 자연수 N(3≤N≤35)이 주어집니다.
 *
 * 출력
 * 첫 번째 줄에 올라가는 방법의 수를 출력합니다.
 */

public class Main {

    public int solution(int n) {

        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        return arr[n];
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        System.out.println(main.solution(n));
    }
}