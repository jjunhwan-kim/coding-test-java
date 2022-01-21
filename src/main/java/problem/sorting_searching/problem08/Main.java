package problem.sorting_searching.problem08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 8. 이분검색
 * 설명
 * 임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
 * 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.
 *
 * 입력
 * 첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
 * 두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
 *
 * 출력
 * 첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
 */

public class Main {

    public int solution(int n, int m, int[] arr) {

        int lt = 0;
        int rt = n - 1;

        Arrays.sort(arr);

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == m) {
                return mid + 1;
            } else if (arr[mid] < m) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(main.solution(n, m, arr));
    }
}
