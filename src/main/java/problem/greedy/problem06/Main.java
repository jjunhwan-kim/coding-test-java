package problem.greedy.problem06;

import java.util.*;

/**
 * 6. 친구인가? (Disjoint-Set : Union&Find)
 * 설명
 * 오늘은 새 학기 새로운 반에서 처음 시작하는 날이다. 현수네 반 학생은 N명이다. 현수는 각 학생들의 친구관계를 알고 싶다.
 * 모든 학생은 1부터 N까지 번호가 부여되어 있고, 현수에게는 각각 두 명의 학생은 친구 관계가 번호로 표현된 숫자쌍이 주어진다.
 * 만약 (1, 2), (2, 3), (3, 4)의 숫자쌍이 주어지면 1번 학생과 2번 학생이 친구이고, 2번 학생과 3번 학생이 친구, 3번 학생과 4번 학생이 친구이다.
 * 그리고 1번 학생과 4번 학생은 2번과 3번을 통해서 친구관계가 된다.
 * 학생의 친구관계를 나타내는 숫자쌍이 주어지면 특정 두 명이 친구인지를 판별하는 프로그램을 작성하세요.
 * 두 학생이 친구이면 “YES"이고, 아니면 ”NO"를 출력한다.
 *
 * 입력
 * 첫 번째 줄에 반 학생수인 자연수 N(1<=N<=1,000)과 숫자쌍의 개수인 M(1<=M<=3,000)이 주어지고,
 * 다음 M개의 줄에 걸쳐 숫자쌍이 주어진다.
 * 마지막 줄에는 두 학생이 친구인지 확인하는 숫자쌍이 주어진다.
 *
 * 출력
 * 첫 번째 줄에 “YES"또는 "NO"를 출력한다.
 */

public class Main {

    public int find(int[] map, int v1) {
        if (map[v1] == v1) {
            return map[v1];
        } else {
            return map[v1] = find(map, map[v1]);
        }
    }

    public void union(int[] map, int v1, int v2) {
        v1 = find(map, v1);
        v2 = find(map, v2);
        if (v1 != v2) {
            map[v1] = v2;
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] map = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            main.union(map, a, b);
        }
        int a = in.nextInt();
        int b = in.nextInt();
        if (main.find(map, a) == main.find(map, b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}