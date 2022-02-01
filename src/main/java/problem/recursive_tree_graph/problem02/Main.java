package problem.recursive_tree_graph.problem02;

/**
 * 2. 이진수 출력
 */

public class Main {

    /**
     * 2 | 11
     * 2 | 5 => 1
     * 2 | 2 => 1
     * 2 | 1 => 0
     *     0 => 1
     */
    public int solution(int n) {

        if (n == 0) {
            return 0;
        } else {
            return solution(n / 2) * 10 + n % 2;
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        for (int i = 1; i <= 11; i++) {
            System.out.println(main.solution(i));
        }
    }
}
