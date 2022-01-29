package problem.recursive_tree_graph.problem01;

/**
 * 1. 재귀함수(스택프레임)
 */

public class Main {

    public void DFS(int n) {
        if (n == 0) {
            return;
        }
        else {
            DFS(n - 1);
            System.out.println(n);
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        main.DFS(3);
    }
}
