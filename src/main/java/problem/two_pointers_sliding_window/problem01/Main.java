package problem.two_pointers_sliding_window.problem01;

import java.util.Scanner;

/**
 * 1. 두 배열 합치기
 * 설명
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 *
 * 출력
 * 오름차순으로 정렬된 배열을 출력합니다.
 */

public class Main {

    public int[] solution(int n, int m, int[] a, int[] b) {

        int[] answer = new int[n + m];
        int lt = 0;
        int rt = 0;
        int index = 0;

        while (lt < n && rt < m) {
            if (a[lt] < b[rt]) {
                answer[index++] = a[lt++];
            } else {
                answer[index++] = b[rt++];
            }
        }

        while (lt < n) {
            answer[index++] = a[lt++];
        }

        while (rt < m) {
            answer[index++] = b[rt++];
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
