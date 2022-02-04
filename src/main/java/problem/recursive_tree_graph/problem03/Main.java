package problem.recursive_tree_graph.problem03;

/**
 * 3. 팩토리얼
 */

public class Main {

    public int factorial(int n) {

        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        System.out.println(main.factorial(5));
    }
}
