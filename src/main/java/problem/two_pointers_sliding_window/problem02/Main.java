package problem.two_pointers_sliding_window.problem02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 2. 공통원소 구하기
 * 설명
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
 *
 * 출력
 * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
 */

public class Main {

    public List<Integer> solution(int n, int m, int[] a, int[] b) {

        List<Integer> answer = new ArrayList<>();
        int lt = 0;
        int rt = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        while (lt < n && rt < m) {
            if (a[lt] == b[rt]) {
                answer.add(a[lt]);
                lt++;
                rt++;
            } else if (a[lt] < b[rt]) {
                lt++;
            } else {
                rt++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }

        for (int i : main.solution(n, m, a, b)) {
            System.out.print(i + " ");
        }
    }
}
