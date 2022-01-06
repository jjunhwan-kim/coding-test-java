package problem.array.problem01;

import java.util.Scanner;

/**
 * 1. 큰 수 출력하기
 * 설명
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 * (첫 번째 수는 무조건 출력한다)
 *
 * 입력
 * 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
 *
 * 출력
 * 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
 */

public class Main {

    public String solution(int n, int[] numbers) {

        StringBuilder sb = new StringBuilder();

        sb.append(numbers[0]);
        sb.append(" ");

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i - 1]) {
                sb.append(numbers[i]);
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int numbers[] = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        System.out.println(main.solution(n, numbers));
    }
}
