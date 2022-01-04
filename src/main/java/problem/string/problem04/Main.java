package problem.string.problem04;

import java.util.Scanner;

/**
 * 4. 단어 뒤집기
 * 설명
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
 * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
 *
 * 출력
 * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 */

public class Main {

    public String solution(String str) {
        //return new StringBuilder(str).reverse().toString();

        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;

        while (lt < rt) {
            char temp = s[lt];
            s[lt] = s[rt];
            s[rt] = temp;
            lt++;
            rt--;
        }

        return String.valueOf(s);
    }

    public static void main(String[] args){

        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            String str = in.next();
            System.out.println(main.solution(str));
        }
    }
}
