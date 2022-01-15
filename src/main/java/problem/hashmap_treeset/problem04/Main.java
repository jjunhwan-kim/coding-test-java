package problem.hashmap_treeset.problem04;

import java.util.*;

/**
 * 4. 모든 아나그램 찾기
 * 설명
 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 *
 * 입력
 * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
 * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
 *
 * 출력
 * S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
 */

public class Main {

    public int solution(String str1, String str2) {

        int answer = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char c;
        int length = str2.length();

        for (int i = 0; i < length; i++) {
            c = str1.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);

            c = str2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        if (map1.equals(map2)) {
            answer++;
        }

        for (int i = length; i < str1.length(); i++) {

            c = str1.charAt(i - length);
            Integer v = map1.get(c);
            v--;
            if (v == 0) {
                map1.remove(c);
            } else {
                map1.put(c, v);
            }

            c = str1.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);

            if (map1.equals(map2)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);

        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.println(main.solution(str1, str2));
    }
}
