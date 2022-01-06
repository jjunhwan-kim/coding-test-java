package problem.array.problem03;

import java.util.Scanner;

/**
 * 3. 가위 바위 보
 * 설명
 * A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
 * 예를 들어 N=5이면
 * 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 * 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 *
 * 출력
 * 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
 */

public class Main {

    public String solution(int n, int[] a, int[] b) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                sb.append("D");
            } else if ((a[i] == 1 && b[i] == 3)
                    || (a[i] == 2 && b[i] == 1)
                    || (a[i] == 3 && b[i] == 2)) {
                sb.append("A");
            } else {
                sb.append("B");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        String result = main.solution(n, a, b);
        for (char c : result.toCharArray()) {
            System.out.println(c);
        }
    }
}
